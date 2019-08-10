package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.leaftaps.base.ProjectSpecificMethods;

public class SubFindLeadsPage extends ProjectSpecificMethods{
	
	RemoteWebDriver driver;
	ExtentTest test;
	
	public SubFindLeadsPage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//label[contains(text(),'First name')]/following::input[1])")
	WebElement eleFirstName;
	public SubFindLeadsPage enterFirstNameInFindLeadsChildWindow(String fname)
	{
		type(eleFirstName,fname);
		return this;
	}
	
	@FindBy(xpath="//button[text()='Find Leads']")
	WebElement eleFindLeadsButton;
	public SubFindLeadsPage clickFindLeadsButtonInFindLeadsChildWindow()
	{
		click(eleFindLeadsButton,"FindLeads button");
		return this;
	}
	
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")
	WebElement eleFirstResultingLeadId;
	public SubFindLeadsPage captureFirstResultingLeadIdInFindLeadsChildWindow()
	{
		firstResultingLeadId=getText(eleFirstResultingLeadId);
		return this;
	}
	
	@FindBy(xpath="(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a[1]")
	WebElement eleSecondResultingLeadId;
	public SubFindLeadsPage captureSecondResultingLeadIdInFindLeadsChildWindow()
	{
		secondResultingLeadId=getText(eleSecondResultingLeadId);
		return this;
	}
	
	public SubFindLeadsPage clickFirstResultingLead()
	{
		clickWithoutSS(eleFirstResultingLeadId,"First Resulting lead");
		return this;
	}
	
	public SubFindLeadsPage clickSecondResultingLead()
	{
		clickWithoutSS(eleSecondResultingLeadId,"Second Resulting lead");
		return this;
	}
	
	public MergeLeadsPage switchToParentWindow()
	{
		switchToWindow(0);
		return new MergeLeadsPage(driver,test);
	}
	
}
