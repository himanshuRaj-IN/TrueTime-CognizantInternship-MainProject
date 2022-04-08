package testCases.FillingCabsDetails;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

    public class PickupTimeSelection extends BaseTestClass {
	private static final Logger Logger = LogManager.getLogger(PickupTimeSelection.class);
	
	@Test(groups= {"Smoke"})
	public void pickupTimeSelection() {
		logger = report.createTest("Select Pickup-Time");
		Logger.info("Pickup-Time is Selection:--->Successful");		
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.clickOnPickUpTime();
		cabsPage.selectPickuptime("06:30 AM");
		cabsPage.verifyPickupTime("06:30 AM");
	}

}
