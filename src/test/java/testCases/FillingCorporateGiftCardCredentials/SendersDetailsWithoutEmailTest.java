package testCases.FillingCorporateGiftCardCredentials;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;


public class SendersDetailsWithoutEmailTest extends BaseTestClass{
	
	@Test(groups= {"Regression"})
	public void sendersDetailsWithoutEmail() throws InterruptedException {
		logger = report.createTest("Senders Details Without Email Id");
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

		giftCardsPage.clickonBuyNowButton();
		String actualString = giftCardsPage. CredentialsWithoutEmailErrorMessage();
		Assert.assertEquals(actualString, "This is a mandatory field");
		logger.log(Status.PASS, "Error Message : " + actualString);
		
		captureCurrScreenshot("sendersDetailsWithoutEmail");
		
		driver.close();
		driver.switchTo().window(currWin);
	}
	

}
