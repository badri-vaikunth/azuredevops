package constants;

import org.w3c.dom.NodeList;

import java.time.Duration;

public class FrameworkConstants 
{
	private FrameworkConstants()
	{
		
	}
	
	private static final String soapPayloadDir = System.getProperty("user.dir")+"/src/test/resources/soap-payloads";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output";
	private static String EXTENTREPORTFILEPATH = EXTENTREPORTFOLDERPATH+"/index.html";
	private static final String PROPERTYFILEPATH = System.getProperty("user.dir")+"/src/test/resources/config/appConfig.properties";

	private static final String PROPERTYFILEPATHQA = System.getProperty("user.dir")+"/src/test/resources/config/appConfigQAEnv.properties";
	private static final String PROPERTYFILEPATHR1 = System.getProperty("user.dir")+"/src/test/resources/config/appConfigR1Env.properties";
	private static final String PROPERTYFILEPATHR2 = System.getProperty("user.dir")+"/src/test/resources/config/appConfigR2Env.properties";
	private static final String PROPERTYFILEPATHR3 = System.getProperty("user.dir")+"/src/test/resources/config/appConfigR3Env.properties";
	private static final String PROPERTYFILEPATHCAS = System.getProperty("user.dir")+"/src/test/resources/config/appConfigCASEnv.properties";


	private static final String APPDATAFILEPATHQA = System.getProperty("user.dir")+"/src/test/resources/config/appDataQAEnv.properties";
	private static final String APPDATAFILEPATHR1 = System.getProperty("user.dir")+"/src/test/resources/config/appDataR1Env.properties";
	private static final String APPDATAFILEPATHR2 = System.getProperty("user.dir")+"/src/test/resources/config/appDataR2Env.properties";
	private static final String APPDATAFILEPATHR3 = System.getProperty("user.dir")+"/src/test/resources/config/appDataR3Env.properties";
	private static final String APPDATAFILEPATHCAS = System.getProperty("user.dir")+"/src/test/resources/config/appDataCASEnv.properties";



	private static final String APPDATAFILEPATH = System.getProperty("user.dir")+"/src/test/resources/config/appData.properties";
	private static final int EXPLICITWAIT = 90;
	private static final int IMPLICITWAIT = 30;
	private static final String HTMLSUMMARYTEMPLATE = System.getProperty("user.dir")+"/summary-output/template.html";
	private static final String HTMLSUMMARYINDEX = System.getProperty("user.dir")+"/summary-output/index.html";

	private static String sessionRequestId = "";
	private static String saleRequestId = "";
	private static String sessionProcessorToken = "";


	public static String getSoapPayloadDir()
	{
		return soapPayloadDir.trim();
	}
	
	public static String getExtentReportPath()
    {
        if(EXTENTREPORTFILEPATH.isEmpty())
        {
            EXTENTREPORTFILEPATH = EXTENTREPORTFILEPATH+"/index.html";
        }
        return EXTENTREPORTFILEPATH;
    }
	
	public static String getPropertyFilePath()
	{
		return PROPERTYFILEPATH;
	}

	public static String getPropertyFilePathQA()
	{
		return PROPERTYFILEPATHQA;
	}

	public static String getPropertyFilePathR1()
	{
		return PROPERTYFILEPATHR1;
	}

	public static String getPropertyFilePathR2()
	{
		return PROPERTYFILEPATHR2;
	}

	public static String getPropertyFilePathR3()
	{
		return PROPERTYFILEPATHR3;
	}

	public static String getPropertyFilePathCAS()
	{
		return PROPERTYFILEPATHCAS;
	}
	
	public static String getAppDataFilePath()
	{
		return APPDATAFILEPATH;
	}
	
	public static int getExplicitWait()
	{
		return EXPLICITWAIT;
	}
	
	public static int getImplicitWait()
	{
		return IMPLICITWAIT;
	}
	
	public static String getHTMLSummaryTemplate()
	{
		return HTMLSUMMARYTEMPLATE;
	}
	
	public static String getHTMLSummaryIndex()
	{
		return HTMLSUMMARYINDEX;
	}

	public static void setSessionRequestId(String id)
	{
		sessionRequestId = id.trim();
	}

	public static void setSaleRequestId(String id)
	{
		saleRequestId = id.trim();
	}

	public static String getSessionRequestIdId()
	{
		return sessionRequestId;
	}
	public static String getSaleRequestId()
	{
		return saleRequestId;
	}

	public static void setSessionProcessorToken(String token)
	{
		sessionProcessorToken = token.trim();
	}

	public static String getSessionProcessorToken()
	{
		return sessionProcessorToken;
	}



	public static String getAppDataFilePathQA()
	{
		return APPDATAFILEPATHQA;
	}

	public static String getAppDataFilePathR1()
	{
		return APPDATAFILEPATHR1;
	}

	public static String getAppDataFilePathR2()
	{
		return APPDATAFILEPATHR2;
	}

	public static String getAppDataFilePathR3()
	{
		return APPDATAFILEPATHR3;
	}

	public static String getAppDataFilePathCAS()
	{
		return APPDATAFILEPATHCAS;
	}


}
