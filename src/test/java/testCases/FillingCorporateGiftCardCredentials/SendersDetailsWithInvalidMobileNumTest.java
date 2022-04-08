package testCases.FillingCorporateGiftCardCredentials;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class SendersDetailsWithInvalidMobileNumTest extends BaseTestClass {
	private static final Logger Logger = LogManager.getLogger(SendersDetailsWithInvalidMobileNumTest.class);

	
	@Test(groups= {"Regression"})
	public void sendersDetailsWithInValidMobileNumber() {
		logger = report.createTest("Senders Details With InValid Mobile Number");
		Logger.info("Senders Details With InValid Mobile Number");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		giftCardsPage.clickOnCorporateGiftCard();

		giftCardsPage.enterSendersName("Pushkar Singh");
		giftCardsPage.enterMobileNo("700204199899999");
		giftCardsPage.enterValidEmailId("xyz@gmail.com");

		giftCardsPage.clickonBuyNowButton();
		String actualString = giftCardsPage.getMobileNumberErrorMessage();
		Assert.assertEquals(actualString, "Please enter a valid mobile number");
		logger.log(Status.PASS, "Error Message : " + actualString);
		Logger.info("Error Message : " + actualString);
		captureCurrScreenshot("sendersDetailsWithInValidMobileNumber");
		
		driver.close();
		driver.switchTo().window(currWin);
	}
}
