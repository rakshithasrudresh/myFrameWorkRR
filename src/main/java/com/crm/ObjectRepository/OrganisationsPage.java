package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganisationsPage  extends WebDriverUtility
{
//step1:declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	//step2:initializtion
	public OrganisationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//step3:utilization
	public WebElement getCreateorgLookUpImg()
	{
		return createOrgLookUpImg;
	}
	
	//Business Library
	public void clickOnCreateOrgImg()
	{
		createOrgLookUpImg.click();
	}
}
