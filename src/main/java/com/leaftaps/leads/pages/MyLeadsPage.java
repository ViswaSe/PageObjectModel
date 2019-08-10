package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.leaftaps.base.ProjectSpecificMethods;

public class MyLeadsPage extends ProjectSpecificMethods{
	
	RemoteWebDriver driver;
	ExtentTest test;
	
	public MyLeadsPage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Create Lead")
	WebElement eleCreateLead;
	public CreateLeadPage clickCreateLead()
	{
		click(eleCreateLead,"Create Lead");
		return new CreateLeadPage(driver,test);
	}
	
	@FindBy(linkText="Find Leads")
	WebElement eleFindLeads;
	public FindLeadsPage clickFindLeads()
	{
		click(eleFindLeads, "Find Leads");
		return new FindLeadsPage(driver,test);
	}

	@FindBy(linkText="Merge Leads")
	WebElement eleMergeLeads;
	public MergeLeadsPage clickMergeLeads()
	{
		click(eleMergeLeads, "Merge Leads");
		return new MergeLeadsPage(driver,test);
	}

	
}
