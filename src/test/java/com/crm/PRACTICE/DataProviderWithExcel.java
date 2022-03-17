package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;

public class DataProviderWithExcel {
	@Test (dataProvider= "data")
	public void data(String orgname,String indType,String type)
	{
		System.out.println(orgname+" "+indType+" "+type);
			
	}
	@DataProvider(name="data")
	public Object[][] getData() throws Throwable
	{
		ExcelFileUtility elib=new ExcelFileUtility();
		Object[][] value = elib.readmultipleDataFromExcel("OrgMultipleData");
		return value;
		
		
	}

}
