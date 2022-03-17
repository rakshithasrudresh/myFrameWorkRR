package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMPracticeForLogin {
	
	@Test
	public void pomPractice()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("admin", "admin");
		
		HomePage hp=new HomePage(driver);
		hp.ClickOnOrgLnk();
		hp.signOutOfApp(driver);
		
		
		
	}

}
