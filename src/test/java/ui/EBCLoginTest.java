package ui;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.google.common.util.concurrent.Uninterruptibles;

import annotations.FrameworkAnnotation.FrameworkAnnotations;
import driver.DriverManager;
import pages.EBCLoginpage;
import utils.AppDataUtils;
import utils.PropertyUtils;

public class EBCLoginTest extends BaseTestImplementation 
{
	EBCLoginpage ebcLogin;
	
	private EBCLoginTest()
	{
		
	}
	
	@BeforeClass
	public void init()
	{
		System.out.println("Entering the BeforeClass");
		ebcLogin = new EBCLoginpage();
		DriverManager.getDriver().get(PropertyUtils.get("ebcHost"));
		//Uninterruptibles.sleepUninterruptibly(20,TimeUnit.SECONDS);
		DriverManager.getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void navigateToEBC()
	{
//		DriverManager.getDriver().get(PropertyUtils.get("nucleusHost"));
//		//Uninterruptibles.sleepUninterruptibly(20,TimeUnit.SECONDS);
//		DriverManager.getDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	
	@Test(priority = 0)
	public void verifyEBCLoginPage()
	{
		Assert.assertTrue(ebcLogin.isExistsEbcLoginPage());
	}
	
	@Test(priority = 1)
	public void performLoginAndVerify()
	{
		Uninterruptibles.sleepUninterruptibly(2,TimeUnit.SECONDS);
		ebcLogin.enterOrg(AppDataUtils.get("orgid"));
		Uninterruptibles.sleepUninterruptibly(2,TimeUnit.SECONDS);
		ebcLogin.enterUsername(AppDataUtils.get("username"));
		Uninterruptibles.sleepUninterruptibly(2,TimeUnit.SECONDS);
		ebcLogin.enterPassword(AppDataUtils.get("password"));
		Uninterruptibles.sleepUninterruptibly(2,TimeUnit.SECONDS);
		ebcLogin.clickLoginButton();
		Uninterruptibles.sleepUninterruptibly(2,TimeUnit.SECONDS);
		Assert.assertTrue(ebcLogin.isExistsIncorrectPassword());
	}
	
	
}

