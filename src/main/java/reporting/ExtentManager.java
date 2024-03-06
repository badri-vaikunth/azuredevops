package reporting;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager 
{
	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<ExtentTest>();
	
	
    public static ExtentTest getExtentTest()
    {
        return extTest.get();
    }

    static void setExtentTest(ExtentTest test)
    {
        extTest.set(test);
    }

    static void unloadReport()
    {
        extTest.remove();
    }
	
	
}
