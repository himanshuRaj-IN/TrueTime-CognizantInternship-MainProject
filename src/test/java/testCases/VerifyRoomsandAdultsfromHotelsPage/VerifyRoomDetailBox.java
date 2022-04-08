package testCases.VerifyRoomsandAdultsfromHotelsPage;

import org.testng.annotations.Test;

import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import pages.CabsPage;
import pages.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VerifyRoomDetailBox extends BaseTestClass {
	private static final Logger Logger = LogManager.getLogger(VerifyRoomDetailBox.class);

	LandingPage landingPage;
	CabsPage cabsPage;
	
	
	@Test(groups= {"Regression"})
	public void checkRoomDetailBox() {
		logger = report.createTest("Verify Room and Guest box ");
		Logger.info("Verify Room and Guest box");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		hotelsPage=landingPage.getHotelsPage();
		hotelsPage.ClickOnHotelMenu();	
		hotelsPage.ClickOnRoomAndGuest();	
		hotelsPage.verifyRoomDetailsPopUp();
		Logger.info("Verification of Room and Guest box---> Successful");
	}
}
