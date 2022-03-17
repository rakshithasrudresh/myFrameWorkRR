package com.crm.OraganisationTests;

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
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganisationsPage;
import com.crm.ObjectRepository.OrganizationInfoPage;

public class CreateOrgWIthMultipleTestDataOfIndTypeAndTypeTest {
	
	//Create Obj for all utilities
	PropertyFileUtility pLib = new PropertyFileUtility();
	ExcelFileUtility eLib = new ExcelFileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	JavaUtility jLib = new JavaUtility();
	
	@Test(dataProvider = "OrgtestData")
	public void createOrgWithMltipleData(String orgName, String indType,String type) throws Throwable
	{
		
		
		//read data 
		String BROWSER = pLib.readdataFromPropertyFile("browser");
		String URL = pLib.readdataFromPropertyFile("url");
		String USERNAME = pLib.readdataFromPropertyFile("username");
		String PASSWORD = pLib.readdataFromPropertyFile("password");
		
		String orgname = orgName+jLib.getRandomNumber();
	
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
		hp.ClickOnOrgLnk();
		Reporter.log("navigated to org link",true);
		
		//create Org
		OrganisationsPage op = new OrganisationsPage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("click on create org link",true);
		
		//create new org
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(orgName, indType, type);
		Reporter.log("create org with insustry type and Type",true);
		
		//validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actHeader = oip.OrgNameInfo();
		if (actHeader.contains(orgname)) {
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
	
	@DataProvider(name = "OrgtestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readmultipleDataFromExcel("OrgMultipleData");
		return  data;
	}

}



