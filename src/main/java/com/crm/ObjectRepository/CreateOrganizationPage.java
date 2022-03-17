package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility
{
	//step1:Declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//step 2:initilization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step3:utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business library
	public void createNewOrg(String orgName)
	{
		OrgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createNewOrg(String orgName,String IndType)
	{
		OrgNameEdt.sendKeys(orgName);
		select(IndType, industryDropDown);
		saveBtn.click();
	}
	
	
	public void createNewOrg(String orgName,String IndType,String Type)
	{
		
		OrgNameEdt.sendKeys(orgName);
		select(IndType, industryDropDown);
		select(Type, typeDropDown);
		saveBtn.click();
	}

}
