package testCases.FillingCorporateGiftCardCredentials;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class SendersDetailsWithoutNameTest extends BaseTestClass {
	private static final Logger Logger = LogManager.getLogger(SendersDetailsWithoutNameTest.class);
	@Test(groups= {"Regression"})
	public void sendersDetailsWithoutName(){
		logger = report.createTest("Senders Details Without Name");
		Logger.info("Checking Warning Message Without Name");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		giftCardsPage.clickOnCorporateGiftCard();

		giftCardsPage.enterMobileNo("7002041998");
		giftCardsPage.enterValidEmailId("singhpushkar108@gmail.com");

		giftCardsPage.clickonBuyNowButton();
		String actualString = giftCardsPage. CredentialsWithoutNameErrorMessage();
		Assert.assertEquals(actualString, "This is a mandatory field");
		logger.log(Status.PASS, "Error Message : " + actualString);
		Logger.info("Error Message : " + actualString);
		
		captureCurrScreenshot("sendersDetailsWithoutName");
		
		driver.close();
		driver.switchTo().window(currWin);
	}
}
