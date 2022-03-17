package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateProductsPage extends WebDriverUtility{
	//step1:Declaration
			@FindBy(name="productname")
			private WebElement productNameEdt;
			
			
			
			
			
			@FindBy(xpath="//input[@title='Save [Alt+S]']")
			private WebElement saveBtn;
			

			
			
			//step 2:initilization
			public CreateProductsPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

			//step3:utilization
			
			public WebElement getProductNameEdt() {
				return productNameEdt;
			}

			public WebElement getSaveBtn() {
				return saveBtn;
			}
			
			

			//business library
			/**
			 * 
			 * @param lastName
			 */
			public void createNewProduct(String prdName)
			{
				
				productNameEdt.sendKeys(prdName);
				saveBtn.click();
			}
}
