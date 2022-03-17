package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelSheetTest {
	
	@Test
	public void readDataFromExcelSheetTest() throws Throwable
	{
		//step1:load excelfile
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		
		
		//step2:create a workbook
	Workbook wb = WorkbookFactory.create(fis);
	//step3:get the sheet
	Sheet sh = wb.getSheet("Sheet1");
	
	//step4:get the row
	Row ro = sh.getRow(3);
	
	//step5:get the cell
	Cell ce = ro.getCell(1);
	//step6:read the data from the cell
	String value = ce.getStringCellValue();
	System.out.println(value);
	
	}

}


