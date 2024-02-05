package com.pitch40.pageObjects.android;

import org.openqa.selenium.support.PageFactory;

import com.pitch40.utlities.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InvestorBrowsePage extends AndroidActions {
	
AndroidDriver driver;
	
	public InvestorBrowsePage(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	
	public void Scroll() throws InterruptedException {
		swipe(driver, 524, 1027, 543, 1692);
		Thread.sleep(5000);
	}
}
