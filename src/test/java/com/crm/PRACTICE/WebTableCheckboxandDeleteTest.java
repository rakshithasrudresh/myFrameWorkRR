package com.crm.PRACTICE;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;

public class WebTableCheckboxandDeleteTest extends BaseClass{
	
	@Test
	public void CheckboxAndDeleteTest() throws Throwable
	{
		
		
		HomePage hp=new HomePage(driver);
		hp.ClickOnContactLnk();
	//driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@value='38']")).click();
		driver.findElement(By.xpath("(//input)[@type='checkbox'][6]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[10]/a[.='del']")).click();
		Thread.sleep(2000);
		System.out.println("deleted the contact");
		WebDriverUtility Wlib=new WebDriverUtility();
		Wlib.acceptAlert(driver);
		
		
		
		
		
		
	}
}
