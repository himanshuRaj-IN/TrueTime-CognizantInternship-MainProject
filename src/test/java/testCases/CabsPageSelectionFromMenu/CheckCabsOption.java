package testCases.CabsPageSelectionFromMenu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import pages.CabsPage;
import pages.LandingPage;

public class CheckCabsOption extends BaseTestClass{
	private static final Logger Logger = LogManager.getLogger(CheckCabsOption.class);
	LandingPage landingPage;
	CabsPage cabsPage;
	
	
	@Test(groups= {"Smoke"})
	public void checkCabsOption() {
		Logger.info("Check Cabs Option Test Case initiated.");
		logger = report.createTest("Check Cabs Option");
		
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		landingPage.checkCabsOption();	
	}
		

}
