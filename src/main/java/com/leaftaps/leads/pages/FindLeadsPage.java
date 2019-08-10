package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.leaftaps.base.ProjectSpecificMethods;

public class FindLeadsPage extends ProjectSpecificMethods{

	RemoteWebDriver driver;
	ExtentTest test;
	
	public FindLeadsPage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//label[contains(text(),'First name')]/following::input[1])[3]")
	WebElement eleFindname;
	public FindLeadsPage enterFirstNameInFindLeads(String fname)
	{
		type(eleFindname, fname);
		return this;
	}
	
	@FindBy(xpath="//label[contains(text(),'Lead ID')]/following::input[1]")
	WebElement eleLeadId;
	public FindLeadsPage enterCapturedfirstResultingLeadIdInFindLeads()
	{
		type(eleLeadId,firstResultingLeadId);
		return this;
	}
	
	@FindBy(xpath="//button[text()='Find Leads']")
	WebElement eleFindLeadsButton;
	public FindLeadsPage clickFindLeadsButton()
	{
		try 
		{
			click(eleFindLeadsButton,"FindLeads button");
			Thread.sleep(2000);
		} 
		catch (Exception e) {
			reportStep("Exception in the find leads button in find leads page","info");
		}
		
		return this;
	}
	
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[1]")
	WebElement eleFirstResultingLeadName;
	public FindLeadsPage captureFirstResultingLeadName()
	{
		firstResultingLeadName=getText(eleFirstResultingLeadName);
		return this;
	}
	
	@FindBy(xpath="//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")
	WebElement eleFirstResultingLeadId;
	public FindLeadsPage captureFirstResultingLeadId()
	{
		firstResultingLeadId=getText(eleFirstResultingLeadId);
		return this;
	}
	
	public ViewLeadPage clickFirstResultingLead()
	{
		click(eleFirstResultingLeadName, "First resulting lead");
		return new ViewLeadPage(driver,test);
	}
	
	@FindBy(xpath="//div[text()='No records to display']")
	WebElement eleExceptionalMessage;
	public FindLeadsPage verifyExceptionalMessage(String exceptional)
	{
		verifyPartialText(eleExceptionalMessage, exceptional);
		return this;
	}
	
	
}
