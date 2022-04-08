package testCases.FillingCorporateGiftCardCredentials;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class EmptySendersDetailsTest extends BaseTestClass {
	private static final Logger Logger = LogManager.getLogger(EmptySendersDetailsTest.class);
	
	
	@Test(groups= {"Smoke"})
	public void EmptysendersdetailsTest() throws InterruptedException {
		logger = report.createTest(" Blank Senders Details Check");
		Logger.info("Checking Warning message When Senders details are left empty");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		giftCardsPage.clickOnCorporateGiftCard();

		giftCardsPage.enterSendersName("");
		giftCardsPage.enterMobileNo("");
		giftCardsPage.enterValidEmailId("");

		giftCardsPage.clickonBuyNowButton();
		String actualString = giftCardsPage.emptyCredentialsErrorMessage();
		Assert.assertEquals(actualString, "This is a mandatory field");
		logger.log(Status.PASS, "Error Message : " + actualString);
		Logger.info("Error Message :" + actualString);
		driver.close();
		driver.switchTo().window(currWin);
	}
	

}
