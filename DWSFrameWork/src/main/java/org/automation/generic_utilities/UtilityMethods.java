package org.automation.generic_utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

/**
 * 
 * @author Harsha G R
 *
 */
public class UtilityMethods implements IAutoConstants {

	/**
	 * This method is used to switch the driver control to a window based on the
	 * title
	 * 
	 * @param title of the expected page
	 */
	public void switchToASpecificTitledWindowBasedOnTitle(WebDriver driver, String title) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String windowId : allWindowIds) {
			driver.switchTo().window(windowId);
			if (driver.getTitle().equalsIgnoreCase(title)) {
				break;
			}
		}
	}
	
	/**
	 * This method is used to switch the driver control to a window based on the
	 * url
	 * 
	 * @param url of the expected page
	 */
	public void switchToASpecificTitledWindowBasedOnURL(WebDriver driver, String url) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String windowId : allWindowIds) {
			driver.switchTo().window(windowId);
			if (driver.getCurrentUrl().equalsIgnoreCase(url)) {
				break;
			}
		}
	}

	

	/**
	 * This method is used to take the screenshot and save it in .png format with
	 * date and time 
	 * 
	 * @param driver
	 */
	public void captureScreen(WebDriver driver, String testcasename) {
		LocalDateTime systemDate = LocalDateTime.now();
		String timeStamp = systemDate.toString().replaceAll(":", "-");
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File tempFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(SCREENSHOT_PATH + testcasename + timeStamp + ".png");
		try {
			FileHandler.copy(tempFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * This method helps to switch the control to a particular frame based on
	 * index
	 * 
	 * @param driver   pass the driver instance
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method helps to switch the control to a particular frame based on
	 * nameOrId
	 * 
	 * @param driver   pass the driver instance
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method helps to switch the control to a particular frame based on
	 * element
	 * 
	 * @param driver   pass the driver instance
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will generate a random number within the boundary which is passed
	 * @param boundary upper limit of your random number
	 * @return randomNumber
	 */
	public int giveRandomNumber(int boundary) {
		Random random = new Random();
		return random.nextInt(boundary);
	}
	
}
