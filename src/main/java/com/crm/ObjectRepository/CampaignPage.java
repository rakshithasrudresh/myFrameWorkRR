package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	//step1:declaration
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createCampLookUpImg;
	
	//step2:initializtion
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//step3:utilization

	public WebElement getCreateCampLookUpImg() {
		return createCampLookUpImg;
	}

	
	
	//Business Library
	public void clickOnCreateCampImg()
	{
		createCampLookUpImg.click();
		
	}


}
