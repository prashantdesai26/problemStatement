package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;


public class TestListener implements ITestListener {


	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		
		ExtentTestManager.startTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
		
	}
	
	


}
