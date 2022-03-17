package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//step1:Declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(linkText="More")
	private WebElement moreLnk;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrationImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	//step2:initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//step 3:generate getters

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getCampaignsLnk() {
		return campaignsLnk;
	}

	public WebElement getAdministrationImg() {
		return administrationImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	
	
	//business library
	public void ClickOnOrgLnk()
	{
		organizationLnk.click();
	}
	
	public void ClickOnContactLnk()
	{
		contactsLnk.click();
	}
	
	public void ClickOnPrdLnk()
	{
		productsLnk.click();
	}
	
	public void ClickonMorelnk()
	{
		moreLnk.click();
	}
	
	public void ClickonCampaignlnk()
	{
		campaignsLnk.click();
	}
	
	
	
	public void signOutOfApp(WebDriver driver)
	{
		mousehover(driver, administrationImg);
		signOutLnk.click();
	}

	
	
	

}
