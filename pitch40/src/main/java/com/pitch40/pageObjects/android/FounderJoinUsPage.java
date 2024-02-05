package com.pitch40.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pitch40.utlities.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FounderJoinUsPage extends AndroidActions{
	
AndroidDriver driver;
	
	public FounderJoinUsPage(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility="Register as startup")
	private WebElement RegisterFounderButton;
	
	public String investorRegisterbuttonCheck(String founderCheckAttr) {
        String registerFoudCheck =RegisterFounderButton.getAttribute(founderCheckAttr);
        return registerFoudCheck;

		
	}
	
	

}
