package testCases.FillingCabsDetails;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;

public class CitySelection_FROMTest extends BaseTestClass {
	private static final Logger Logger = LogManager.getLogger(CitySelection_FROMTest.class);
		
	@Test(groups= {"Regression"})
	public void citySelection_FROM() {
		logger = report.createTest("FROM City Selection");
		Logger.info("'FROM'City Selection test case is initiated.");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.enterFROMCity("Delhi");
		cabsPage.waitForSuggestions();
		cabsPage.selectFromSuggestion("Delhi, India");
		cabsPage.verifyFROMSelectedCity("Delhi, India");
	}
	
}
