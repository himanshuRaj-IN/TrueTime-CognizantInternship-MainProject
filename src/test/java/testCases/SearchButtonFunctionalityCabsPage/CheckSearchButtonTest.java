package testCases.SearchButtonFunctionalityCabsPage;

import org.testng.annotations.Test;
import BaseClasses.BaseTestClass;
import BaseClasses.PagesBaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckSearchButtonTest extends BaseTestClass{
	private static final Logger Logger = LogManager.getLogger(CheckSearchButtonTest.class);
	@Test(groups= {"Regression"})
	public void checkSearchButton() {
		logger = report.createTest("Check Search button available and enabled.");
		Logger.info("Check Search button available and enabled.");
		PagesBaseClass objPagesBaseClass = new PagesBaseClass(driver, logger);
		landingPage = objPagesBaseClass.OpenApplication();
		landingPage.closeLoginPopUp();
		cabsPage = landingPage.getCabsPage();
		cabsPage.verifySearchButtonAvailable();
		Logger.info("Verification of  availability of Search button---> Successful");
		
	}

}
