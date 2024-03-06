package factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.PropertyUtils;

public class DriverFactory 
{
	private DriverFactory()
	{
		
	}
	
//	private static DesiredCapabilities chromeCapability = DesiredCapabilities.
//	private static DesiredCapabilities firefoxCapability = DesiredCapabilities.firefox();
	public static WebDriver driver = null;

	
	public static WebDriver getDriver(String browserName) throws MalformedURLException
	{
		String runmode=PropertyUtils.get("RUNMODE");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{			
			if(runmode.equalsIgnoreCase("remote"))
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized"); // open Browser in maximized mode
				options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
				options.addArguments("--remote-allow-origins=*");
				driver = new RemoteWebDriver(new URL("https://browserstack/vm1:8080:UN&Pwd"), options);
				driver.manage().window().maximize();
			}
			else
			{
				ChromeOptions options = new ChromeOptions();
				//WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
			}
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			if(runmode.equalsIgnoreCase("remote"))
			{				
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--start-maximized"); // open Browser in maximized mode
				options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
				driver = new RemoteWebDriver(new URL(""), options);
				driver.manage().window().maximize();
			}
			else
			{
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
		}
		return driver;
	}
}
