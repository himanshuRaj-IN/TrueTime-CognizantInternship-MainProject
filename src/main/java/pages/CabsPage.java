package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClasses.PagesBaseClass;
import utilities.ReadPropertiesFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CabsPage extends PagesBaseClass {
	private static final Logger Logger = LogManager.getLogger(CabsPage.class);
	Properties prop;

	public CabsPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		ReadPropertiesFile objProp = new ReadPropertiesFile();
		prop = objProp.readPropertiesFile();
	}

	@FindBy(xpath = "//a[text()='Cab Booking']")
	WebElement subHeading_Element;

	@FindBy(css ="input#fromCity")
	WebElement FROMInput_Element;

	@FindBy(xpath = "//input[@placeholder='From']")
	WebElement FROMPlaceholder_Element;

	@FindBy(css = "input#toCity")
	WebElement TOInput_Element;

	@FindBy(xpath = "//input[@placeholder='To']")
	WebElement TOPlaceholder_Element;

	@FindBys(@FindBy(className = "react-autosuggest__suggestion"))
	public List<WebElement> suggestionList_Elements;

	@FindBy(xpath = "//p[contains(text(),'SUGGESTIONS')]") // Not in Use Right now 17:23:24
	WebElement suggestionLebel_Element;

	@FindBy(xpath = "//span[contains(text(),'PICKUP-TIME')]")
	WebElement pickuupInput_Elementl;

	@FindBys(@FindBy(xpath = "//ul[@class='timeDropDown blackText']/li"))
	public List<WebElement> selectPickupDate_Elements;

	@FindBy(xpath = "//input[@id='pickupTime']/following-sibling::*")
	public WebElement verifypicupDate_element;

	@FindBy(xpath = "//span[contains(text(),'DEPARTURE')]")
	WebElement departureDateLabel_Element;

	@FindBy(xpath = "(//div[@class='DayPicker-Caption'])[1]")
	WebElement monthYear_Element;

//	String day;
//	@FindBy(xpath = "(//div[contains(text(),'"+day+"')])[1]")
//	WebElement date_Element;

	@FindBy(xpath = "(//span[@role = 'button'])[2]")
	WebElement nextMonthButton_Element;

	@FindBy(xpath = "(//span[@role = 'button'])[1]")
	WebElement previousMonthButton_Element;

	@FindBy(xpath = "(//input[@id='departure']/following-sibling::*)[1]")
	WebElement verifyDepature_Element;

	@FindBy(xpath = "//a[text()='Search']")
	WebElement searchButton_Element;

//########################################################################################################################	

	/******************** Verify URL Of Cabs Page ****************/
	public void verifyCabsPageURL() {

		try {
			String ExpectedURL = prop.getProperty("cabsPageURL");
			String ActualURL = driver.getCurrentUrl();
			Assert.assertEquals(ActualURL, ExpectedURL);
			logger.log(Status.PASS, "PASS : URL Verified [ Got -> " + ActualURL + " ]");
			Logger.info("PASS : URL Verified [ Got -> " + ActualURL + " ]");
		} catch (Exception e) {
			reportFail("Exception Occured -> " + e.getMessage());
		}

	}

	/******************** Verify Sub Heading Of Cabs Page ****************/
	public void verifySubHeading() {
		try {
			String ExpectedTitle = prop.getProperty("cabsPageSubHeading");
			String ActualTitle = subHeading_Element.getText();
			Assert.assertEquals(ActualTitle, ExpectedTitle);
			logger.log(Status.PASS, "PASS : Sub heading Verified [ Got -> " + ActualTitle + " ]");
			Logger.info( "PASS : Sub heading Verified [ Got -> " + ActualTitle + " ]");
		} catch (Exception e) {
			reportFail("Exception Occured -> " + e.getMessage());
		}

	}

	/********************* Enter FROM city ******************/
	public void enterFROMCity(String city) {
		try {
			FROMInput_Element.click();
			logger.log(Status.INFO, "Clicked on FROM City Lebel");
			Logger.info("Clicked on FROM City Lebel");
			for (int i = 0; i < city.length(); i++) {
				Thread.sleep(200);
				FROMPlaceholder_Element.sendKeys(Character.toString(city.charAt(i)));
			}
			logger.log(Status.INFO, "Entered " + city + " in appeared placeholder.");
			Logger.info("Entered " + city + " in appeared placeholder.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Wait Till Suggestion ********************/
	public void waitForSuggestions() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElements(suggestionList_Elements));
			logger.log(Status.INFO, "Suggestions appeared for input.");
			Logger.info("Suggestions appeared for input.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Select City From Suggestion *************/
	public void selectFromSuggestion(String selectCity) {
		try {
			boolean falg = false;
			for (WebElement element : suggestionList_Elements) {
				if (element.getText().equals(selectCity)) {
					WebElement targetElement = element;
					targetElement.click();
					falg = true;
					break;
				}
			}
			Assert.assertTrue(falg);
			logger.log(Status.PASS, "City Selected from suggestions.");
			Logger.info("City Selected from suggestions.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/************ Verify Select From city *********************/
	public void verifyFROMSelectedCity(String expectedCity) {
		try {
			Assert.assertEquals(FROMInput_Element.getAttribute("value"), expectedCity);
			logger.log(Status.PASS, "Selected city is verified");
			Logger.info("Selected city is verified");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/******************** Click on To city ********************/
	public void clickOnToCity() {
		try {
			TOInput_Element.click();
			logger.log(Status.INFO, "Clicked on To City Lebel");
			Logger.info("Clicked on To City Lebel");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/********************* Enter To city ******************/
	public void enterTOCity(String city) {
		try {
			for (int i = 0; i < city.length(); i++) {
				Thread.sleep(200);
				TOPlaceholder_Element.sendKeys(Character.toString(city.charAt(i)));
			}
			logger.log(Status.INFO, "Entered " + city + " in appeared placeholder.");
			Logger.info("Entered " + city + " in appeared placeholder.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/************ Verify Select From city *********************/
	public void verifyTOSelectedCity(String expectedCity) {
		try {
			Assert.assertEquals(TOInput_Element.getAttribute("value"), expectedCity);
			logger.log(Status.PASS, "Selected city is verified");
			Logger.info("Selected city is verified");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	/****************** Click on Pick Up time ****************************/
	public void clickOnPickUpTime() {
		try {
			pickuupInput_Elementl.click();
			logger.log(Status.PASS, "Clicked on PickUp.");
			Logger.info("Clicked on PickUp.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Select Pick Up time *****************************/
	public void selectPickuptime(String HHcolonMM_AM) {
		try {
			for (WebElement webElement : selectPickupDate_Elements) {
				String tempStr = webElement.getText();
				if (tempStr.equals(HHcolonMM_AM)) {
					webElement.click();
					break;
				}
			}
			logger.log(Status.PASS, "Selected PickUP Time : " + HHcolonMM_AM);
			Logger.info("Selected PickUP Time : " +HHcolonMM_AM);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/******************* Verify Select Pick Up time **********************/
	public void verifyPickupTime(String HHcolonMM_AM) {
		try {
			String temp = verifypicupDate_element.getText();
			Assert.assertEquals(temp, HHcolonMM_AM);
			logger.log(Status.PASS, "Pickup time verified got : " + HHcolonMM_AM);
			Logger.info("Pickup time verified got : " +HHcolonMM_AM);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/******************** Click on Departure Date **************************/
	public void clickOnDepartureDate() {
		try {
			departureDateLabel_Element.click();
			logger.log(Status.PASS, "Clicked on Departure Date.");
			Logger.info("Clicked on Departure Date.");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/******************** Select Departure Data ****************************/
		public void selectDepatureDate(String date) {
			try {				
				Thread.sleep(1000);
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date expectedDate = dateFormat.parse(date);

				String day = new SimpleDateFormat("dd").format(expectedDate);
				String month = new SimpleDateFormat("MMMM").format(expectedDate);
				String year = new SimpleDateFormat("yyyy").format(expectedDate);

				String expectedMonth = month + " " + year;

				int dayINT = Integer.parseInt(day);

				while (true) {
					String gotFromWeb = monthYear_Element.getText();
					SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy");
					Date fgotmonth = formatter.parse(gotFromWeb);
					Date ftogoMonth = formatter.parse(expectedMonth);
					
					
					Calendar cal1 = Calendar.getInstance();
					Calendar cal2 = Calendar.getInstance();
					cal1.setTime(fgotmonth);
					cal2.setTime(ftogoMonth);
					if(cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)) {
						String xpath = "(//div[contains(text(),'" + dayINT + "')and @ role='gridcell'])[1]";
						driver.findElement(By.xpath(xpath)).click();
						break;
					}
					else if(cal1.get(Calendar.MONTH) < cal2.get(Calendar.MONTH)) {
						logger.log(Status.INFO, "Changing Calender month.");
						Logger.info("Changing Calender month.");
						nextMonthButton_Element.click();
					}else if(cal1.get(Calendar.MONTH) > cal2.get(Calendar.MONTH)) {
						logger.log(Status.INFO, "Changing Calender month.");
						Logger.info("Changing Calender month.");
						previousMonthButton_Element.click();
					}

				}
				logger.log(Status.PASS, "Departure Date id Slelected to " + date);
				Logger.info("Departure Date id Slelected to " + date);
			} catch (Exception e) {
				reportFail(e.getMessage());
			}
		}
		
	/******************** Verify Departure Data ****************************/
	public void verifyDepatureDate(String ExpectedDate) {
		try {

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date expectedDate = dateFormat.parse(ExpectedDate);

			String day = new SimpleDateFormat("dd").format(expectedDate);
			String month = new SimpleDateFormat("MMM").format(expectedDate);
			String year = new SimpleDateFormat("yy").format(expectedDate);
			int dayINT = Integer.parseInt(day);

			String ExpectedDate1 = dayINT + " " + month + year;
			String ActualDate = verifyDepature_Element.getText();
			Assert.assertEquals(ActualDate, ExpectedDate1);
			logger.log(Status.PASS, "Departure Date verified  Got : " + ActualDate);
			Logger.info("Departure Date verified  Got : " + ActualDate);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/***************** Verify Search Button Available ********************/
	public void verifySearchButtonAvailable() {
		try {
			searchButton_Element.isDisplayed();
			logger.log(Status.PASS, "Search Button is displayed.");
			Logger.info("Search Button is displayed.");
			searchButton_Element.isEnabled();
			logger.log(Status.PASS, "Search Button is Enabled");
			Logger.info("Search Button is Enabled.");

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	/****************** Click on Search Button *****************************/
	public SearchPageCabs clickOnSearchButton() {
		try {
			searchButton_Element.click();
			logger.log(Status.PASS, "Clicked on Search Button.");
			Logger.info("Clicked on Search Button.");

			// Returning SearchPageObject
			SearchPageCabs searchPageCabs = new SearchPageCabs(driver, logger);
			PageFactory.initElements(driver, searchPageCabs);
			return searchPageCabs;

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return null;
	}

}
