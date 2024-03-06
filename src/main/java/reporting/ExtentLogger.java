package reporting;

import com.aventstack.extentreports.MediaEntityBuilder;

import utils.ScreenshotUtils;

public class ExtentLogger 
{
	private ExtentLogger()
	{
		
	}
	
	public static void pass(String message)
	{
		ExtentManager.getExtentTest().pass(message);
		//ExtentManager.getExtentTest().pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	}
	
	public static void fail(String message)
	{
		ExtentManager.getExtentTest().fail(message);
		//ExtentManager.getExtentTest().fail(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	}
	
	public static void skip(String message)
	{
		ExtentManager.getExtentTest().skip(message);
		//ExtentManager.getExtentTest().skip(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	}
}
