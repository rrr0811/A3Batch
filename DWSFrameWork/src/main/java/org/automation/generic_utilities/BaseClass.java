package org.automation.generic_utilities;

import java.time.Duration;

import org.automation.element_repository.Base_Page;
import org.automation.element_repository.Login_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/***
 * 
 * Every Automation script must and should extend BaseClass
 * In this class we have methods for browserSetup, loginToApplication, logoutOfApplication and browserTearDown
 * which is required for all the automation scripts
 * 
 * @author Harsha G R
 *
 */
public abstract class BaseClass implements IAutoConstants{

	

	public static WebDriver driver;
	public Base_Page basepage;
	public Login_Page loginpage;
	public WebDriverWait explicitWait;
	public ReadTestData readData;
	public UtilityMethods utilMethods;
	
	/**
	 * this function performs browser SetUp
	 * @param browserName pass the name of the browser Using TestNg parameter
	 * @Optional chrome
	 */
	@Parameters("browser")
	@BeforeClass
	public void browserSetUp(@Optional("chrome") String browserName){
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			Reporter.log("Successfully Launched Chrome Browser", true);
		} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			Reporter.log("Successfully Launched Firefox Browser", true);
		}
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized successfully", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT));
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT));
		
	}

	/**
	 * This function performs login to the application
	 */
	@BeforeMethod
	public void loginToApplication() {
		readData = new ReadTestData();
		String url = readData.readDataFromPropertyFile("url");
		String emailId = readData.readDataFromPropertyFile("emailId");
		String password = readData.readDataFromPropertyFile("password");

		driver.get(url);
		loginpage = new Login_Page(driver);
		loginpage.login(emailId, password);
	}

	/**
	 * this function performs logout action
	 *  
	 */
	@AfterMethod
	public void logoutOfApplication() {
		loginpage.logOut();
	}

	/**
	 * this function performs Browser tearDown
	 */
	@AfterClass
	public void browserTearDown() {
		driver.quit();
	}
	
}
