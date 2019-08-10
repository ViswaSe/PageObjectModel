package com.leaftaps.utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Reporter {

	public static ExtentHtmlReporter html;
	public static ExtentReports extent;
	public ExtentTest suiteTest,test;
	public String iteration,author,category;

	public void beginResult()
	{
		html=new ExtentHtmlReporter("./reports/final_report.html");
		html.setAppendExisting(true);
		extent=new ExtentReports();
		extent.attachReporter(html);
	}

	public ExtentTest createTestCase(String testCaseName,String testCaseDescription)
	{
		suiteTest=extent.createTest(testCaseName,testCaseDescription);
		return suiteTest;
	}

	public ExtentTest startIteration()
	{
		test=suiteTest.createNode(iteration);
		test.assignAuthor(author);
		test.assignCategory(category);
		return test;
	}

	public abstract long takeSnap();

	public void reportStep(String desc,String status,boolean value)
	{
		MediaEntityModelProvider img=null;

		try 
		{
			if(value && !(status.equals("info")))
			{
				long snapNumber=10000000L;
				snapNumber=takeSnap();
				img=MediaEntityBuilder
						.createScreenCaptureFromPath("./../reports/screenshots/"+snapNumber+".jpg").build();
			}

			if(status.equals("pass"))
				test.pass(desc,img);

			else if(status.equals("fail"))
				test.fail(desc,img);

			else if(status.equals("info"))
				test.info(desc);
		} 

		catch (IOException e) 
		{
			throw new RuntimeException();
		}
	}

	public void reportStep(String desc,String status)
	{
		reportStep(desc,status,true);
	}
	
	public void publishReport()
	{
		extent.flush();
	}

}
