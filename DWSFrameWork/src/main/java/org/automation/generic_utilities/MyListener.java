package org.automation.generic_utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyListener extends BaseClass implements ITestListener{

	//=============================Listener Implementations=====================================//
	
		@Override
		public void onTestStart(ITestResult result) {
			Reporter.log("Test [" + result.getName() + "] started");
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			Reporter.log("Test [" + result.getName() + "] success");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			Reporter.log("Test [" + result.getName() + "] failed");
			utilMethods = new UtilityMethods();
			utilMethods.captureScreen(driver, result.getName());
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			Reporter.log("Test [" + result.getName() + "] skipped");
		}

		@Override
		public void onStart(ITestContext context) {
			Reporter.log("<test> [" + context.getName() + "] started");
		}

		@Override
		public void onFinish(ITestContext context) {
			Reporter.log("<test> [" + context.getName() + "] finish");
		}
}
