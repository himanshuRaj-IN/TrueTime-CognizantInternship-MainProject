package testCases.FillingCorporateGiftCardCredentials;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.Status;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import utilities.CaptureScreenshot;

public class SendersDetailsWithInvalidEmailTest extends BaseTestClass {
	private static final Logger Logger = LogManager.getLogger(SendersDetailsWithInvalidEmailTest.class);
	@Test(groups= {"Regression"})
	public void sendersDetailsWithInValidEmail() throws InterruptedException {
		logger = report.createTest("Senders Details With InValid Email");
		Logger.info("Checking Warning Message With InValid Email");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		giftCardsPage.clickOnCorporateGiftCard();

		giftCardsPage.enterSendersName("Pushkar Singh");
		giftCardsPage.enterMobileNo("7002041998");
		giftCardsPage.enterInvalidEmailId("xyzgmail.com");

		giftCardsPage.clickonBuyNowButton();
		String actualString = giftCardsPage.getEmailErrorMessage();
		Assert.assertEquals(actualString, "Please enter a valid Email id.");
		logger.log(Status.PASS, "Error Message : " + actualString);
		Logger.info("Error Message : " + actualString);
		
		try {
			String	screenshot = CaptureScreenshot.captureScreenShot(driver, "sendersDetailsWithInValidEmail");
			logger.pass("Screenshot : "+ logger.addScreenCaptureFromPath(screenshot));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.close();
		driver.switchTo().window(currWin);
	}
}
