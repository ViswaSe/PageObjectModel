package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.leaftaps.base.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods{
	
	RemoteWebDriver driver;
	ExtentTest test;
	
	public CreateLeadPage(RemoteWebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="createLeadForm_companyName")
	WebElement eleCompanyName;
	public CreateLeadPage enterCompanyName(String compName)
	{
		type(eleCompanyName,compName);
		return this;
	}
	
	@FindBy(id="createLeadForm_firstName")
	WebElement eleFirstName;
	public CreateLeadPage enterFirstName(String fname)
	{
		type(eleFirstName, fname);
		return this;
	}
	
	@FindBy(id="createLeadForm_lastName")
	WebElement eleLastName;
	public CreateLeadPage enterLastName(String lname)
	{
		type(eleLastName, lname);
		return this;
	}
	
	@FindBy(id="createLeadForm_dataSourceId")
	WebElement eleSourceDropdown;
	public CreateLeadPage selectSourceDropdown(String value)
	{
		selectDropDownUsingText(eleSourceDropdown, value);
		return this;
	}
	
	@FindBy(name="submitButton")
	WebElement eleSubmit;
	public ViewLeadPage clickSubmit()
	{
		click(eleSubmit,"Submit button");
		return new ViewLeadPage(driver,test);
	}
}
