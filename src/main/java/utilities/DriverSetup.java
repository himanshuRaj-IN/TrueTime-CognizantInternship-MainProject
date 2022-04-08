package utilities;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	
	/********************** Driver Setup *****************/
	public WebDriver driverSetup(WebDriver driver) {
		
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		Properties prop = objProp.readPropertiesFile();		
		try {
			if (prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (prop.getProperty("browserName").equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (prop.getProperty("browserName").equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			} 
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	

}
