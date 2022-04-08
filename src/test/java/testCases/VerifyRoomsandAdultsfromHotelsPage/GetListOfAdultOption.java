package testCases.VerifyRoomsandAdultsfromHotelsPage;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import pages.CabsPage;
import pages.LandingPage;

public class GetListOfAdultOption extends BaseTestClass {
	private static final Logger Logger = LogManager.getLogger(GetListOfAdultOption.class);

	LandingPage landingPage;
	CabsPage cabsPage;

	@Test(groups= {"Regression"})
	public void listOfAdultOption() {
		logger = report.createTest("List of Adult option");
		Logger.info("List of numbers of adults in Room1");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		hotelsPage = landingPage.getHotelsPage();
		hotelsPage.ClickOnHotelMenu();
		hotelsPage.ClickOnRoomAndGuest();
		hotelsPage.getListOfNumbersForAdultPerson();
		Logger.info("Printing List of numbers of adults in Room 1 ---> Successful");
	}
}
