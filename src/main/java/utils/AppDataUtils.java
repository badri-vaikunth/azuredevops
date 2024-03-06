package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import constants.FrameworkConstants;

public class AppDataUtils 
{
	private AppDataUtils()
	{
		
	}

	private static FileInputStream fin = null;
	private static Properties property = new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap<String,String>();
	
	static
	{
		try
		{
			//FileInputStream fin = new FileInputStream(FrameworkConstants.getAppDataFilePath());
			switch(System.getProperty("ENV").toUpperCase())
			{
				case "QA":
					fin = new FileInputStream(FrameworkConstants.getAppDataFilePathQA());
					break;
				case "R1":
					fin = new FileInputStream(FrameworkConstants.getAppDataFilePathR1());
					break;
				case "R2":
					fin = new FileInputStream(FrameworkConstants.getAppDataFilePathR2());
					break;
				case "R3":
					fin = new FileInputStream(FrameworkConstants.getAppDataFilePathR3());
					break;
				case "CAS":
					fin = new FileInputStream(FrameworkConstants.getAppDataFilePathCAS());
					break;
			}
			property.load(fin);
			
			for(Object key : property.keySet())
			{
				CONFIGMAP.put(String.valueOf(key), String.valueOf(property.get(key)).trim());
			}
				
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static String get(String key)
	{
		return CONFIGMAP.get(key);
	}
}
