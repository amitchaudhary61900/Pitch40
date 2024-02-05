package com.pitch40.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReporterObject() {
		
		//ExtentReports, ExtentSparkReporter
		String path= System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Pitch40 Application Automation Report");
		reporter.config().setDocumentTitle("Automation Report");
		
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation Framework Build by : ", "Amit Kumar Chaudhary");
		return extent;
			
		
	}

}
