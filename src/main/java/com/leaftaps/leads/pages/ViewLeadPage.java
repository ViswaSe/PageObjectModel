package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.leaftaps.base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods{
	
	RemoteWebDriver driver;
	ExtentTest test;
	
	public ViewLeadPage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="viewLead_firstName_sp")
	WebElement eleFirstName;
	public ViewLeadPage verifyFirstName(String fname)
	{
		verifyExactText(eleFirstName, fname);
		return this;
	}
	
	@FindBy(linkText="Edit")
	WebElement eleEditButton;
	public EditLeadPage clickEditButton()
	{
		click(eleEditButton, "Edit button");
		return new EditLeadPage(driver,test);
	}
	
	@FindBy(linkText="Delete")
	WebElement eleDeleteButton;
	public MyLeadsPage clickDeleteButton()
	{
		click(eleDeleteButton,"Delete Button");
		return new MyLeadsPage(driver,test);
	}
	
	@FindBy(linkText="Find Leads")
	WebElement eleFindLeads;
	public FindLeadsPage clickFindLeads()
	{
		click(eleFindLeads,"Find leads");
		return new FindLeadsPage(driver,test);
	}
	
}
