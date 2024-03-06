package customlisteners;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import annotations.FrameworkAnnotation;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.LoggerFactory;
import org.testng.*;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;

import constants.FrameworkConstants;
import freemarker.log.Logger;
import reporting.ExtentLogger;
import reporting.ExtentManager;
import reporting.ExtentReport;
import utils.ELKUtils;
import utils.InfluxUtils;

public class ListenerClass extends TestListenerAdapter implements ISuiteListener, ITestListener {
	
	private int total=0;
	private int passed=0;
	private int failed=0;
	File htmlTemplateFile = null;
	
	@Override
    public void onStart(ISuite suite)
    {
    	System.out.println("Inside OnStart");
        ExtentReport.initReports();
        htmlTemplateFile = new File(FrameworkConstants.getHTMLSummaryTemplate());
    }

	@Override
	public void onFinish(ISuite suite)
	{	
		try 
		{
			ExtentReport.flushReport();
			total = passed+failed;
			System.out.println("Total Testcases Executed - "+total);
			System.out.println("Total Testcases Passed - "+passed);
			System.out.println("Total Testcases Failed - "+failed);
			
			
			
			String htmlString = FileUtils.readFileToString(htmlTemplateFile);
			String title = "New Page";
			//String body = "This is Body";
			
			
		    //String body = RandomStringUtils.randomAlphanumeric(20).toUpperCase().toString();
		    
			//System.out.print("for" + "\n\n\n" + "example");
		    String body = "Total Testcases Executed : "+total + "\n"+"Total Testcases Passed : "+passed+ "\n"+"Total Testcases Failed : "+failed;
			
			
			htmlString = htmlString.replace("$title", title);
			htmlString = htmlString.replace("$body", body);
			File newHtmlFile = new File(FrameworkConstants.getHTMLSummaryIndex());
			FileUtils.writeStringToFile(newHtmlFile, htmlString);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
//	@Override
//	public void onFinish(ITestContext iTestContext)
//	{	
//		try 
//		{
//			  this.postTestClassStatus(iTestContext);
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		ExtentReport.createTest(result.getMethod().getMethodName(),result.getTestClass().getRealClass().getSimpleName());
	}
    
	@Override
    public void onTestSuccess(ITestResult result)
    {
		ExtentLogger.pass(result.getMethod().getMethodName()+" is Passed");
		//ExtentLogger.pass(String.valueOf(ExtentManager.getExtentTest().assignCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.FrameworkAnnotations.class).bddScenario())));
		passed = passed+1;
		//ELKUtils.sendDetailsToELK(result.getMethod().getDescription(), "pass");
		//InfluxUtils.sendDataToInflux(result.getMethod().getDescription(), "pass", System.getProperty("author"));
	//	this.postTestMethodStatus(result, "PASS");
    }

	@Override
	public void onTestFailure(ITestResult result)
	{
		ExtentLogger.fail(result.getMethod().getMethodName()+" is Failed");
		ExtentLogger.fail(result.getThrowable().toString());
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		failed = failed+1;
		//ELKUtils.sendDetailsToELK(result.getMethod().getDescription(), "fail");
		//InfluxUtils.sendDataToInflux(result.getMethod().getDescription(), "fail", System.getProperty("author"));
		//this.postTestMethodStatus(result, "FAIL");
	}
	
	private void postTestMethodStatus(ITestResult iTestResult, String status) {
//	    Point point = Point.measurement("testmethod").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
//	        .tag("testclass", iTestResult.getTestClass().getName()).tag("name", iTestResult.getName())
//	        .tag("description", iTestResult.getMethod().getDescription()).tag("result", status)
//	        .addField("duration", (iTestResult.getEndMillis() - iTestResult.getStartMillis())).build();
//	    InfluxUtils.send(point);
	  }

	
	
	private void postTestClassStatus(ITestContext iTestContext) 
	{
//		com.influxdb.client.write.Point point = com.influxdb.client.write.Point.measurement("testclass"))
//	        .addT("name", iTestContext.getAllTestMethods()[0].getTestClass().getName())
//	        .addField("duration", (iTestContext.getEndDate().getTime() - iTestContext.getStartDate().getTime()))
//	        .build();
//	    InfluxUtils.post(point);
	  }

	
}
