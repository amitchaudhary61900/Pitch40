package com.pitch40.TestUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pitch40.utlities.AppiumUtils;

import io.appium.java_client.AppiumDriver;

public class Listners extends AppiumUtils implements ITestListener{

	ExtentReports extent= ExtentReporterNG.getReporterObject();
	ExtentTest test;
	AppiumDriver driver;
	
	@Override
	public void onTestStart(ITestResult result) {
		//The result will extract the method from the test because listener will load before the test
		test= extent.createTest(result.getMethod().getMethodName());     
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot
		test.fail(result.getThrowable());
		
		try {
			driver= (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());    //getting driver from the class using testng.xml file class
			
		} catch (Exception e1 ) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			
			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}
	
	
	

}
