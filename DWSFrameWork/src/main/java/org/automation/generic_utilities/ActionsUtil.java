package org.automation.generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;

/**
 * 
 * @author Harsha G R
 * 
 * 
 */
public class ActionsUtil {

	Actions actions ;
	
	public ActionsUtil(WebDriver driver) {
		actions = new Actions(driver);
	}
	
	/**
	 * this function is used to pass the data to an element
	 * @param targetElement
	 * @param dataToEnter
	 */
	public void passDataToElement(WebElement targetElement , String dataToEnter) {
		targetElement.clear();
		actions.sendKeys(targetElement,dataToEnter).perform();
	}
	
	/**
	 * this function is used to mouse hover on an element
	 * @param targetElement
	 */
	public void mouseHoverOnElement(WebElement targetElement) {
		actions.moveToElement(targetElement).perform();
	}
		
	/**
	 * this function is used to perform click action on the element
	 * @param targetElement
	 */
	public void clickOnElement(WebElement targetElement) {
		actions.click(targetElement).perform();
	}
	
	/**
	 * this function is used to perform double click on the element
	 * @param targetElement
	 */
	public void doubleClickOnElement(WebElement targetElement) {
		actions.doubleClick(targetElement).perform();
	} 
	
	/**
	 * this function is used to perform right click on the element
	 * @param targetElement
	 */
	public void rightClickOnElement(WebElement targetElement) {
		actions.contextClick(targetElement).perform();
	}
	
	/**
	 * this function is used to drag and drop element from src to dest
	 * @param sourceElement
	 * @param destElement
	 */
	public void dragAndDropAnElement(WebElement sourceElement , WebElement destElement) {
		actions.dragAndDrop(sourceElement, destElement).perform();
	}
	
	/**
	 * this  function is used to drag and drop element by using coordinates
	 * @param sourcetElement
	 * @param xOffset
	 * @param yOffset
	 */
	public void dragAndDropAnElementByCoordinate(WebElement sourcetElement , int xOffset , int yOffset) {
		actions.dragAndDropBy(sourcetElement, xOffset , yOffset).perform();
	}
	
	/**
	 * this function is used to scroll based on Amount
	 * @param xOffset
	 * @param yOffset
	 */
	public void scrollBasedOnAmount(int xOffset, int yOffset) {
		actions.scrollByAmount(xOffset, yOffset).perform();
	}
	
	/**
	 * this function is used to scroll until the passed element is visible
	 * @param ele
	 */
	public void scrollUntilElementIsVisible(WebElement ele) {
		actions.scrollToElement(ele).perform();
	}
	
	/**
	 * this function is used to scroll until the passed element is visible and extra scrolling as well
	 * @param ele
	 * @param xOffset
	 * @param yOffset
	 */
	public void scrollUntilElementIsVisible(WebElement ele, int xOffset, int yOffset) {
		actions.scrollFromOrigin(ScrollOrigin.fromElement(ele), xOffset, yOffset).perform();
	}
}
