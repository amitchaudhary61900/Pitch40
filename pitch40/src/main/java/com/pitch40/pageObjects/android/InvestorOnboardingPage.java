package com.pitch40.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pitch40.utlities.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InvestorOnboardingPage extends AndroidActions{
	
AndroidDriver driver;
	
	public InvestorOnboardingPage(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility="Verify email")
	private WebElement VerifyOTP;
	
	@AndroidFindBy(xpath="//android.view.View[4]")
	private WebElement EnterOTP;
	
	@AndroidFindBy(accessibility="Find your startup")
	private WebElement OTPpageTitle;
	
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement InvestorCompanytext;
	
	@AndroidFindBy(accessibility="Next")
	private WebElement InvestorNextButton;
	
	@AndroidFindBy(accessibility="TRAN TC")
	private WebElement InvestorCompanyOptionSelect;
	
	@AndroidFindBy(accessibility="Skip for now\n"
			+ "Continue with onboarding")
	private WebElement InvestorCompanyKYCSkip;
	
	@AndroidFindBy(accessibility="Angel")
	private WebElement AngelInvestor;

	@AndroidFindBy(accessibility="Investor & Mentor")
	private WebElement InvestorAndMentorInvestor;
	
	@AndroidFindBy(accessibility="Venture capitalist")
	private WebElement VCInvestor;
	
	@AndroidFindBy(accessibility="No preference")
	private WebElement NoPrefInvestor;
	
	@AndroidFindBy(accessibility="Pre-Seed")
	private WebElement PreSeed;

	@AndroidFindBy(accessibility="Seed")
	private WebElement Seed;
	
	@AndroidFindBy(accessibility="Series A")
	private WebElement SeriesA;
	
	@AndroidFindBy(accessibility="Series B")
	private WebElement SeriesB;
	//------------------------------------------------------------
	@AndroidFindBy(accessibility="Sports and fitness")
	private WebElement SportAndFitness;
	
	@AndroidFindBy(accessibility="Cybersecurity and data privacy")
	private WebElement Cyber;

	@AndroidFindBy(accessibility="Retail and e-commerce")
	private WebElement Retail;
	
	@AndroidFindBy(accessibility="Upload now")
	private WebElement InvestorProfileUploadNow;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"Upload from  gallery SVG,PNG,JPEG (max. 5mb) \"]")
	private WebElement InvestorProfilePicGallery;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[3]")
	private WebElement InvestorBrowseP40;
	
	

	
	
	public String OTPpageValidation(String attr0) {
		return OTPpageTitle.getAttribute(attr0);
	
	}
	
	public void EnterOTP(String AndroidInvesOTP) throws InterruptedException {
		EnterOTP.click();
		EnterOTP.sendKeys(AndroidInvesOTP);
		driver.hideKeyboard();
		Thread.sleep(2000);

	}
	
	public void verifyInvestorOTP() throws InterruptedException {
		VerifyOTP.click();
		Thread.sleep(2000);
		
	}
	
	public void InvestorCompanyName(String InvCompanyName) throws InterruptedException {
		InvestorCompanytext.click();
		InvestorCompanytext.sendKeys(InvCompanyName);
		driver.hideKeyboard();
		Thread.sleep(2000);
		InvestorCompanyOptionSelect.click();
		
	}
	
	public void InvestorNextbutton() throws InterruptedException {
		InvestorNextButton.click();
		Thread.sleep(2000);

	}
	
	public void InvestorSkipKYC() throws InterruptedException {
		InvestorCompanyKYCSkip.click();
		Thread.sleep(2000);
	}
	public void InvestorTellUsAbout(String InvTellUs) throws InterruptedException {
		InvestorCompanytext.click();
		InvestorCompanytext.sendKeys(InvTellUs);
		driver.hideKeyboard();
		Thread.sleep(2000);
	}
	public void InvestorType(String InvestorType) throws InterruptedException {
		if (InvestorType.equals("Angel")) {
	        AngelInvestor.click();
	        Thread.sleep(2000);
	    } else if (InvestorType.equals("Investor & Mentor")) {
	        InvestorAndMentorInvestor.click();
	        Thread.sleep(2000);
	    } else if (InvestorType.equals("Venture capitalist")) {
	        VCInvestor.click();
	        Thread.sleep(2000);
	    } else if (InvestorType.equals("No preference")) {
	        NoPrefInvestor.click();
	        Thread.sleep(2000);
	    }
	}

	public void InvestmentStage(String InvestmentStage) throws InterruptedException {
		if(InvestmentStage.equals("Pre-Seed")) {
			PreSeed.click();
			  Thread.sleep(2000);
		}else if (InvestmentStage.equals( "Seed")) {
			Seed.click();
			 Thread.sleep(2000);
		}else if (InvestmentStage.equals("Series A")) {
			SeriesA.click();
			 Thread.sleep(2000);
		}
		else if (InvestmentStage.equals("Series B")) {
			SeriesB.click();
			 Thread.sleep(2000);
		}
	}

	public void InvestorIndustryInterestedIn(String Industry1, String Industry2, String Industry3) throws InterruptedException {
		SportAndFitness.click();
		Cyber.click();
		Retail.click();
		Thread.sleep(2000);

	}
	public void InvestorProfilePicUpload() throws InterruptedException {
		InvestorProfileUploadNow.click();
		Thread.sleep(2000);
//		InvestorProfilePicGallery.click();
//		Thread.sleep(2000);
		tapOnScreen(794,1778);
		Thread.sleep(4000);
		driver.findElement(AppiumBy.accessibilityId("Shutter")).click();
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("Done")).click();
		Thread.sleep(3000);

	}
	
	public void InvestorBrowsePitch() throws InterruptedException {
		InvestorBrowseP40.click();
		Thread.sleep(3000);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
