package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//create object of all utilities
	public DatabaseUtility dbLib=new DatabaseUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
  public ExcelFileUtility eLib = new ExcelFileUtility();
  public	WebDriverUtility wLib = new WebDriverUtility();
  public	JavaUtility jLib = new JavaUtility();
  public WebDriver driver;
public static WebDriver sDriver=null;
  
  @BeforeSuite(groups={"regressionSuite","smokeSuite"})
  public void connectDataBase() throws Throwable  
  {
	//dbLib.connectToDb();
	  Reporter.log("=====db connection successfull===",true);  
  }
  
  
 @BeforeClass(groups={"regressionSuite","smokeSuite"})
 // @Parameters("browser")
 // @BeforeTest
  public void launchTheBrowser() throws Throwable
  {
	  //read data from property
	 String BROWSER=pLib.readdataFromPropertyFile("browser");
	  String URL=pLib.readdataFromPropertyFile("url");
	  //create runtime polymorphism
	  if(BROWSER.equalsIgnoreCase("chrome"))
		{
		  WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
	  
	  sDriver=driver;
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		 Reporter.log("=====browser launch successfull===",true);
	    
  }
  
  @BeforeMethod(groups={"regressionSuite","smokeSuite"})
  public void login() throws Throwable
  {
	  String USERNAME = pLib.readdataFromPropertyFile("username");
		String PASSWORD = pLib.readdataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("======login successful=====",true);
	  
  }
  
  
  @AfterMethod(groups={"regressionSuite","smokeSuite"})
  public void logout()
  {
	  HomePage hp = new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("========logout successfull====",true);
	  
  }
  
  
  @AfterClass(groups={"regressionSuite","smokeSuite"})
  public void closeBrowser()
  {
	  driver.quit();
	  Reporter.log("====browser close successfull====",true);
  }
  
  @AfterSuite(groups={"regresssionsuite","smokeSuite"})
  public void closeDb()
  {
	  
	  //dbLib.closeDB();
	  Reporter.log("-====Database close successfull===",true);
	  
  }
  
  
  
  
  
  
  
  
  
  
	

}
