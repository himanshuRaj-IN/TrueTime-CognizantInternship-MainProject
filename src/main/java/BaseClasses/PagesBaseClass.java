package BaseClasses;

import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import pages.LandingPage;
import utilities.ReadPropertiesFile;

public class PagesBaseClass {
	private static final Logger Logger = LogManager.getLogger(PagesBaseClass.class);
	public WebDriver driver;
	public ExtentTest logger;
	public Properties prop ;
	

	public PagesBaseClass(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	/********************Open Application*************************/
	public LandingPage OpenApplication() {
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		Properties prop = objProp.readPropertiesFile();
			 
		driver.get(prop.getProperty("baseURL"));
		String msg = "Landed on MakeMyTrip Landing page.";
		logger.log(Status.INFO, msg);
		Logger.info(msg);
		LandingPage landingPage = new LandingPage(driver, logger);
		PageFactory.initElements(driver,landingPage);
		return landingPage;
	}
	
	
	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString){
		logger.log(Status.FAIL, reportString);
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

}
