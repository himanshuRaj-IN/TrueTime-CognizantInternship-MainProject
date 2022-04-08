package testCases.SearchResultFilters;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class FilterCabsByCabType extends BaseTestClass{
	private static final Logger Logger = LogManager.getLogger(FilterCabsByCabType .class);
	
	@Test(groups= {"Regression"})
	public void filterCabsByCabType() {
		logger = report.createTest("Filter Cabs By Cab Type");
		Logger.info("Filtering Cabs By Cab Type");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.enterFROMCity("Delhi");
		cabsPage.waitForSuggestions();
		cabsPage.selectFromSuggestion("Delhi, India");
		cabsPage.verifyFROMSelectedCity("Delhi, India");
		cabsPage.enterTOCity("Manali");
		cabsPage.waitForSuggestions();
		cabsPage.selectFromSuggestion("Manali, Himachal Pradesh, India");
		cabsPage.verifyTOSelectedCity("Manali, Himacha...");
		cabsPage.clickOnDepartureDate();
		cabsPage.selectDepatureDate("25/04/2022");
		cabsPage.verifyDepatureDate("25/04/2022");
		cabsPage.clickOnPickUpTime();
		cabsPage.selectPickuptime("06:30 AM");
		cabsPage.verifyPickupTime("06:30 AM");		
		searchPageCabs = cabsPage.clickOnSearchButton();
		searchPageCabs.verifySearchListPresent();
		searchPageCabs.filterBySuv();
		Logger.info("Filtering Cabs By Cabs Type---> Successful");
		
	}

}
