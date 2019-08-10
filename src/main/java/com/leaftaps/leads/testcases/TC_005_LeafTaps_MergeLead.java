package com.leaftaps.leads.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.base.ProjectSpecificMethods;
import com.leaftaps.leads.pages.LoginPage;

public class TC_005_LeafTaps_MergeLead extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData()
	{
		filename="TC_005_LeafTaps_MergeLead";
		testCaseName="TC_005_LeafTaps_MergeLead";
		testCaseDescription="";
		browser="chrome";
		iteration="Leads";
		author="Vishveshwar";
		category="SIT";
	}

	@Test(dataProvider="fetchData")
	public void leafTapsEditLead(String username,String password,
			String fname,String exceptional)
	{
		new LoginPage(driver,test)
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickCrmsfa()
		.clickLeads()
		.clickMergeLeads()
		.clickFirstIcon()
		.switchToChildWindow(1)
		.enterFirstNameInFindLeadsChildWindow(fname)
		.clickFindLeadsButtonInFindLeadsChildWindow()
		.captureFirstResultingLeadIdInFindLeadsChildWindow()
		.clickFirstResultingLead()
		.switchToParentWindow()
		.clickSecondIcon()
		.switchToChildWindow(1)
		.enterFirstNameInFindLeadsChildWindow(fname)
		.clickFindLeadsButtonInFindLeadsChildWindow()
		.captureSecondResultingLeadIdInFindLeadsChildWindow()
		.clickSecondResultingLead()
		.switchToParentWindow()
		.clickMergeButton()
		.acceptMergeAlert()
		.clickFindLeads()
		.enterCapturedfirstResultingLeadIdInFindLeads()
		.clickFindLeadsButton()
		.verifyExceptionalMessage(exceptional);
		
	}
}
