package com.crm.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganisationsPage;
import com.crm.ObjectRepository.OrganizationInfoPage;

public class CreateContactWithMandatoryFeildsWIthMultipleTestDataTest 
{
	
	//Create Obj for all utilities
	PropertyFileUtility pLib = new PropertyFileUtility();
	ExcelFileUtility eLib = new ExcelFileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	JavaUtility jLib = new JavaUtility();
	
	@Test(dataProvider = "ContacttestData")
	public void createContactWithMltipleData(String LastName) throws Throwable
	{
		
		
		//read data 
		String BROWSER = pLib.readdataFromPropertyFile("browser");
		String URL = pLib.readdataFromPropertyFile("url");
		String USERNAME = pLib.readdataFromPropertyFile("username");
		String PASSWORD = pLib.readdataFromPropertyFile("password");
		
		String Lastname = LastName+jLib.getRandomNumber();
	
		//launch the application
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
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
		
		//login to application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("login successful",true);
		
		//navigate to organization
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLnk();
		Reporter.log("navigated to contact link",true);
		
		//create Org
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactsImg();
		
		Reporter.log("click on create contact link",true);
		
		//create new org
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.createNewContact(LastName);
		Reporter.log("create contact with lastname",true);
		
		//validate
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actHeader = cip.ContactNameInfo();
		if (actHeader.contains(LastName)) {
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
		Reporter.log("verification successful",true);		
		
		//logout
		hp.signOutOfApp(driver);
		
		driver.quit();
	}
	
	@DataProvider(name = "ContacttestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readmultipleDataFromExcel("contactMulData");
		return  data;
	}

}



