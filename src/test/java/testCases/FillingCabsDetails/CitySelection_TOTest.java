package testCases.FillingCabsDetails;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class CitySelection_TOTest extends BaseTestClass {
	private static final Logger Logger = LogManager.getLogger(CitySelection_TOTest.class);
	
	@Test(groups= {"Regression"})
	public void citySelection_TO() {
		logger = report.createTest("TO City Selection");
		Logger.info("TO City Selection---> Successful");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.clickOnToCity();
		cabsPage.enterTOCity("Manali");
		cabsPage.waitForSuggestions();
		cabsPage.selectFromSuggestion("Manali, Himachal Pradesh, India");
		cabsPage.verifyTOSelectedCity("Manali, Himacha...");
	}

}
