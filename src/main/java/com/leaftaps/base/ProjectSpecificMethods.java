package com.leaftaps.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.leaftaps.utils.ExcelUtils;

public class ProjectSpecificMethods extends SeMethods {
	
	public String filename,testCaseName,testCaseDescription,browser;
	public String url="http://leaftaps.com/opentaps/control/main";
	
	@BeforeSuite
	public void startReport()
	{
		beginResult();
	}

	@BeforeClass
	public void createTest()
	{
		createTestCase(testCaseName, testCaseDescription);
	}
	
	@BeforeMethod
	public void login()
	{
		startIteration();
		startApp(browser, url);
	}
	
	@AfterMethod
	public void close()
	{
		closeAllBrowsers();
	}
	
	@AfterSuite
	public void endReport()
	{
		publishReport();
	}
	
	@DataProvider(name="fetchData")
	public Object[][] getData()
	{
		try {
			return ExcelUtils.readData(filename);
		} 
		catch (IOException e) {
			System.out.println("DataProvider exception");
		}
		
		return null;
	}
}
