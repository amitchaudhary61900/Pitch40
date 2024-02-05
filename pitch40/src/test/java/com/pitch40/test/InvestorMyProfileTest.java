package com.pitch40.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pitch40.TestUtils.AndroidBaseTest;
import com.pitch40.pageObjects.android.InvestorMyProfilePage;
import com.pitch40.pageObjects.android.InvestorOnboardingPage;
import com.pitch40.utlities.AndroidActions;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class InvestorMyProfileTest extends AndroidBaseTest {

	 AndroidActions actions;
	 InvestorOnboardingPage investorOnboardingPage;
	 InvestorMyProfilePage investorMyProfile;
	 
	@Test(priority = 1, dataProvider="getData")
	public void InvesterLogin(HashMap<String, String> input) throws InterruptedException {
		actions= new AndroidActions(driver);
		investorMyProfile = new InvestorMyProfilePage(driver);
		investorOnboardingPage = new InvestorOnboardingPage(driver);
		//click on investor login
       actions.tapOnScreen(359, 1357);
       investorMyProfile.JoinUsPageLoginClick();
       investorMyProfile.InvestorLogin(input.get("InvestorLogin_EmailID"));
       investorMyProfile.LoginAsInvestorButton();
       investorOnboardingPage.EnterOTP(input.get("InvestorSignUpTest_EnterOtp"));
       investorOnboardingPage.verifyInvestorOTP();
       Thread.sleep(3000);
	}
	
	@Test(priority = 2, dataProvider="getData")
	public void InvestorProfileEdit(HashMap<String, String> input) throws InterruptedException {
		//MyProfile edit
		investorMyProfile.myProfileClick();
		investorMyProfile.myProfileEdit();
		//Update Interested stage
		investorMyProfile.EditInterestedStageClick();
		investorOnboardingPage.InvestmentStage(input.get("InvestorSignUpTest_UpdateInvestmentStage"));
		investorMyProfile.SaveChanges();
		investorMyProfile.SaveChanges();
	}
	
	@Test(priority = 3, dataProvider="getData")
	public void CompleteInvProfileCompanyQuestions(HashMap<String, String> input) throws InterruptedException {
	//	investorMyProfile.myProfileClick();
		investorMyProfile.profileCompletionClick();
		investorMyProfile.CompanyQuestions();
		investorMyProfile.CompanyQuestionsAnswerOptions(input.get("InvestorMyProfile_CompanyAnswer01"));
		investorOnboardingPage.InvestorNextbutton();
		investorMyProfile.CompanyQuestionsAnswerOptions(input.get("InvestorMyProfile_CompanyAnswer02"));
		investorOnboardingPage.InvestorNextbutton();
		investorMyProfile.CompanyQuestionsAnswerOptions(input.get("InvestorMyProfile_CompanyAnswer03"));
		investorOnboardingPage.InvestorNextbutton();
		investorMyProfile.CompanyQuestionsAnswerOptions(input.get("InvestorMyProfile_CompanyAnswer04"));
		investorOnboardingPage.InvestorNextbutton();
		investorMyProfile.CompanyQuestionsAnswerInputField(input.get("InvestorMyProfile_CompanyAnswer05"));
		investorOnboardingPage.InvestorNextbutton();
		investorMyProfile.CompanyQuestionsAnswerOptions(input.get("InvestorMyProfile_CompanyAnswer06"));
		investorOnboardingPage.InvestorNextbutton();
		
	}
	
	@Test(priority = 4, dataProvider="getData")
	public void CompleteInvProfileFounderQuestions(HashMap<String, String> input) throws InterruptedException {
	//	investorMyProfile.myProfileClick();
	//	investorMyProfile.profileCompletionClick();
		investorMyProfile.FounderQuestions();
		investorMyProfile.CompanyQuestionsAnswerOptions(input.get("InvestorMyProfile_FounderAnswer01"));
		investorOnboardingPage.InvestorNextbutton();
		investorMyProfile.CompanyQuestionsAnswerOptions(input.get("InvestorMyProfile_FounderAnswer02"));
		investorOnboardingPage.InvestorNextbutton();
		investorMyProfile.CompanyQuestionsAnswerOptions(input.get("InvestorMyProfile_FounderAnswer03"));
		investorOnboardingPage.InvestorNextbutton();
		investorMyProfile.CompanyQuestionsAnswerOptions(input.get("InvestorMyProfile_FounderAnswer04"));
		investorOnboardingPage.InvestorNextbutton();
		investorMyProfile.CompanyQuestionsAnswerOptions(input.get("InvestorMyProfile_FounderAnswer05"));
		investorOnboardingPage.InvestorNextbutton();
			
	}
	@Test(priority = 5, dataProvider="getData")
	public void CompleteInvProfileTeamsQuestions(HashMap<String, String> input) throws InterruptedException {
	//	investorMyProfile.myProfileClick();
	//	investorMyProfile.profileCompletionClick();
		investorMyProfile.TeamsQuestions();
		investorMyProfile.CompanyQuestionsAnswerOptions(input.get("InvestorMyProfile_TeamsAnswer01"));
		investorOnboardingPage.InvestorNextbutton();
		investorMyProfile.CompanyQuestionsAnswerOptions(input.get("InvestorMyProfile_TeamsAnswer02"));
		investorOnboardingPage.InvestorNextbutton();
			
	}
	@Test(priority = 6, dataProvider="getData")
	public void CompleteInvProfileSolutionQuestions(HashMap<String, String> input) throws InterruptedException {
//		investorMyProfile.myProfileClick();
//		investorMyProfile.profileCompletionClick();
		investorMyProfile.SolutionQuestions();
		investorMyProfile.CompanyQuestionsAnswerInputField(input.get("InvestorMyProfile_SolutionAnswer01"));
		investorOnboardingPage.InvestorNextbutton();
		investorMyProfile.CompanyQuestionsAnswerOptions(input.get("InvestorMyProfile_SolutionAnswer02"));
		investorOnboardingPage.InvestorNextbutton();
		investorMyProfile.CompanyQuestionsAnswerOptions(input.get("InvestorMyProfile_SolutionAnswer03"));
		investorOnboardingPage.InvestorNextbutton();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//Investor will land to Browse page
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"/src//test//java//com//pitch40//testData//pitch40.json");		
		return new Object[][] { {data.get(0)} };
	}
}
