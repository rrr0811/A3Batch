package com.automation.sampletestscripts;

import org.automation.generic_utilities.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.automation.generic_utilities.MyListener.class)
public class TC_Register001 extends BaseClass{
	@Test
	public void test() {
		driver.findElement(By.id("harsha"));
	}
}
