package com.pitch40.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pitch40.TestUtils.AndroidBaseTest;
import com.pitch40.pageObjects.android.InvestorBrowsePage;
import com.pitch40.pageObjects.android.InvestorMyProfilePage;
import com.pitch40.pageObjects.android.InvestorOnboardingPage;
import com.pitch40.utlities.AndroidActions;

public class InvestorBrowseTest extends AndroidBaseTest{
	
	 AndroidActions actions;
	 InvestorOnboardingPage investorOnboardingPage;
	 InvestorMyProfilePage investorMyProfile;
	 InvestorBrowsePage investorBrowsePage;
	 
	@Test(priority = 1, dataProvider="getData")
	public void InvesterLogin(HashMap<String, String> input) throws InterruptedException {
		actions= new AndroidActions(driver);
		investorMyProfile = new InvestorMyProfilePage(driver);
		investorOnboardingPage = new InvestorOnboardingPage(driver);
		investorBrowsePage= new InvestorBrowsePage(driver);
		
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
	public void InvestorBrowse(HashMap<String, String> input) throws InterruptedException {
		
		investorBrowsePage.Scroll();
		investorBrowsePage.Scroll();
		investorBrowsePage.Scroll();
		
	}
	
	
	
	
	
	
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"/src//test//java//com//pitch40//testData//pitch40.json");		
		return new Object[][] { {data.get(0)} };
	}

}
