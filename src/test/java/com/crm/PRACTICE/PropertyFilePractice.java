package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractice {
	@Test
	public void propertyFile() throws Throwable 
	{
		//step1:read the file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		
		//step2:Create obj of properties
		Properties pObj=new Properties();
		pObj.load(fis);
		
		//step3:read the data
		String URL=pObj.getProperty("url");
		
		//verification
		
		System.out.println(URL);
		
	}

}
