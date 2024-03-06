package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FrameworkConstants;
import driver.DriverManager;
import reporting.ExtentLogger;

public class EBCLoginpage 
{
	private WebDriverWait explicitWait = null;
	
	@FindBy(xpath="//input[@id='orgId']")
	WebElement orgTextBox;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement usernameTextBox;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//span[text()='LOG IN']")
	WebElement loginButton;
	
	@FindBy(xpath="//img[@src='logo_blue_beta.png']")
	WebElement headerSpan;
	
	@FindBy(xpath="//strong[text()='Forgot Password']")
	WebElement incorrectPasswordAlert;
	
	public EBCLoginpage()
	{
		System.out.println("PRINTING THE EXPLICIT WAIT");
		System.out.println(FrameworkConstants.getExplicitWait());
		this.explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()));
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public boolean isExistsEbcLoginPage()
	{
		
		explicitWait.until(ExpectedConditions.visibilityOf(orgTextBox));
		if(orgTextBox.isDisplayed()) 
		{
			ExtentLogger.pass("ORG ID Textbox Exists in the EBC Login Page");
			return true;
		}
		ExtentLogger.fail("ORG ID Textbox Does not Exists in the EBC Login Page");
		return false;
	}
	
	public void enterOrg(String orgName)
	{
		explicitWait.until(ExpectedConditions.visibilityOf(orgTextBox));
		try
		{
			orgTextBox.click();
			orgTextBox.sendKeys(orgName);
			ExtentLogger.pass("Entered OrgName in the Login Page :"+orgName);
		}
		catch(Exception ex)
		{
			ExtentLogger.fail("Unable to enter OrgName in the Login Page");
			ex.printStackTrace();
		}
	}
	
	public void enterUsername(String username)
	{
		explicitWait.until(ExpectedConditions.visibilityOf(usernameTextBox));
		try
		{
			usernameTextBox.click();
			usernameTextBox.sendKeys(username);
			ExtentLogger.pass("Entered Username in the Login Page :"+username);
		}
		catch(Exception ex)
		{
			ExtentLogger.fail("Unable to enter Username in the Login Page");
			ex.printStackTrace();
		}
	}
	
	public void enterPassword(String password)
	{
		explicitWait.until(ExpectedConditions.visibilityOf(passwordTextBox));
		try
		{
			passwordTextBox.click();
			passwordTextBox.sendKeys(password);
			ExtentLogger.pass("Entered Password in the Login Page :"+password);
		}
		catch(Exception ex)
		{
			ExtentLogger.fail("Unable to enter Password in the Login Page");
			ex.printStackTrace();
		}
	}
	
	public void clickLoginButton()
	{
		explicitWait.until(ExpectedConditions.visibilityOf(loginButton));
		try
		{
			loginButton.click();
			ExtentLogger.pass("Clicked Login Button");
		}
		catch(Exception ex)
		{
			ExtentLogger.fail("Unable to click Login Button");
			ex.printStackTrace();
		}
	}
	
	public boolean isExistsHomePage()
	{
		explicitWait.until(ExpectedConditions.visibilityOf(headerSpan));
		if(headerSpan.isDisplayed()) 
		{
			ExtentLogger.pass("Nucleus HomePage is displayed");
			return true;
		}
		ExtentLogger.fail("Nucleus HomePage is not displayed");
		return false;
	}
	
	public boolean isExistsIncorrectPassword()
	{
		
		explicitWait.until(ExpectedConditions.visibilityOf(incorrectPasswordAlert));
		if(incorrectPasswordAlert.isDisplayed()) 
		{
			ExtentLogger.pass("Incorrect Password Notification Appeared");
			return true;
		}
		ExtentLogger.fail("Incorrect Password Notification Not Appeared");
		return false;
	}
}
