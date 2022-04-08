package testCases.GiftCardPageSelection;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class NavigateGiftCardsPageTest extends BaseTestClass{
	private static final Logger Logger = LogManager.getLogger(NavigateGiftCardsPageTest.class);
	@Test(groups= {"Smoke"})
	public void navigateGiftCardsPageTest() {
		logger = report.createTest("Navigate Gift Cards Page");
		Logger.info(" Navigate Gift Cards Page Test initiated" );
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		Logger.info(" Gift Cards Page URL verfication---> Successful");
		driver.close();
		driver.switchTo().window(currWin);
}

}
