package com.pitch40.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pitch40.utlities.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InvestorJoinUsPage extends AndroidActions {
	
AndroidDriver driver;
	
	public InvestorJoinUsPage(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(accessibility="Register as Investor")
	private WebElement RegisterInvestorButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[2]")
	private WebElement InvestorjoinUsback;
	
	@AndroidFindBy(accessibility="Please enter your username")
	private WebElement InvestorSignUpName;
	
	@AndroidFindBy(accessibility="Please enter your email id")
	private WebElement InvestorSignUpEmail;
	
	@AndroidFindBy(xpath="//android.widget.EditText[1]")
	private WebElement InvestorNameInput;
	
	@AndroidFindBy(xpath="//android.widget.EditText[2]")
	private WebElement InvestorEmailInput;
	
	public String investorRegisterbuttonCheck(String investorcheckattr) {
        String registerinvcheck =RegisterInvestorButton.getAttribute(investorcheckattr);
        return registerinvcheck;
		
	}
	public void RegisterAsInvestorButton() throws InterruptedException {
		RegisterInvestorButton.click();
        Thread.sleep(4000);

	}
	
	public void InvestorJoinUsBack() throws InterruptedException {
		InvestorjoinUsback.click();
        Thread.sleep(2000);
	}
	
	public String getInvNameAttr(String attr0) {
		return InvestorSignUpName.getAttribute(attr0);
	
	}
	
	public String getInvEmailAttr(String attr0) {
		return InvestorSignUpEmail.getAttribute(attr0);
	
	}
	
	public void setInvestorName(String InvestorName) throws InterruptedException {
		InvestorNameInput.click();
		InvestorNameInput.sendKeys(InvestorName);
        driver.hideKeyboard();
        Thread.sleep(2000);
	}
	
	public void setInvestorEmail(String InvestorEmail) throws InterruptedException {
		InvestorEmailInput.click();
		InvestorEmailInput.sendKeys(InvestorEmail);
        driver.hideKeyboard();
        Thread.sleep(2000);
	}
	
	
	

}
