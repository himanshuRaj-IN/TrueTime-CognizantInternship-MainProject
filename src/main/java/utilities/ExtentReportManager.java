package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;


public class ExtentReportManager {
	
	//public static ExtentHtmlReporter htmlReporter;
		public static ExtentReports report;
		
		public static ExtentReports getReportInstance(){
			
			if(report == null){
				String reportName = DateUtil.getTimeStamp() + ".html";
//				String reportName = "TestReport" + ".html";
				ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(".\\test-output\\"+ reportName);
				report =  new ExtentReports();
				report.attachReporter(htmlReporter);
				
				report.setSystemInfo("OS", "Windows 10");
				report.setSystemInfo("Environment", "UAT");
				report.setSystemInfo("Build Number", "10.8.1");
				ReadPropertiesFile obj = new ReadPropertiesFile();
				String BrowserName = obj.readPropertiesFile().getProperty("browserName");
				report.setSystemInfo("Browser",BrowserName);
				
				htmlReporter.config().setDocumentTitle("BookCabs");
				htmlReporter.config().setReportName("Books cabs one station");
				htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
				htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
			}
			
			return report;
		}

}
