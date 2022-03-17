package com.crm.GenericLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListenerImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result)
	{
		String MethodName=result.getMethod().getMethodName();
		//Reporter.log(MethodName+"----testscript execution started");
		test=report.createTest(MethodName);
		
	}
	

	public void onTestSuccess(ITestResult result)
	{
	String MethodName=result.getMethod().getMethodName();
	//Reporter.log(MethodName+"----testscript execution success");
test.log(Status.PASS, MethodName+"--->passed");
		
	}
	
	public void onTestFailure(ITestResult result)
	  {
		
		String path=null;
		
		
		String MethodName=result.getMethod().getMethodName();
		Reporter.log(MethodName+"----testscript failed");
		
		//step1:configure screenshot name
		
		String screenshotName=MethodName+new JavaUtility().getSystemDateInFormat();
		System.out.println(screenshotName);
		
		//step2:using screenshot method from webdriver
		
		try {
			path=new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenshotName);
			
			//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			//File src = eDriver.getScreenshotAs(OutputType.FILE);
			//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
			 //path = "./Screenshots/"+screenshotName+".png";
			//File dst = new File(path);
			//Files.copy(src, dst);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, MethodName+"---->failed");
		//it will capture the exeception and log it in the report
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(path);
		
			
			
		}


	
	
public void onTestSkipped(ITestResult result)
   {
	String MethodName=result.getMethod().getMethodName();
	//Reporter.log(MethodName+"----testscript skipped");
	test.log(Status.SKIP, MethodName+"---->skipped");
	//it will capture the execption and log it in report
	test.log(Status.SKIP, result.getThrowable());
		
	
	}

	



	public void onFinish(ITestContext context) 
	{
		//consolidate all parameters and generate the report
		report.flush();
		
		
	}

	public void onStart(ITestContext context)
	{
		//Execution wil start here
		/*Configure the report*/
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtendReports/Report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("SDET_30 EXE Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Selenium execution report");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("OS","Windows");
		report.setSystemInfo("base-url","http://localhost:8888");
		report.setSystemInfo("reporter name", "Rakshitha");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	
	

	
}
