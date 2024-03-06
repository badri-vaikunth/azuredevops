package driver;

import java.net.MalformedURLException;
import java.sql.Driver;
import java.util.Objects;

import factory.DriverFactory;

public class SeleniumDriver 
{
	private SeleniumDriver()
	{
		
	}
	
	public static void initDriver(String browserName) throws MalformedURLException
	{
		if(Objects.isNull(DriverManager.getDriver()))
		{
			try
			{
				DriverManager.setDriver(DriverFactory.getDriver(browserName));
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	public static void quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.getDriver().quit();
			DriverManager.unloadDriver();
		}
	}
}
