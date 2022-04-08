package BaseClasses;

import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilities.ReadPropertiesFile;

public class PagesBaseClass {
	private static final Logger Logger = LogManager.getLogger(PagesBaseClass.class);
	public WebDriver driver;
	public ExtentTest logger;
	public Properties prop ;
	
	/*************************** CONSTRUCTOR ************************/
	public PagesBaseClass(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	
	/******************** Open Application *************************/
	public void SetupDriver() {
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		Properties prop = objProp.readPropertiesFile();
			 
		driver.get(prop.getProperty("baseURL"));
		String msg = "";
		logger.log(Status.INFO, msg);
		Logger.info(msg);
		
	}
	
	
	/*********************** Report Fail  ****************************/
	public void reportFail(String reportString){
		logger.log(Status.FAIL, reportString);
		Assert.fail(reportString);
	}

	/*********************** Report Pass ****************************/
	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

}
