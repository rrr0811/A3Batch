package com.automation.batchexecutionscripts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Harley {
	@Test
	public void harley() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.harley-davidson.com/in/en/index.html");
		driver.quit();
	}
}
