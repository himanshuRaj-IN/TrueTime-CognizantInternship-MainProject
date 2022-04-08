package testCases.FillingCorporateGiftCardCredentials;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class SendersDetailsWithoutMobileNumTest extends BaseTestClass{
	
	
	@Test(groups= {"Regression"})
	public void sendersDetailsWithoutMobileNum() throws InterruptedException {
		logger = report.createTest("Senders Details Without Mobile Number");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		giftCardsPage.clickOnCorporateGiftCard();

		giftCardsPage.enterSendersName("Pushkar Singh");
		giftCardsPage.enterValidEmailId("singhpushkar108@gmail.com");

		giftCardsPage.clickonBuyNowButton();
		String actualString = giftCardsPage.CredentialsWithoutMobileNumErrorMessage();
		Assert.assertEquals(actualString, "This is a mandatory field");
		logger.log(Status.PASS, "Error Message : " + actualString);
		
		captureCurrScreenshot("sendersDetailsWithoutMobileNum");
		
		driver.close();
		driver.switchTo().window(currWin);
	}

}
