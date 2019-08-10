package com.leaftaps.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.leaftaps.utils.Reporter;

public class SeMethods extends Reporter implements WdMethods{

	public RemoteWebDriver driver;
	public WebElement ele;
	public String text;
	public boolean result;
	public static String firstResultingLeadName,firstResultingLeadId,secondResultingLeadId;

	public void startApp(String browser, String url) {

		try
		{
			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
				driver=new ChromeDriver();
				driver.get(url);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				reportStep("Chrome browser launched successfully","pass");
			}

			else if(browser.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
				driver=new FirefoxDriver();
				driver.get(url);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				reportStep("Firefox browser launched successfully","pass");
			}
		} 
		catch (Exception e) 
		{
			reportStep("Browser not found or invoked properly","fail");
			throw new RuntimeException();
		}
	}

	public WebElement locateElement(String locator, String locValue) {

		try
		{
			switch(locator)
			{
			case "id"		: 
				ele=driver.findElementById(locValue);return ele;
			case "name" 	:
				ele=driver.findElementByName(locValue);return ele;
			case "classname":
				ele=driver.findElementByClassName(locValue);return ele;
			case "linkText"	:
				ele=driver.findElementByLinkText(locValue);return ele;
			case "partial"	:
				ele=driver.findElementByPartialLinkText(locValue);return ele;
			}
		} 
		catch (Exception e) 
		{
			reportStep("No such element found in the webpage", "fail");
		}

		return null;
	}

	public WebElement locateElement(String locValue) {

		try
		{
			ele=driver.findElementByXPath(locValue);
			return ele;
		} 

		catch (Exception e) 
		{
			reportStep("No such element found in the webpage", "fail");
		}

		return null;
	}

	public void clear(WebElement ele)
	{
		ele.clear();
	}

	public void type(WebElement ele, String data) {

		try
		{
			ele.sendKeys(data);
			reportStep(data+" value has been sent to the webelement successfully","pass");
		}
		catch (Exception e) 
		{
			reportStep("Issue while sending the data to the webelement","fail");
			throw new RuntimeException();
		}

	}

	public void click(WebElement ele,String eleName) {

		try 
		{
			ele.click();
			reportStep(eleName+" webelement clicked successfully","pass");
		} 
		catch (Exception e) {
			reportStep("user not able to click the webelement: "+eleName+" successfully","fail");
			throw new RuntimeException();
		}
	}	

	public void clickWithoutSS(WebElement ele,String eleName) {

		try 
		{
			ele.click();
			reportStep(eleName+" webelement clicked successfully","info");
		} 
		catch (Exception e) {
			reportStep("user not able to click the webelement: "+eleName+" successfully","info");
			throw new RuntimeException();
		}
	}	


	public String getText(WebElement ele) {

		try {
			text=ele.getText();
			reportStep("Retrived the text of webelement successfully"+text,"pass");
			return text;
		} 
		catch (Exception e) {
			reportStep("user couldn't retrived the text of webelement"+text,"fail");
		}
		return null;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {

		try 
		{
			Select ob=new Select(ele);
			ob.selectByVisibleText(value);
			reportStep("Dropdown value: "+value+" has been selected using visible text successfully","pass");
		} 

		catch (Exception e) {
			reportStep("user couldn't select the appropiate value:"+value+" from the dropdown based on the visible text","fail");
			throw new RuntimeException();
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {

		try {
			Select ob=new Select(ele);
			ob.selectByIndex(index);
			reportStep("Dropdown value selected using index successfully","pass");
		} 

		catch (Exception e) {
			reportStep("user couldn't select the appropiate value from the dropdown based on the given index","fail");
			throw new RuntimeException();
		}

	}

	public boolean verifyTitle(String expectedTitle) {

		try 
		{
			text=driver.getTitle();
			if(text.equals(expectedTitle))
				reportStep("Title value of webpage matching successfully: "+text,"pass");
			return true;
		}
		catch (Exception e) {
			reportStep("Title value of webpage doesn't matching","fail");		
		}

		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {

		try 
		{
			text=ele.getText();
			if(text.equals(expectedText))
				reportStep("Text value: "+text+" matching exactly as expected","pass");
		} 

		catch (Exception e) {
			reportStep("Text value: "+text+" doesn't matching exactly as expected","fail");
		}

	}

	public void verifyPartialText(WebElement ele, String expectedText) {

		try 
		{
			text=ele.getText();
			if(text.contains(expectedText))
				reportStep("Text value: "+text+" matching partially as expected","pass");
		} 

		catch (Exception e) {
			reportStep("Text value: "+text+" doesn't matching exactly as expected","fail");
		}

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try 
		{
			text=ele.getAttribute(attribute);
			if(text.equals(value))
				reportStep("Attribute value:"+text+" is matching successfully as expected","pass");
		} 
		catch (Exception e) 
		{
			reportStep("Attribute value:"+text+" doesn't matching successfully as expected","fail");
		}

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try 
		{
			text=ele.getAttribute(attribute);
			if(text.contains(value))
				reportStep("Attribute value:"+text+" is partially matching successfully as expected","pass");
		} 
		catch (Exception e) 
		{
			reportStep("Attribute value:"+text+" doesn't matching successfully as expected","fail");
		}

	}

	public void verifySelected(WebElement ele) {

		try 
		{
			result=ele.isSelected();
			if(result)
				reportStep("webelement:"+ele.getText()+" is selected","pass");
			else
				reportStep("webelement:"+ele.getText()+" is not selected in the webpage","fail");
		} 
		catch (Exception e) 
		{
			reportStep("user couldn't able to check whether the webelement is selected or not","fail");
		}
	}

	public void verifyDisplayed(WebElement ele) {

		try 
		{
			result=ele.isSelected();
			if(result)
				reportStep("webelement:"+ele.getText()+" is displayed","pass");
			else
				reportStep("webelement:"+ele.getText()+" is not displayed in the webpage","fail");
		} 
		catch (Exception e) 
		{
			reportStep("user couldn't able to check whether the webelement is displayed or not","fail");
			throw new RuntimeException();
		}

	}

	public void switchToWindow(int index) {

		try 
		{
			Set<String> windows=driver.getWindowHandles();
			List<String> list=new ArrayList<String>(windows);
			driver.switchTo().window(list.get(index));
			reportStep("user switched to the respective window","pass");
		} 
		catch (Exception e) {
			reportStep("user couldn't switch to the respective window","fail");
			throw new RuntimeException();
		}

	}

	public void switchToFrame(WebElement ele) {

		try {
			driver.switchTo().frame(ele);
			reportStep("user switched to the frame successfully","pass");
		} 
		catch (Exception e) {
			reportStep("user couldn't switch to the respective frame","fail");
			throw new RuntimeException();
		}
	}

	public void acceptAlert() {

		try {
			driver.switchTo().alert().accept();
			reportStep("user switched and aceepted the alert","pass");
		} 
		catch (Exception e) {
			reportStep("user couldn't switch to the alert","fail");
			throw new RuntimeException();
		}

	}

	public void dismissAlert() {

		try {
			driver.switchTo().alert().dismiss();
			reportStep("user switched and dismissed the alert","pass");
		} 
		catch (Exception e) {
			reportStep("user couldn't switch to the alert","fail");
			throw new RuntimeException();
		}

	}

	public String getAlertText() {
		text=driver.switchTo().alert().getText();
		return text;
	}

	public long takeSnap() {

		long number = (long) Math.floor(Math.random() * 90000000L) + 10000000L;
		try 
		{ 
			File src=driver.getScreenshotAs(OutputType.FILE);
			File desc=new File("./reports/screenshots/"+number+".jpg");
			FileUtils.copyFile(src, desc);
		}
		catch (Exception e) 
		{
//			reportStep("snapshot couldn't be taken","fail");
			throw new RuntimeException();
		}

		return number;
	}

	public void closeBrowser() {
		driver.close();
	}

	public void closeAllBrowsers() {
		driver.quit();
	}

}
