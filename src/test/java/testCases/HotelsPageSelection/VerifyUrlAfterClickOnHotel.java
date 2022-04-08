package testCases.HotelsPageSelection;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import pages.CabsPage;
import pages.HotelsPage;
import pages.LandingPage;


public class VerifyUrlAfterClickOnHotel extends BaseTestClass{
	private static final Logger Logger = LogManager.getLogger(VerifyUrlAfterClickOnHotel.class);
	LandingPage landingPage;
	CabsPage cabsPage;
	HotelsPage hotelsPage;
	
	
	@Test(groups= {"Smoke"})
	public void verifyUrlOfHotel() {
		logger = report.createTest("Verify Url of  Hotel Option");
		Logger.info("Verify Url of  Hotel Option");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		hotelsPage=landingPage.getHotelsPage();
		hotelsPage.ClickOnHotelMenu();	
		hotelsPage.verifyHotelsPageURL();
		Logger.info("Verification of URL of  Hotels Option---> Successful");
	}
}
