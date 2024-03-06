package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import constants.FrameworkConstants;

public class PropertyUtils 
{
	private PropertyUtils()
	{
		
	}
	
	private static Properties property = new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap<String,String>();

	private static FileInputStream fin = null;
	
	static
	{
		try
		{
			switch(System.getProperty("ENV").toUpperCase())
			{
				case "QA":
					fin = new FileInputStream(FrameworkConstants.getPropertyFilePathQA());
					break;
				case "R1":
					fin = new FileInputStream(FrameworkConstants.getPropertyFilePathR1());
					break;
				case "R2":
					fin = new FileInputStream(FrameworkConstants.getPropertyFilePathR2());
					break;
				case "R3":
					fin = new FileInputStream(FrameworkConstants.getPropertyFilePathR3());
					break;
				case "CAS":
					fin = new FileInputStream(FrameworkConstants.getPropertyFilePathCAS());
					break;
			}

//			FileInputStream fin = new FileInputStream(FrameworkConstants.getPropertyFilePath());
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
