package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactsPage extends WebDriverUtility
{
	//step1:declaration
		@FindBy(xpath="//img[@alt='Create Contact...']")
		private WebElement createContactLookUpImg;
		
		//step2:initializtion
		public ContactsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}
		
		//step3:utilization
		public WebElement getCreateContactLookUpImg()
		{
			return createContactLookUpImg;
		}
		
		//Business Library
		public void clickOnCreateContactsImg()
		{
			createContactLookUpImg.click();
		}

		

}
