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
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.CampaignsInfoPage;
import com.crm.ObjectRepository.CreateCampaignpage;
import com.crm.ObjectRepository.CreateProductsPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductsPage;
import com.crm.ObjectRepository.ProductsinfoPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaihnWithProductPOMTest {
	@Test
	public void createCampaignWithProduct() throws Throwable
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
		
		String campaignName = eLib.readDataFromExcel("Campaigns", 1, 2)+"_"+jLib.getRandomNumber();
		String prodName = eLib.readDataFromExcel("Campaigns", 1, 3);
		String catType = eLib.readDataFromExcel("Campaigns", 1, 4);
	
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
			System.out.println("invalid browser name");
		}
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		/*Step 4: Navigate to Organizations Link*/
		HomePage hp=new HomePage(driver);
		hp.ClickOnPrdLnk();
		
		ProductsPage pp=new ProductsPage(driver);
		pp.clickOnCreateProductsImg();
		
		CreateProductsPage cpp=new CreateProductsPage(driver);
		cpp.createNewProduct(prodName);
		
		ProductsinfoPage pip=new ProductsinfoPage(driver);
		String actPrdName = pip.ProductNameInfo();
		
		
		if(actPrdName.contains(prodName))
		{
			System.out.println(actPrdName+"--->product verified");
			
		}
		else
		{
			System.out.println("product  not created");
		}
		
		hp.ClickonMorelnk();
		hp.ClickonCampaignlnk();
		
		CampaignPage cp=new CampaignPage(driver);
		cp.clickOnCreateCampImg();
		
		CreateCampaignpage ccp=new CreateCampaignpage(driver);
		ccp.createNewCampaign(driver, campaignName, prodName);
		
		CampaignsInfoPage cip=new CampaignsInfoPage(driver);
		String actCampName = cip.CampNameInfo();
		
		if(actCampName.contains(campaignName))
		{
			System.out.println(actCampName+"----campaign created");
		}
		else
		{
			System.out.println("campaign not created");
		}
		
		
		
		
		
		hp.signOutOfApp(driver);
		
		driver.quit();
		
	}


}
