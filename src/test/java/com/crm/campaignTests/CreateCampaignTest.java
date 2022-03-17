package com.crm.campaignTests;

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

public class CreateCampaignTest {
	@Test
	public void createCampaignTest() throws Throwable
	{
		/*generate random number*/
		Random ran = new Random();
		int random = ran.nextInt(500);
		
		/*Step 1: read all neccessary data*/
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
		Sheet sh = wb.getSheet("Product");
		Row ro = sh.getRow(1);
		Cell cel = ro.getCell(2);
		String camname = cel.getStringCellValue();
		String camnameran=camname+" "+random;
		
		Cell ce = ro.getCell(3);
		String productname = ce.getStringCellValue()+random;
		
		
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
		
		/*Step 4: create products*/
		driver.findElement(By.linkText("Products")).click();
		
		/*Step 5: click on create new product*/
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		/*Step 6: enter mandatory fields and save*/
		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 7:verify for product*/
		String header = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(header.contains(productname))
		{
			System.out.println(header);
			System.out.println("Product created");
		}
		else
		{
			System.out.println(header);
			System.out.println("Product not created");
		}
		
		
		
		
		 WebElement ele2 = driver.findElement(By.xpath("//a[@href='javascript:;']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele2).perform();
		/*step 8: navigate to campaign link*/
		
		driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(camnameran);
		
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		/*Step 9: choose org */
		Set<String> win = driver.getWindowHandles();
		for(String winId:win)
		{
			driver.switchTo().window(winId);
		}
		
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(productname);
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[.='"+productname+"']")).click();
		
		Set<String> win1 = driver.getWindowHandles();
		for(String wi : win1)
		{
			driver.switchTo().window(wi);
		}
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 10: verify for contact*/
		String campaignHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(campaignHeader.contains(camnameran))
		{
			System.out.println(campaignHeader +" campaign created");
		}
		else
		{
			System.out.println("campaign not created");
		}
		
		/*Step 11: logout and close the browser*/
		//WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Actions act1 = new Actions(driver);
		//act1.moveToElement(element).perform();
		
		//driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
	}
}

	


