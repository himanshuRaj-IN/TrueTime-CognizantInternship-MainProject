package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PagesBaseClass;
import utilities.ReadPropertiesFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchPageCabs extends PagesBaseClass {
	private static final Logger Logger = LogManager.getLogger(SearchPageCabs.class);
	Properties prop;

	public SearchPageCabs(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		prop = objProp.readPropertiesFile();
	}

	@FindBy(id = "List")
	WebElement searchList_Element;

	@FindBy(xpath = "//label[contains(text(),'SUV')]")
	WebElement suv_Element;
	
	@FindBy(xpath ="//span[@class = 'paddingLR8 maxSize12 arrow arrow-down-wide']" )
	WebElement sortedBy_Element;
	
	@FindBy(xpath = "//p[text()='Price']")
	WebElement priceFilter_Element;
	
	@FindBys(@FindBy(xpath="//p[@class ='font28 latoBlack blackText ']"))
	public List<WebElement> price_Elements;
	
	
	/************************* Verify Search List Present ****************/
	public void verifySearchListPresent() {
		try {
			searchList_Element.isDisplayed();
			logger.log(Status.PASS, "Search List  appeared ");
			Logger.info("Search List  appeared ");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/************************* Select SUV Cab Type ****************************/
	public void filterBySuv() {
		try {
			suv_Element.click();
			logger.log(Status.PASS, "Selected SUV in cab type.");
			Logger.info("Selected SUV in cab type.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	/************************Filter cabs by Price (Lowest to Highest)*************/
	public void filterByPriceLH() {
		try {
			sortedBy_Element.click();
			logger.log(Status.PASS, "Clicked on the Sorted by dropdown arrow.");
			Logger.info("Clicked on the Sorted by dropdown arrow.");
			priceFilter_Element.click();
			logger.log(Status.PASS, "Price Lowest to Highest filter is selected.");
			Logger.info("Price Lowest to Highest filter is selected.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	/******************** Verify Price filtered Result *********************************/
	public void verifyfiteredResult() {
		try {
			List<Integer> prices = new ArrayList<Integer>();
			for (WebElement element	 : price_Elements) {
				String temp = element.getText();				
				temp = temp.replace(",", "");
				temp = temp.substring(2);
				prices.add(Integer.parseInt(temp));
			}
			boolean flag = false;
			for (int i = 0; i < prices.size()-1; i++) {
				if(prices.get(i)<prices.get(i+1)) {
					flag= true;
				}else {
					flag= false;
				}				
			}
			
			for (Integer price : prices) {
				logger.log(Status.INFO, "Available Cabs at Price : "+Integer.toString(price));
				Logger.info("Available Cabs at Price : "+Integer.toString(price));
			}
			Assert.assertEquals(true, flag);
			logger.log(Status.PASS, "Price verified");
			Logger.info("Price verified");
			logger.log(Status.PASS,"Lowest Price Available is : "+prices.get(0));
			Logger.info("Lowest Price Available is : "+prices.get(0));
			System.out.println(prices);
			
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	
}
