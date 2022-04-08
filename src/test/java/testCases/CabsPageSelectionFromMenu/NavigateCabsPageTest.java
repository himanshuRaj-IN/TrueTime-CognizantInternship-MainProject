package testCases.CabsPageSelectionFromMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.Test;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import pages.CabsPage;
import pages.LandingPage;


public class NavigateCabsPageTest extends BaseTestClass{
	private static final Logger Logger = LogManager.getLogger(NavigateCabsPageTest.class);

	LandingPage landingPage;
	CabsPage cabsPage;
	
	@Test(groups= {"Smoke"})
	public void navigateCabsPageTest() {
		Logger.info("Navigate Cabs Page Test Case initiated.");
		logger = report.createTest("Navigate Cab Page");
		
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.verifyCabsPageURL();
		cabsPage.verifySubHeading();
		cabsPage.verifyCabsPageURL();
	}
}
