package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataIntoExcelSheetTest 
{
@Test
public void writeDataIntoExcelSheetTest() throws Throwable
{
	//open the file in read mode
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
 Sheet sh = wb.getSheet("Sheet1");
 Row ro = sh.getRow(0);
 
 //create a cell to write new data
 
 Cell ce = ro.createCell(9);
 
 //set a cell value
 ce.setCellValue("tc_1000");
 
 
 //open the file in write mode
 
 FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Data.xlsx");
 wb.write(fos);

	
	
}
}
