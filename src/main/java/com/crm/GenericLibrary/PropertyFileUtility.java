package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class wil read data from property file and return value to user
 * @author Rakshitha
 *
 */

public class PropertyFileUtility {
	
	public String readdataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.FilePath);
		Properties pLib=new Properties();
		pLib.load(fis);
		String value = pLib.getProperty(key);
		return value;
	}

}
