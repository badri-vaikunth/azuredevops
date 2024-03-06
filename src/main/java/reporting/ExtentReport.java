package reporting;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import constants.FrameworkConstants;

public class ExtentReport 
{
	private static ExtentReports extent;
	
	private ExtentReport()
	{
		
	}
	
	public static void initReports()
	{
		if(Objects.isNull(extent))
		{
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportPath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setTimelineEnabled(true);
            spark.config().setDocumentTitle("AltPay Test Report");
            spark.config().setReportName("Altpay Automation Report");
		}
	}
	
	 public static void flushReport() throws Exception
     {
        if(Objects.nonNull(extent))
        {
            extent.flush();
            ExtentManager.unloadReport();
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportPath()).toURI());
        }
     }

	    public static void createTest(String testcasename, String category)
	    {
	        ExtentManager.setExtentTest(extent.createTest(testcasename).assignCategory(category));
	    }

	    public static void addAuthor(String author)
	    {
	        ExtentManager.getExtentTest().assignAuthor(author);
	    }

	    public static void addCategory(String category)
	    {
	        ExtentManager.getExtentTest().assignCategory(category);
	    }

		public static void addBDDScenario(String bdd)
		{

		}

}
