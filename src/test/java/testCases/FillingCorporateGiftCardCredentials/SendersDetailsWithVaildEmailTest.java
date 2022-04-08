package testCases.FillingCorporateGiftCardCredentials;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class SendersDetailsWithVaildEmailTest extends BaseTestClass {
	private static final Logger Logger = LogManager.getLogger(SendersDetailsWithVaildEmailTest.class);
	@Test(groups= {"Smoke"})
	public void sendersDetailsWithValidEmail() throws InterruptedException {
		logger = report.createTest("Senders Details With Valid Email");
		Logger.info("Senders Details With Valid Email");
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
		giftCardsPage.enterValidEmailId("xyz@gmail.com");
		Thread.sleep(5000);
		giftCardsPage.clickonBuyNowButton();
		boolean flag = giftCardsPage.isRedirectedToPaymentPage();
		Assert.assertEquals(flag, true);
		driver.close();
		driver.switchTo().window(currWin);
	}

}
