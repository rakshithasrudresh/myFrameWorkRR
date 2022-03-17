package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsinfoPage {
	//step1:declaration
			@FindBy(xpath="//span[@class='lvtHeaderText']")
			private WebElement headerText;
			
			//step2:initialization
			public ProductsinfoPage(WebDriver driver)
			{
				PageFactory.initElements(driver,this);
			}
			
			//step3:utilization
			public WebElement getHeaderText() {
				return headerText;
			}
			
			
			
			//business library
			public String ProductNameInfo()
			{
				String ProductInfo=headerText.getText();
				return ProductInfo;
			}

			
}
