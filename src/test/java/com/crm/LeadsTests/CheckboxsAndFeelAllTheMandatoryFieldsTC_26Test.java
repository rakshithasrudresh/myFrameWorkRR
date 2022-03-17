package com.crm.LeadsTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CheckboxsAndFeelAllTheMandatoryFieldsTC_26Test
 {
	 @Test
		public void checkboxsandfillAlltheMandatoryFielsTC_26Test() throws Throwable
		{
			/*generate random number*/
			Random ran = new Random();
			int random = ran.nextInt(500);
			
			/*Step 1: read all necessary data*/
			//read data from property file
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties pObj = new Properties();

			pObj.load(fis);
			String BROWSER = pObj.getProperty("browser");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("username");
			String PASSWORD = pObj.getProperty("password");
			
			//read data from excel sheet
			FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet("leads");
			Row ro = sh.getRow(1);
			Cell cel = ro.getCell(0);
			String LastName = cel.getStringCellValue();
			String LastNameRan=LastName+" "+random;
			Cell ce = ro.getCell(1);
			String Company = ce.getStringCellValue();
			String CompanyRan=Company+" "+random;
			
			/*Step 2: launch the browser*/
			WebDriver driver=null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else		

			{
				System.out.println("invalid browser");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);
			
			/*Step 3: login to application*/
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			/*Step 4: Navigate to leads Link*/
			driver.findElement(By.linkText("Leads")).click();
			
			/*Step 5: click on create lead+ button*/
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			/*Step 6: enter mandatory fields and save*/
			driver.findElement(By.name("lastname")).sendKeys(LastNameRan);
			driver.findElement(By.name("company")).sendKeys(CompanyRan);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			/*Step 7:verify for lead*/
			String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(header.contains(LastNameRan))
			{
				System.out.println(header);
				System.out.println(" lead created");
			}
			else
			{
				System.out.println(header);
				System.out.println("Lead not created");
			}
			
			/*step 8: navigate to convertleadlink*/
			driver.findElement(By.xpath("//a[.='Convert Lead']")).click();
			
			
			
			
			
			
			
			
			/*Step 9: switch window */
			Set<String> win = driver.getWindowHandles();
			for(String winId:win)
			{
				driver.switchTo().window(winId);
			}
			
			
			driver.findElement(By.name("Save")).click();
			
			
			
			
			
			Set<String> win1 = driver.getWindowHandles();
			for(String wi : win1)
			{
				driver.switchTo().window(wi);
			}
			
		
			
			/*Step 10: verify for company*/
			String CompanyHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(CompanyHeader.contains(CompanyRan))
			{
				System.out.println(CompanyHeader +" company created");
			}
			else
			{
				System.out.println("company not created");
			}
			
			/*Step 11: logout and close the browser*/
			WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
			
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();
			
		
	

			
			
	}
	}

