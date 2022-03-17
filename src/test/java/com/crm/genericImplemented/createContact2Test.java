package com.crm.genericImplemented;

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
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createContact2Test {
	 @Test
		public void createContactTest() throws Throwable
		{

			WebDriverManager.chromedriver().setup();
			WebDriverManager.firefoxdriver().setup();
		 /*read data*/
			PropertyFileUtility pLib = new PropertyFileUtility();
			JavaUtility jLib = new JavaUtility();
			ExcelFileUtility eLib = new ExcelFileUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			
			/*Step 1: read all neccessary data*/
			String BROWSER = pLib.readdataFromPropertyFile("browser");
			String URL = pLib.readdataFromPropertyFile("url");
			String USERNAME = pLib.readdataFromPropertyFile("username");
			String PASSWORD = pLib.readdataFromPropertyFile("password");
			
			String Lastname=eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
		
			
			
			
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
			
			wLib.maximizeWindow(driver);
			wLib.waitForPageLoad(driver);
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
			driver.findElement(By.name("lastname")).sendKeys(Lastname);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			/*Step 7: logout of application*/
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wLib.mousehover(driver, ele);
			
			//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			
			driver.findElement(By.linkText("Sign Out"));
			
			/*Step 8: close the browser*/
			driver.quit();
	}

}


