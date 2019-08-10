package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.leaftaps.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {

	RemoteWebDriver driver;
	ExtentTest test;
	
	public HomePage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="CRM/SFA")
	WebElement eleCRMSFALink;
	public MyHomePage clickCrmsfa()
	{
		click(eleCRMSFALink,"Crmsfa link");
		return new MyHomePage(driver,test);
	}
	
}
