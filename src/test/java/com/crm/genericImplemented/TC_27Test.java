package com.crm.genericImplemented;

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
import org.openqa.selenium.Alert;
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

public class TC_27Test {
	 @Test
		public void checkboxestheMandatoryFielsTC_27Test() throws Throwable
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
			
			String Lastname=eLib.readDataFromExcel("leads", 1, 0)+"_"+jLib.getRandomNumber();
			String CompanyName=eLib.readDataFromExcel("leads", 1, 1)+"_"+jLib.getRandomNumber();	
			
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
			
			/*Step 4: Navigate to leads Link*/
			driver.findElement(By.linkText("Leads")).click();
			
			/*Step 5: click on create lead+ button*/
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			/*Step 6: enter mandatory fields and save*/
			driver.findElement(By.name("lastname")).sendKeys(Lastname);
			driver.findElement(By.name("company")).sendKeys(CompanyName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			/*Step 7:verify for lead*/
			String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(header.contains(Lastname))
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
           wLib.switchToWindow(driver,"Convert Lead ");
			
			driver.findElement(By.xpath("//input[@value='Potentials']")).click();
			//driver.findElement(By.xpath("//img[@src='themes/images/miniCalendar.gif']")).click();
			
			driver.findElement(By.name("Save")).click();
			
			
			//error msg-alert window
			wLib.acceptAlert(driver);
			
			wLib.switchToWindow(driver,"Leads");
			
		
			
			/*Step 10: verify for company*/
			String CompanyHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(CompanyHeader.contains(CompanyName))
			{
				System.out.println(CompanyHeader +" company created");
			}
			else
			{
				System.out.println("company not created");
			}
			
			/*Step 11: logout and close the browser*/
			WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wLib.mousehover(driver, element);
			
			driver.findElement(By.linkText("Sign Out")).click();
			driver.quit();
			
		
	

			
			
	}

}
