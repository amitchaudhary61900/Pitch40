package com.pitch40.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pitch40.TestUtils.AndroidBaseTest;
import com.pitch40.pageObjects.android.FounderJoinUsPage;
import com.pitch40.pageObjects.android.InvestorJoinUsPage;
import com.pitch40.pageObjects.android.WelcomePage;
import com.pitch40.utlities.AndroidActions;

public class WelcomeTest extends AndroidBaseTest{
	
	
	
	@Test(priority = 1, dataProvider="getData")
	public void WelcomePage(HashMap<String, String> input) throws InterruptedException  {

		WelcomePage welcomePage =new WelcomePage(driver);
		String s1 =welcomePage.getAttributeText(input.get("WelcomeTest_validationAttr"));
		AssertJUnit.assertEquals(s1, input.get("WelcomeTest_actualassertioWelcomPage"));
		
	//click on investor login
        AndroidActions actions = new AndroidActions(driver);
        actions.tapOnScreen(359, 1357);
        
        InvestorJoinUsPage investorPage= new InvestorJoinUsPage(driver);
        String s2= investorPage.investorRegisterbuttonCheck(input.get("WelcomeTest_validationAttr"));
        AssertJUnit.assertEquals(input.get("WelcomeTest_actaulassertInvLogin"), s2);
        
        //back
        investorPage.InvestorJoinUsBack();
		AssertJUnit.assertEquals(s1, input.get("WelcomeTest_actualassertioWelcomPage"));

	 //check startup login
        actions.tapOnScreen(365, 1864);
        FounderJoinUsPage founderPage= new FounderJoinUsPage(driver);
        String registerstarcheck=founderPage.investorRegisterbuttonCheck(input.get("WelcomeTest_validationAttr"));
        AssertJUnit.assertEquals(input.get("WelcomeTest_actaulassertFoundLogin"), registerstarcheck);

        investorPage.InvestorJoinUsBack();
		AssertJUnit.assertEquals(s1, input.get("WelcomeTest_actualassertioWelcomPage"));
		
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"/src//test//java//com//pitch40//testData//pitch40.json");		
		return new Object[][] { {data.get(0)} };
	}
}
