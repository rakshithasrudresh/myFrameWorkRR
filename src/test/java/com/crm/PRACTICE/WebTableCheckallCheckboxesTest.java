package com.crm.PRACTICE;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class WebTableCheckallCheckboxesTest extends BaseClass
{
	@Test
public void checkallCheckBoxes() throws Throwable
{
	HomePage hp=new HomePage(driver);
	hp.ClickOnContactLnk();
	
List<WebElement> ele=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
	
	for(WebElement cbox:ele)
	{
		cbox.click();
		Thread.sleep(2000);
	}
	
	
	
	
	
	
	}
	
	
	
	

}

