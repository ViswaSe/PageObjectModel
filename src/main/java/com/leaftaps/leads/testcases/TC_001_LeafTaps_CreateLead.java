
package com.leaftaps.leads.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.base.ProjectSpecificMethods;
import com.leaftaps.leads.pages.LoginPage;

public class TC_001_LeafTaps_CreateLead extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData()
	{
		filename="TC_001_LeafTaps_CreateLead";
		testCaseName="TC_001_LeafTaps_CreateLead";
		testCaseDescription="Create Lead in the leaftaps application";
		browser="chrome";
		iteration="Leads";
		author="Vishveshwar";
		category="SIT";
	}

	
	@Test(dataProvider="fetchData")
	public void leafTapsCreateLead(String username,String password,
			String cname,String fname,String lname)
	{
		System.out.println("Create Lead");
		new LoginPage(driver,test)
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickCrmsfa()
		.clickLeads()
		.clickCreateLead()
		.enterCompanyName(cname)
		.enterFirstName(fname)
		.enterLastName(lname)
		.clickSubmit()
		.verifyFirstName(fname);
	}
}
