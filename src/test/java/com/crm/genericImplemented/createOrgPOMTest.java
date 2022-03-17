package com.crm.genericImplemented;

import java.util.concurrent.TimeUnit;

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
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganisationsPage;
import com.crm.ObjectRepository.OrganizationInfoPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createOrgPOMTest {
	 @Test
		public void createOrgTest() throws Throwable
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
			
			String OrgName=eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
			
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
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			
			/*Step 4: Navigate to Organizations Link*/
		HomePage hp=new HomePage(driver);
		hp.ClickOnOrgLnk();
			
			/*Step 5: click on create org organization button*/
			OrganisationsPage op=new OrganisationsPage(driver);
			op.clickOnCreateOrgImg();
			/*Step 6: enter mandatory fields and save*/
			CreateOrganizationPage cop=new CreateOrganizationPage(driver);
			cop.createNewOrg(OrgName);
			
			//verification
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String actOrgName=oip.OrgNameInfo();
			if(actOrgName.contains(OrgName))
			{
				System.out.println(actOrgName+"--->org created");
				
			}
			else
			{
				System.out.println("not created invalid");
			}
			
			/*Step 7: logout of application*/
			hp.signOutOfApp(driver);
			/*Step 8: close the browser*/
			driver.quit();
	}
}
