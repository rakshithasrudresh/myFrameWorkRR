package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactsPage extends WebDriverUtility {
	//step1:Declaration
		@FindBy(name="lastname")
		private WebElement lastNameEdt;
		
		@FindBy(name="leadsource")
		private WebElement leadSourceDropDown;
		
		@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
		private WebElement orgNameLookupImg;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		

		@FindBy(name="search_text")
		private WebElement searchEdt;
		
		@FindBy(name="search")
		private WebElement searchBtn;
		
		
		//step 2:initilization
		public CreateContactsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//step3:utilization
		

		public WebElement getLastNameEdt() {
			return lastNameEdt;
		}

		public WebElement getLeadSourceDropDown() {
			return leadSourceDropDown;
		}

		public WebElement getOrgNameLookupImg() {
			return orgNameLookupImg;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}

		public WebElement getSearchEdt() {
			return searchEdt;
		}
		
		
		public WebElement getSearchBtn() {
			return searchBtn;
		}

		//business library
		/**
		 * 
		 * @param lastName
		 */
		
		
		public void createNewContact(String lastName)
		{
			lastNameEdt.sendKeys(lastName);
			saveBtn.click();
		
		}
		
		
		public void createNewContact(String lastName,String leadSource)
		{
			lastNameEdt.sendKeys(lastName);
			select(leadSource, leadSourceDropDown);
			saveBtn.click();
		
		}
		
		public void createNewContact(WebDriver driver,String lastName,String orgName)
		{
			lastNameEdt.sendKeys(lastName);
			orgNameLookupImg.click();
			switchToWindow(driver, "Accounts");
			searchEdt.sendKeys(orgName);
			searchBtn.click();
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			switchToWindow(driver, "Contacts");
			saveBtn.click();
		}	

}
