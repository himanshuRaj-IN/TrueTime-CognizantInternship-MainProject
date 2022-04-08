package testCases.FillingCabsDetails;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class SelectDepartureDate extends BaseTestClass{
	private static final Logger Logger = LogManager.getLogger(SelectDepartureDate.class);
	
	@Test(groups= {"Regression"})
	public void selectDepatureDate() {
		logger = report.createTest("Select Departure Date ");
		Logger.info("Departure Date Selection--->Successful");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.clickOnDepartureDate();
		cabsPage.selectDepatureDate("30/04/2022");
		cabsPage.verifyDepatureDate("30/04/2022");
	}
	

	

}
