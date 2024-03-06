package ui;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import driver.SeleniumDriver;

public class BaseTestImplementation 
{
	protected BaseTestImplementation()
	{
		
	}
	
	@BeforeTest(alwaysRun = true)
	protected void setup()
	{
		try 
		{
			SeleniumDriver.initDriver(System.getProperty("Browser").toString());
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
	}
	
	@AfterTest(alwaysRun = true)
	protected void teardown()
	{
		SeleniumDriver.quitDriver();
	}
}
