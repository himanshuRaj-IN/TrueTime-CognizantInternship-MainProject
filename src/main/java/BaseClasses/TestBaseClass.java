package BaseClasses;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import utilities.CaptureScreenshot;
import utilities.DriverSetup;
import utilities.ExtentReportManager;

public class TestBaseClass {
	public  static org.openqa.selenium.WebDriver driver;
	public  static ExtentTest logger;
	public  static ExtentReports report;
	
	private static final Logger Logger = LogManager.getLogger(TestBaseClass.class);
	
	@BeforeSuite(alwaysRun = true)
	public void setup() {
		Logger.info("Invoking Browser ......... ");
		invokeBrowser();
		Logger.info("Creating Extent Report instance ........");
		report = ExtentReportManager.getReportInstance();
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		Logger.info("Tear Down Method Invoked. ");
		Logger.info("Quiting Driver.....");
		driver.quit();
		Logger.info("Flushing Report.");
		report.flush();
	}
	
	@AfterMethod
	public void setTestResult(ITestResult result) throws IOException {
		
		String	screenshot = CaptureScreenshot.captureScreenShot(driver, CaptureScreenshot.generateFileName(result));
		Logger.info("Screenshot captured.");
		if(result.getStatus() == ITestResult.FAILURE) {
			Logger.warn(result.getName()+" : FAILLED");
			logger.log(Status.FAIL,result.getName()+"  : FAILLED");
			logger.log(Status.FAIL,result.getThrowable());	
			logger.fail("Screenshot : "+ logger.addScreenCaptureFromPath(screenshot));
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			Logger.info(result.getName()+" : PASSED");
			logger.log(Status.PASS, result.getName() + "  : PASSED");
			logger.pass("Screenshot : "+ logger.addScreenCaptureFromPath(screenshot));
		}else if(result.getStatus() == ITestResult.SKIP) {
			Logger.warn(result.getName()+" : SKIPPED ");
			logger.skip(result.getName());
		}
	}
	
	public void invokeBrowser() {
		Logger.info("invoking Browser ....");
		DriverSetup driverSetupObjDriverSetup = new DriverSetup();
		driver = driverSetupObjDriverSetup.driverSetup(driver);
	}
	
	public void captureCurrScreenshot(String name) {
		Logger.info("Capturing currentscreenshot ....");
		try {
			String	screenshot = CaptureScreenshot.captureScreenShot(driver, "SendersDetailsWithoutMobileNumTest");
			logger.pass("Screenshot : "+ logger.addScreenCaptureFromPath(screenshot));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}