package com.pitch40.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pitch40.TestUtils.AndroidBaseTest;
import com.pitch40.pageObjects.android.InvestorJoinUsPage;
import com.pitch40.pageObjects.android.InvestorOnboardingPage;
import com.pitch40.utlities.AndroidActions;

public class InvestorSignUpTest extends AndroidBaseTest {
	
	 AndroidActions actions;
	 InvestorJoinUsPage investorPage;
	 InvestorOnboardingPage investorOnboardingPage;
	 
	 
	 
	
	@Test(priority = 1, dataProvider="getData")
	public void InvestorSignUpNameCheck(HashMap<String, String> input) throws InterruptedException {
		actions= new AndroidActions(driver);
		investorPage=new InvestorJoinUsPage(driver);
		
		//click on investor login
        actions.tapOnScreen(359, 1357);
        
        investorPage.RegisterAsInvestorButton();
        investorPage.setInvestorName(input.get("InvestorSignUpTest_Name"));
   
	}

	@Test(priority = 2, dataProvider="getData")
	public void InvestorSignUpEmailIDCheck(HashMap<String, String> input) throws InterruptedException {
		
		investorPage.setInvestorEmail(input.get("InvestorSignUpTest_Email"));
		investorPage.RegisterAsInvestorButton();  

	}
	

	@Test(priority = 3, dataProvider="getData")
	public void InvestorOnboarding(HashMap<String, String> input) throws InterruptedException, IOException {
		investorOnboardingPage=new InvestorOnboardingPage(driver);
		
		//OTP page
//		String invstOtpPage = investorOnboardingPage.OTPpageValidation(input.get("InvestorSignUpTest_validationAttr"));
//		Assert.assertEquals(invstOtpPage, input.get("InvestorSignUpTest_OtpPageValidation"));
		investorOnboardingPage.EnterOTP(input.get("InvestorSignUpTest_EnterOtp"));
		investorOnboardingPage.verifyInvestorOTP();
		
		//CompanyName
		investorOnboardingPage.InvestorCompanyName(input.get("InvestorSignUpTest_CompanyName"));
		investorOnboardingPage.InvestorNextbutton();
		
		//NEXT organization number page
		investorOnboardingPage.InvestorNextbutton();
		//skip KYC
		investorOnboardingPage.InvestorSkipKYC();
		//Tell us about
		investorOnboardingPage.InvestorTellUsAbout(input.get("InvestorSignUpTest_TellUsAbout"));
		investorOnboardingPage.InvestorNextbutton();
		//Type of Investor
		investorOnboardingPage.InvestorType(input.get("InvestorSignUpTest_InvestorType"));
		investorOnboardingPage.InvestorNextbutton();
		//Stage of investment
		investorOnboardingPage.InvestmentStage(input.get("InvestorSignUpTest_InvestmentStage"));
		investorOnboardingPage.InvestorNextbutton();
		//Industry you are interested In
		investorOnboardingPage.InvestorIndustryInterestedIn(input.get("Investor_Sports"), input.get("InvestorCyber"), input.get("InvestorRetail"));
		investorOnboardingPage.InvestorNextbutton();
		
		//InvestorProfilePictureFrom camera
		investorOnboardingPage.InvestorProfilePicUpload();
		investorOnboardingPage.InvestorNextbutton();		

	}

	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"/src//test//java//com//pitch40//testData//pitch40.json");		
		return new Object[][] { {data.get(0)} };
	}

}
