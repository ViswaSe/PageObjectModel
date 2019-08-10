package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.leaftaps.base.ProjectSpecificMethods;

public class MergeLeadsPage extends ProjectSpecificMethods {
	
	RemoteWebDriver driver;
	ExtentTest test;
	public MergeLeadsPage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Lookup']")
	WebElement eleFirstIcon;
	public MergeLeadsPage clickFirstIcon()
	{
		try 
		{
			click(eleFirstIcon,"First icon");
			Thread.sleep(2000);
		} 
		catch (Exception e) 
		{	
		}
		return this;
	}
	
	public SubFindLeadsPage switchToChildWindow(int windowIndex)
	{
		switchToWindow(windowIndex);
		return new SubFindLeadsPage(driver,test);
	}

	
	@FindBy(xpath="(//img[@alt='Lookup'])[2]")
	WebElement eleSecondIcon;
	public MergeLeadsPage clickSecondIcon()
	{
		try 
		{
			Thread.sleep(1000);
			click(eleSecondIcon,"Second icon");
			Thread.sleep(2000);
		} 
		catch (Exception e) 
		{	
		}
		return this;
	}
	
	@FindBy(linkText="Merge")
	WebElement eleMergeButton;
	public MergeLeadsPage clickMergeButton()
	{
		clickWithoutSS(eleMergeButton,"Merge");
		return this;
	}
	
	public ViewLeadPage acceptMergeAlert()
	{
		acceptAlert();
		return new ViewLeadPage(driver,test);
	}
	
	
	
}
