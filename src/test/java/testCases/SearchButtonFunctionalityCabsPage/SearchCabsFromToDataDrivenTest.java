package testCases.SearchButtonFunctionalityCabsPage;

import java.util.Hashtable;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class SearchCabsFromToDataDrivenTest extends BaseTestClass{
	private static final Logger Logger = LogManager.getLogger(SearchCabsFromToDataDrivenTest.class);

	@Test(dataProvider = "FillingCabDetailsData", dataProviderClass = utilities.TestDataProvider.class,groups = "Regression")
	public void searchCabsFromToDataDrivenTest(Hashtable<String, String> table) {
		logger = report.createTest("Data Driven Search Cabs");
		Logger.info("Data Driven Search Cabs");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();		
		cabsPage.enterFROMCity(table.get("FROM"));
		cabsPage.waitForSuggestions();
		cabsPage.selectFromSuggestion(table.get("FROM Suggestion"));
		cabsPage.enterTOCity(table.get("TO"));
		cabsPage.waitForSuggestions();
		cabsPage.selectFromSuggestion(table.get("TO Suggestion"));
		cabsPage.clickOnDepartureDate();
		cabsPage.selectDepatureDate(table.get("DEPARTURE DATE"));
		cabsPage.verifyDepatureDate(table.get("DEPARTURE DATE"));
		cabsPage.clickOnPickUpTime();
		cabsPage.selectPickuptime(table.get("PICK UP TIME"));
		cabsPage.verifyPickupTime(table.get("PICK UP TIME"));		
		searchPageCabs = cabsPage.clickOnSearchButton();
		searchPageCabs.verifySearchListPresent();
		Logger.info("Data Driven Search Cabs Test---> Successful");
}
}