package com.leaftaps.leads.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.leaftaps.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{
	
	public RemoteWebDriver driver;
	ExtentTest test;
	
	public LoginPage(RemoteWebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement eleUserName;
	public LoginPage enterUserName(String username)
	{
		type(eleUserName,username);
		return this;
	}
	
	@FindBy(id="password")
	WebElement elePassword;
	public LoginPage enterPassword(String password)
	{
		type(elePassword,password);
		return this;
	}
	
	@FindBy(className="decorativeSubmit")
	WebElement eleLoginButton;
	public HomePage clickLogin()
	{
		click(eleLoginButton,"Login Button");
		return new HomePage(driver,test);
	}

}
