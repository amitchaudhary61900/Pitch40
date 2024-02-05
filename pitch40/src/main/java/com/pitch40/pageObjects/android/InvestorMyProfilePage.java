package com.pitch40.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pitch40.utlities.AndroidActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InvestorMyProfilePage extends AndroidActions {
	
AndroidDriver driver;
	
	public InvestorMyProfilePage(AndroidDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility="Already have an account ? Login")
	private WebElement JoinUsPageLoginClick;
	
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement EmailID;
	
	@AndroidFindBy(accessibility="Login as investor")
	private WebElement LoginAsInv;
	
	@AndroidFindBy(xpath="//android.view.View[1]//android.widget.ImageView[3]")
	private WebElement MyProfileClick;
	
	@AndroidFindBy(accessibility="Edit Profile")
	private WebElement EditProfile;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView//android.view.View[2]//android.view.View[4]")
	private WebElement EditInteresetedStage;
	
	@AndroidFindBy(accessibility="Save changes")
	private WebElement SaveChanges;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"Complete Now\n"
			+ "Preference management\n"
			+ "Profile is \n"
			+ "0% complete\"]")
	private WebElement InvProfileCompletionClick;
	
	@AndroidFindBy(accessibility="Company\n"
			+ "0/6")
	private WebElement CompanyQuesClick;
	
	@AndroidFindBy(accessibility="Founder\n"
			+ "0/5")
	private WebElement FounderQuesClick;
	
	@AndroidFindBy(accessibility="Team\n"
			+ "0/2")
	private WebElement TeamQuesClick;
	
	@AndroidFindBy(accessibility="Solution\n"
			+ "0/3")
	private WebElement SolutionQuesClick;
	
	
	
	public void JoinUsPageLoginClick() throws InterruptedException {
		JoinUsPageLoginClick.click();
		Thread.sleep(2000);
	}
	
	public  void InvestorLogin(String Email) throws InterruptedException {
		EmailID.click();
		EmailID.sendKeys(Email);
		driver.hideKeyboard();
		Thread.sleep(2000);
	}
	
	public void LoginAsInvestorButton() throws InterruptedException {
		LoginAsInv.click();
		Thread.sleep(2000);
	}
	
	public void myProfileClick() throws InterruptedException {
		MyProfileClick.click();
		Thread.sleep(2000);
		
	}
	
	public void myProfileEdit() throws InterruptedException {
		EditProfile.click();
		Thread.sleep(2000);
	}
	
	public void EditInterestedStageClick() throws InterruptedException {
		swipe(driver, 524, 1027, 543, 1692);
		EditInteresetedStage.click();
		Thread.sleep(2000);
	}
	
	public void SaveChanges() throws InterruptedException {
		SaveChanges.click();
		Thread.sleep(3000);
	}
	
	public void profileCompletionClick() throws InterruptedException {
		Thread.sleep(2000);
		InvProfileCompletionClick.click();
		Thread.sleep(2000);
	}
	
	public void CompanyQuestions() throws InterruptedException {
		CompanyQuesClick.click();
		//Thread.sleep(1000);
	}
	public void CompanyQuestionsAnswerOptions(String answer01) throws InterruptedException {
		driver.findElement(By.xpath("//android.view.View[@content-desc=\""+answer01+"\"]")).click();
		Thread.sleep(2000);


	}
	
	public void CompanyQuestionsAnswerInputField(String inputFieldText) throws InterruptedException {
		WebElement company01=driver.findElement(By.className("android.widget.EditText"));
		company01.click();
		company01.sendKeys(inputFieldText);
		driver.hideKeyboard();
		Thread.sleep(2000);
	}
	
	public void FounderQuestions() throws InterruptedException {
		FounderQuesClick.click();
		//Thread.sleep(1000);
	}
	public void TeamsQuestions() throws InterruptedException {
		TeamQuesClick.click();
		//Thread.sleep(1000);
	}
	public void SolutionQuestions() throws InterruptedException {
		SolutionQuesClick.click();
		//Thread.sleep(1000);
	}
	

	
	
	
	
	
}
