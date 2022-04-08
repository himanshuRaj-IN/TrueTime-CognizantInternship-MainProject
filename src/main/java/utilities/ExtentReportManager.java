package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;


public class ExtentReportManager {
	
		public static ExtentReports report;
		
		/************************ Get Extents Report Instance ********************************/
		public static ExtentReports getReportInstance(){
			
			if(report == null){
				String reportName = DateUtil.getTimeStamp() + ".html";
				ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(".\\test-output\\"+ reportName);
				report =  new ExtentReports();
				report.attachReporter(htmlReporter);
				
				report.setSystemInfo("OS", "Windows 10");
				report.setSystemInfo("Environment", "UAT");
				report.setSystemInfo("Build Number", "0.0.1");
				ReadPropertiesFile obj = new ReadPropertiesFile();
				String BrowserName = obj.readPropertiesFile().getProperty("browserName");
				report.setSystemInfo("Browser",BrowserName);
				
				htmlReporter.config().setDocumentTitle("True Time");
				htmlReporter.config().setReportName("Be.Congnizant Web App True Time");
				htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
				htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
			}
			
			return report;
		}

}
