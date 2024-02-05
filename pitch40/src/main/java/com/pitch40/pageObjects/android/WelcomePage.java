package com.pitch40.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pitch40.utlities.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomePage extends AndroidActions{
	
	AndroidDriver driver;
	
	public WelcomePage(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//	@AndroidFindBy(accessibility="Hello, there!")
//	private List<WebElement> mainPageValidation;   //if we have written findelements in the test 
	
	
	@AndroidFindBy(accessibility="Hello, there!")
	private WebElement mainPageValidation;
	
	
	
	
	
	public String getAttributeText(String mainPageAttrName) {
		return mainPageValidation.getAttribute(mainPageAttrName);
	}
	
	
	
	
	
	
	
	
	
	
	
}