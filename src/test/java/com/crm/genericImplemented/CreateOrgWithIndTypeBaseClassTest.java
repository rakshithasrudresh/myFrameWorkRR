package com.crm.genericImplemented;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganisationsPage;
import com.crm.ObjectRepository.OrganizationInfoPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateOrgWithIndTypeBaseClassTest extends BaseClass
{

		//@Test(groups="regressionSuite")
	@Test
			public void createOrgWithIndustryType() throws Throwable
			{
			
				
				String OrgName=eLib.readDataFromExcel("Org", 4, 2)+"_"+jLib.getRandomNumber();
				String IndType=eLib.readDataFromExcel("Org", 4, 3);
				
				HomePage hp=new HomePage(driver);
				hp.ClickOnOrgLnk();
				
				OrganisationsPage op=new OrganisationsPage(driver);
				op.clickOnCreateOrgImg();
				
				
				CreateOrganizationPage cop=new CreateOrganizationPage(driver);
				cop.createNewOrg(OrgName, IndType);
				
				OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				String actOrgName=oip.OrgNameInfo();
				if(actOrgName.contains(OrgName))
				{
					System.out.println(actOrgName+"--->org created");
					
				}
				else
				{
					System.out.println("not created invalid");
				}
			
				
				
			}
}

