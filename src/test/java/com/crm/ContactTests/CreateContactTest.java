package com.crm.ContactTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
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

public class CreateContactTest {
	
	 @Test
		public void createContactTest() throws Throwable
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
			Sheet sh = wb.getSheet("Contacts");
			Row ro = sh.getRow(1);
			Cell cel = ro.getCell(2);
			String LastName = cel.getStringCellValue();
			
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
			
			/*Step 4: Navigate to Organizations Link*/
			driver.findElement(By.linkText("Contacts")).click();
			
			/*Step 5: click on create org organization button*/
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			
			/*Step 6: enter mandatory fields and save*/
			driver.findElement(By.name("lastname")).sendKeys(LastName+" "+random);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			/*Step 7: logout of application*/
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			//WebDriverWait wait = new WebDriverWait(driver, 20);
			//wait.until(ExpectedConditions.visibilityOf(ele));
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			
			//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			
			driver.findElement(By.linkText("Sign Out"));
			
			/*Step 8: close the browser*/
			driver.quit();
	}

}
