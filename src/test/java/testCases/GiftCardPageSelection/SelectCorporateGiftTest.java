package testCases.GiftCardPageSelection;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class SelectCorporateGiftTest extends BaseTestClass {
	private static final Logger Logger = LogManager.getLogger(SelectCorporateGiftTest.class);
		
	@Test(groups= {"Smoke"})
	public void selectCorporateGiftTest() throws InterruptedException {
		logger = report.createTest("Navigate Corporate Gift Cards Page");
		Logger.info("Navigate Corporate Gift Cards Page Test initiated.");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		String currWin = driver.getWindowHandle();
		giftCardsPage = landingPage.getGiftCardsPage();
		giftCardsPage.shiftDriverToCardsPage();
		giftCardsPage.verifyGiftCardsPageURL();
		giftCardsPage.clickOnCorporateGiftCard();	
		Logger.info("Navigation to Corporate Gift Cards Page --> Successful ");
		driver.close();
		driver.switchTo().window(currWin);
		
	}
	

}
