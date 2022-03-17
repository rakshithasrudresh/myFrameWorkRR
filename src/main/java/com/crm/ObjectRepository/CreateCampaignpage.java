package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateCampaignpage extends WebDriverUtility{

	//step1:Declaration
	@FindBy(name="campaignname")
	private WebElement campaignnameEdt;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='product_name']/following-sibling::img[@alt='Select']")
	private WebElement prdNameLookupImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	

	
	
	//step 2:initilization
	public CreateCampaignpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step3:utilization
	public WebElement getCampaignnameEdt() {
		return campaignnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getPrdNameLookupImg() {
		return prdNameLookupImg;
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
	public void createNewCampaign(String campName)
	{
		
		campaignnameEdt.sendKeys(campName);
		saveBtn.click();
	}
	
	

	public void createNewCampaign(WebDriver driver, String campName,String Prd)
	{
		
		campaignnameEdt.sendKeys(campName);
		prdNameLookupImg.click();
		switchToWindow(driver, "Products");
		searchEdt.sendKeys(Prd);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+Prd+"']")).click();
		switchToWindow(driver, "Campaigns");
		saveBtn.click();
	}
	
	

	
}
