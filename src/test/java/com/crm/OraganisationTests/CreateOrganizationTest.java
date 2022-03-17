package com.crm.OraganisationTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateOrganizationTest {

	@Test
	public void createOrganizationTest()
	{
		//step1:Launch the browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		//step2:login to application
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//step3:navigate to application
		
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 4:click on create Organization link
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step5:create org with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("ALL STATES");
		
		//step 6:save
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.quit();
		
		
	}	
}

