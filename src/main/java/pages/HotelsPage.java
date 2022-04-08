package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PagesBaseClass;
import utilities.ReadPropertiesFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class HotelsPage extends PagesBaseClass{
	private static final Logger Logger = LogManager.getLogger(HotelsPage.class);
	Properties prop;
	public HotelsPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		prop = objProp.readPropertiesFile();
	}
	
	
	@FindBy(linkText = "Hotels")
	WebElement hotelsMenu;
	
	@FindBy(xpath= "//ul[@class=\"guestCounter font12 darkText\"][1]//li")
	List<WebElement> adultSelectOptionList;
	
	@FindBy(xpath= "//input[@id='guest']")
	WebElement clickOnRoomAndGuest;
	
	@FindBy(xpath="//div[@class=\"roomsGuests\"]")
	WebElement roomDetailsPopUp;
	
	
	/****************** Check Hotel Menu Option *************/
	
	public void CheckHotelMenuOption() {
		
		try {
			
			Assert.assertTrue(hotelsMenu.isDisplayed());
			logger.log(Status.PASS, "PASS : Hotel is present on Landing page.");
			Logger.info("PASS : Hotel is present on Landing page.");
			Assert.assertTrue(hotelsMenu.isEnabled());
			logger.log(Status.PASS, "PASS : hotel is Enabled on Landing page.");
			Logger.info("PASS : Hotel is Enabled on Landing page.");
			
		}catch (Exception e) {
			reportFail("Exception Occured -> "+e.getMessage());
			
	     }
	}
	
	
	/****************** Click on hotels Menu *************/
	
	public void ClickOnHotelMenu() {
		try {
			hotelsMenu.click();
			logger.log(Status.PASS,"Click on hotels Menu");
			Logger.info("Click on hotels Menu");
			
		}catch (Exception e) {
			reportFail("Exception Occured -> "+e.getMessage());
			
	     }
		
	}
	
	/****************** Verify Hotel Page URl *************/
	
	public void verifyHotelsPageURL() {
		try {
			String ExpectedURL= prop.getProperty("hotelsPageURL");
			String ActualURL=driver.getCurrentUrl();
			if (ActualURL.equals(ExpectedURL)) {
				reportPass("PASS : URL Verified [ Got ->" + ActualURL+" ]");
				logger.log(Status.PASS,"PASS : URL Verified [ Got ->" + ActualURL+" ]");
				Logger.info("PASS : URL Verified [ Got ->" + ActualURL+" ]");
			}else {
				reportFail("FAIL : URL Not Verified [ Got ->" + ExpectedURL+" ]");
				logger.log(Status.PASS,"FAIL : URL Not Verified [ Got ->" + ExpectedURL+" ]");
				Logger.info("FAIL : URL Not Verified [ Got ->" + ExpectedURL+" ]");
			}
		} catch (Exception e) {
				reportFail("Exception Occured -> "+e.getMessage());
		}
	}
	
	
	
	/****************** Click on Room and Guests *************/
	
	public void ClickOnRoomAndGuest() {
		try {
			clickOnRoomAndGuest.click();
			logger.log(Status.INFO, "Clicking on Room and Guests ");
			Logger.info("Clicking on Room and Guests ");
			
		}catch(Exception e) {
			reportFail("Exception Occured -> "+e.getMessage());
		}
		
	}
	
	
	/****************** Verify Room Details PopUp Shown or Not *************/
	
	public void verifyRoomDetailsPopUp() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElements(roomDetailsPopUp));
			logger.log(Status.PASS, "Room Detail Box is appeared for input value of adult  and children.");
			Logger.info("Room Detail Box is appeared for input value of adult  and children.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}	
	}
	
	public void getListOfNumbersForAdultPerson() {
		
		try{
			List<String>optionToSelectNumberForAdultPerson=new ArrayList<String>() ;
		
		    for(WebElement list:adultSelectOptionList) {
		       Logger.info(" Adult List Element --> "+list.getText());
			   optionToSelectNumberForAdultPerson.add(list.getText());
		    }
			
		    logger.log(Status.PASS, "List of available number of room for adult is print successfully.");
		    Logger.info("List of available number of room for adult is print successfully.");
		}catch (Exception e) {
			reportFail(e.getMessage());
		}	
		
	}
}