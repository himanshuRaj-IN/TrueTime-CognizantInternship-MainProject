package testCases.HotelsPageSelection;

import org.testng.annotations.Test;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import pages.CabsPage;
import pages.HotelsPage;
import pages.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckHotelOption extends BaseTestClass {
	private static final Logger Logger = LogManager.getLogger(CheckHotelOption.class);
	
	LandingPage landingPage;
	CabsPage cabsPage;
	HotelsPage hotelsPage;
	
	
	@Test(groups= {"Smoke"})
	public void checkHotelOption() {
		logger = report.createTest("Check Hotel Option");
		Logger.info("Checking Hotels Option");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		hotelsPage=landingPage.getHotelsPage();
		hotelsPage.CheckHotelMenuOption();	
		Logger.info("Hotel option Verification---> Successful");
	}

}
