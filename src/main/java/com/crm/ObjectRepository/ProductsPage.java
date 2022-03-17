package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ProductsPage extends WebDriverUtility 
{
	
	//step1:declaration
			@FindBy(xpath="//img[@alt='Create Product...']")
			private WebElement createProductLookUpImg;
			
			//step2:initializtion
			public ProductsPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
				
			}
			
			//step3:utilization

			public WebElement getCreateProductLookUpImg() {
				return createProductLookUpImg;
			}
			
			//Business Library
			public void clickOnCreateProductsImg()
			{
				createProductLookUpImg.click();
				
			}


}
