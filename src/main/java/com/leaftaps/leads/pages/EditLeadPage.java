package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.leaftaps.base.ProjectSpecificMethods;

public class EditLeadPage extends ProjectSpecificMethods{
	
	RemoteWebDriver driver;
	ExtentTest test;
	
	public EditLeadPage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="updateLeadForm_firstName")
	WebElement eleFirstName;
	public EditLeadPage updateFirstName(String newName)
	{
		clear(eleFirstName);
		type(eleFirstName,newName);
		return this;
	}
	
	@FindBy(name="submitButton")
	WebElement eleUpdateButton;
	public ViewLeadPage clickUpdate()
	{
		click(eleUpdateButton,"update button");
		return new ViewLeadPage(driver,test);
	}

}
