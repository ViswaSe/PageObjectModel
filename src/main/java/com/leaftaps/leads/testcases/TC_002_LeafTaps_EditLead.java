package com.leaftaps.leads.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.base.ProjectSpecificMethods;
import com.leaftaps.leads.pages.LoginPage;

public class TC_002_LeafTaps_EditLead extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData()
	{
		filename="TC_002_LeafTaps_EditLead";
		testCaseName="TC_002_LeafTaps_EditLead";
		testCaseDescription="Edit the available Lead values in the leaftaps application";
		browser="chrome";
		iteration="Leads";
		author="Vishveshwar";
		category="SIT";
	}

	@Test(dataProvider="fetchData")
	public void leafTapsEditLead(String username,String password,
			String fname,String newName)
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
		.updateFirstName(newName)
		.clickUpdate()
		.verifyFirstName(newName);
	}
}
