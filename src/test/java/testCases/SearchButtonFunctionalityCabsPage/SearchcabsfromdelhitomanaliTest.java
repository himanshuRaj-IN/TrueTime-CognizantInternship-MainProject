package testCases.SearchButtonFunctionalityCabsPage;

import org.testng.annotations.Test;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchcabsfromdelhitomanaliTest extends BaseTestClass{
	private static final Logger Logger = LogManager.getLogger(SearchcabsfromdelhitomanaliTest.class);
	
	@Test(groups= {"Regression"})
	public void searchcabsfromdelhitomanali() {
		logger = report.createTest("Search Cabs from Delhi to Manali ");
		Logger.info("Searching Cabs from Delhi to Manali ");
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
		cabsPage.selectDepatureDate("21/04/2022");
		cabsPage.verifyDepatureDate("21/04/2022");
		cabsPage.clickOnPickUpTime();
		cabsPage.selectPickuptime("06:30 AM");
		cabsPage.verifyPickupTime("06:30 AM");		
		searchPageCabs = cabsPage.clickOnSearchButton();
		searchPageCabs.verifySearchListPresent();
		Logger.info("Searching Cabs from Delhi to Manali---> Successful");
		
	}

}
