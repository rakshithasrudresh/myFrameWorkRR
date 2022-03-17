package com.crm.genericImplemented;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOppurtunitywithContactsandEmployeeTest{
	@Test
	public void createOppurtunitywithContactsandEmployeeTest() throws Throwable
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
		
			String name=eLib.readDataFromExcel("oppurtunity", 1, 1)+"_"+jLib.getRandomNumber();
			String contacts=eLib.readDataFromExcel("oppurtunity", 1, 2);	
			String campaignsource=eLib.readDataFromExcel("oppurtunity", 1, 3)+"_"+jLib.getRandomNumber();	
		
			
			String Lastname=eLib.readDataFromExcel("Contacts", 1, 2)+"_"+jLib.getRandomNumber();
			String campaignName = eLib.readDataFromExcel("Campaigns", 1, 2)+"_"+jLib.getRandomNumber();
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
			
			
			driver.findElement(By.linkText("Contacts")).click();
			
			
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			
			
			driver.findElement(By.name("lastname")).sendKeys(Lastname);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(header.contains(Lastname))
			{
				System.out.println(header);
				System.out.println("contact created");
			}
			else
			{
				System.out.println(header);
				System.out.println("Contact not created");
			}
			
			driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
			driver.findElement(By.linkText("Campaigns")).click();
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			
			driver.findElement(By.name("campaignname")).sendKeys(campaignName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			String header1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(header1.contains(campaignName))
			{
				System.out.println(header1);
				System.out.println("campaign created");
			}
			else
			{
				System.out.println(header1);
				System.out.println("Campaign not created");
			}
			
		driver.findElement(By.linkText("Opportunities")).click();	
	 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.name("potentialname")).sendKeys(name);
	WebElement ele = driver.findElement(By.id("related_to_type"));
	wLib.select("Contacts", ele);
	//driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	driver.findElement(By.xpath("//input[@name='related_to_display']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
	wLib.switchToWindow(driver, "Contacts");
	driver.findElement(By.id("search_txt")).sendKeys(Lastname);
	driver.findElement(By.name("search")).click();
	
	//driver.findElement(By.xpath("//a[.='"+Lastname+"']")).click();
	//driver.findElement(By.xpath("//a[text()='Lastname']")).click();
	driver.findElement(By.linkText(Lastname)).click();
	
	wLib.switchToWindow(driver, "Potentials");
	
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
		WebElement ele2 = driver.findElement(By.name("leadsource"));	
		wLib.select("Employee", ele2);
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
			
			wLib.switchToWindow(driver,"Campaigns");
			driver.findElement(By.id("search_txt")).sendKeys(campaignName);
			driver.findElement(By.name("search")).click();
			
			driver.findElement(By.linkText(campaignName)).click();
			wLib.switchToWindow(driver, "Potentials");
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			String header2 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(header2.contains(name))
			{
				System.out.println(header1);
				System.out.println("oppurtunity created");
			}
			else
			{
				System.out.println(header1);
				System.out.println("oppurtunity not created");
			}
			WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wLib.mousehover(driver, ele3);
			driver.findElement(By.linkText("Sign Out")).click();
			
			driver.quit();
			
			
	}

}
