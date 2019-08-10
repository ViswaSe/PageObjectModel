package com.leaftaps.leads.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.base.ProjectSpecificMethods;
import com.leaftaps.leads.pages.LoginPage;

public class TC_004_LeafTaps_DuplicateLead extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData()
	{
		filename="TC_004_LeafTaps_DuplicateLead";
		testCaseName="TC_004_LeafTaps_DuplicateLead";
		testCaseDescription="Create the duplicate Lead in the leaftaps application";
		browser="chrome";
		iteration="Leads";
		author="Vishveshwar";
		category="SIT";
	}

	@Test(dataProvider="fetchData")
	public void leafTapsEditLead(String username,String password,
			String fname)
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
		.captureFirstResultingLeadName()
		.clickFirstResultingLead()
		.clickEditButton()
		.clickUpdate()
		.verifyFirstName(firstResultingLeadName);
	}
}
