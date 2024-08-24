package com.automation.batchexecutionscripts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BMW {
	@Test
	public void bmw() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bmw-motorrad.in/en/home.html#/filter-all");
		driver.quit();
	}
}
