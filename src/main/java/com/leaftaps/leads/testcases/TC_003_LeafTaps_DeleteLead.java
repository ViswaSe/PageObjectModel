package com.leaftaps.leads.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.base.ProjectSpecificMethods;
import com.leaftaps.leads.pages.LoginPage;

public class TC_003_LeafTaps_DeleteLead extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData()
	{
		filename="TC_003_LeafTaps_DeleteLead";
		testCaseName="TC_003_LeafTaps_DeleteLead";
		testCaseDescription="Delete the given lead from the leaftaps application";
		browser="chrome";
		iteration="Leads";
		author="Vishveshwar";
		category="SIT";
	}

	@Test(dataProvider="fetchData")
	public void leafTapsDeleteLead(String username,String password,
			String fname,String exceptional)
	{
		new LoginPage(driver,test)
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickCrmsfa()
		.clickLeads()
		.clickFindLeads()
		.enterFirstNameInFindLeads(fname)
		.clickFindLeadsButton()
		.captureFirstResultingLeadId()
		.clickFirstResultingLead()
		.clickDeleteButton()
		.clickFindLeads()
		.enterCapturedfirstResultingLeadIdInFindLeads()
		.clickFindLeadsButton()
		.verifyExceptionalMessage(exceptional);
	}
}
