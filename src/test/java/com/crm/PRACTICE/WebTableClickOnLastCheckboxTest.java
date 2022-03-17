package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;

public class WebTableClickOnLastCheckboxTest extends BaseClass {
	@Test
	public void checkallCheckBoxes() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.ClickOnContactLnk();
		
		//List<WebElement> ele=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		//int count = ele.size();
		WebDriverUtility Wlib=new WebDriverUtility();
		Wlib.scrollAction(driver);
		Thread.sleep(2000);
	WebElement ele = driver.findElement(By.xpath("(//input)[@type='checkbox'][21]"));
	ele.click();
	Thread.sleep(2000);
	
	
	List<WebElement> ele2=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]"));
	for(WebElement cbox:ele2)
	{
		String text = cbox.getText();
		System.out.println(text);
		Thread.sleep(2000);
	}
	
	
	
	}	
}
