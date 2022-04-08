package pages;

import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
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

public class GiftCardsPage extends PagesBaseClass {
	Properties prop;
	private static final Logger Logger = LogManager.getLogger(GiftCardsPage.class);
	public GiftCardsPage(WebDriver ldriver, ExtentTest logger) {
		super(ldriver, logger);
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		prop = objProp.readPropertiesFile();

	}

	@FindBy(xpath = "//p[contains(text(),'Corporate Gift Card')]")
	WebElement CorporateGiftCard_Element;

	@FindBy(xpath = "//input[@name=\"senderName\"]")
	WebElement SendersName_Element;

	@FindBy(xpath = "//input[@name=\"senderMobileNo\"]")
	WebElement SendersMobileNum_Element;

	@FindBy(xpath = "//input[@name=\"senderEmailId\"]")
	WebElement sendersEmailiD_Element;

	@FindBy(xpath = "//button")
	WebElement buyNowButton_Element;

	@FindBy(xpath = "//span[text()='Payment options']")
	WebElement paymentOptionLabel_Element;

	@FindBy(xpath = "//p[@class='red-text font11 append-top5']")
	WebElement errorMessageDisplay_Element;
	
	@FindBy(xpath = "//p[@class='red-text font11 append-top5']")
	WebElement mobileNumbererrorMessageDisplay_Element;
	
	@FindBy(xpath = "//p[@class='red-text font11 append-top5']")
	WebElement emptycredentials_Element;
	
	@FindBy(xpath = "//p[@class='red-text font11 append-top5']")
	WebElement sendersDetailsWithoutName_Element ;
	
	
	@FindBy(xpath = "//p[@class='red-text font11 append-top5']")
	WebElement sendersDetailsWithoutMobileNumber_Element ;
	
	
	@FindBy(xpath = "//p[@class='red-text font11 append-top5']")
	WebElement sendersDetailsWithoutEmail_Element ;
	
	
	
	

	public void shiftDriverToCardsPage() {
		try {
			logger.log(Status.INFO, "Shifting driver focus to the Gift cards page ");
			Logger.info("Shifting driver focus to the Gift cards page ");
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);

			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	public void verifyGiftCardsPageURL() {
		try {
			String ExpectedURL = prop.getProperty("giftCardPageURL");
			String ActualURL = driver.getCurrentUrl();
			Assert.assertEquals(ActualURL, ExpectedURL);
			logger.log(Status.PASS, "PASS : URL Verified [ Got -> " + ActualURL + " ]");
			Logger.info("PASS : URL Verified [ Got -> " + ActualURL + " ]");
			

		} catch (Exception e) {
			reportFail("Exception Occured -> " + e.getMessage());
		}
	}

	/******************** Select corporate Gift Card ******************************/
	public void clickOnCorporateGiftCard() {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", CorporateGiftCard_Element);
			logger.log(Status.PASS, "Clicked on corporate Gift Card");
			Logger.info("Clicked on corporate Gift Card");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/******** Enter Senders Name in corporate gift card ************/
	public void enterSendersName(String Name) {
		try {

			SendersName_Element.sendKeys(Name);

			logger.log(Status.PASS, "Entered the Senders Name");
			Logger.info("Entered the Senders Name");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/*********** Enter Mobile No in Corporate Gift Card **********/
	public void enterMobileNo(String MobileNumber) {
		try {

			SendersMobileNum_Element.sendKeys(MobileNumber);
			logger.log(Status.PASS, "Entered the Mobile No");
			Logger.info("Entered the Mobile No");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/******** Enter Valid Email Id in Corporate Gift Card ********/
	public void enterValidEmailId(String emailId) {
		try {

			sendersEmailiD_Element.sendKeys(emailId);

			logger.log(Status.PASS, "Entered the Valid Email ID");
			Logger.info("Entered the Valid Email ID");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	/******** Enter Invalid Email Id in Corporate Gift Card ********/
	public void enterInvalidEmailId(String emailId) {
		try {

			sendersEmailiD_Element.sendKeys(emailId);

			logger.log(Status.PASS, "Entered the Invalid Email ID");
			Logger.info("Entered the invalid Email ID");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/******* Click on Buy Now Button *******************/
	public void clickonBuyNowButton() {
		try {

			buyNowButton_Element.click();
			logger.log(Status.PASS, "Clicked on Buy Now Button");
			Logger.info("Clicked on Buy Now Button");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/*************** Verify payment page *******************/
	public boolean isRedirectedToPaymentPage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(paymentOptionLabel_Element));
			String str = paymentOptionLabel_Element.getText();
			if (str.equals("Payment options")) {
				logger.log(Status.PASS, "Redirected to the payment page.");
				Logger.info("Redirected to the payment page.");
				return true;
			} else {
				logger.log(Status.INFO, "Redirected to the payment page Failed .");
				Logger.info("Redirected to the payment page Failed .");
				return false;
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return false;
	}

	/************** get Email Error Message **************/
	public String getEmailErrorMessage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(errorMessageDisplay_Element));
			String str = errorMessageDisplay_Element.getText();
			logger.log(Status.INFO, "Getting Email error message");
			Logger.info("Getting Email error message");
			return str;

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return null;
	}
	/************** get Mobile Number Error Message **************/
	public String getMobileNumberErrorMessage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(mobileNumbererrorMessageDisplay_Element));
			String str = mobileNumbererrorMessageDisplay_Element.getText();
			logger.log(Status.INFO, "Getting Mobile Number error message");
			Logger.info("Getting Mobile Number error message");
			return str;

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return null;
	}
	
	/*********** Empty Credentials Error Message***********/
	public String emptyCredentialsErrorMessage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOf(emptycredentials_Element));
			String str = emptycredentials_Element.getText();
			logger.log(Status.INFO, "Getting Empty Credentials error message");
			Logger.info("Getting Empty Credentials error message");
			return str;

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return null;
	}
	
	/*************Senders Details Without Name****************/

	public String CredentialsWithoutNameErrorMessage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOf(sendersDetailsWithoutName_Element));
			String str = sendersDetailsWithoutName_Element.getText();
			logger.log(Status.INFO, "Getting error message when no name is provided");
			Logger.info("Getting error message when no name is provided");
			return str;

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return null;
	}
	/*********Senders Details Without Mobile Number *********/
	
	public String CredentialsWithoutMobileNumErrorMessage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOf(sendersDetailsWithoutMobileNumber_Element));
			String str = sendersDetailsWithoutMobileNumber_Element.getText();
			logger.log(Status.INFO, "Getting error message when no mobile number is provided");
			Logger.info("Getting error message when no mobile number is provided");
			return str;

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return null;
	}
	
/*********Senders Details Without Email Id *********/
	
	public String CredentialsWithoutEmailErrorMessage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(sendersDetailsWithoutEmail_Element ));
			String str = sendersDetailsWithoutEmail_Element .getText();
			logger.log(Status.INFO, "Getting error message when no Email is provided");
			Logger.info("Getting error message when no Email is provided");
			return str;

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return null;
	}
	
}
