package com.crm.genericImplemented;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganisationsPage;
import com.crm.ObjectRepository.OrganizationInfoPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrgBaseWITHASSERTIONClassTest extends BaseClass
{
	//@Test(groups="smokeSuite")
	@Test
	public void createContactWithOrgPOMTest() throws Throwable
	{
		
		
		String Lastname=eLib.readDataFromExcel("Org", 4, 2)+"_"+jLib.getRandomNumber();
		String OrgName=eLib.readDataFromExcel("Org", 4, 3)+"_"+jLib.getRandomNumber();
		
		
		/*Step 4: Navigate to Organizations Link*/
		HomePage hp=new HomePage(driver);
		hp.ClickOnOrgLnk();
		
		OrganisationsPage op=new OrganisationsPage(driver);
		op.clickOnCreateOrgImg();
		/*Step 6: enter mandatory fields and save*/
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName);
		
		//verification
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName=oip.OrgNameInfo();
	/*	if(actOrgName.contains(OrgName))
		{
			System.out.println(actOrgName+"--->data verified");
			
		}
		else
		{
			System.out.println("data invalid");
		}*/
		
		Assert.assertTrue(actOrgName.contains(OrgName));
		Reporter.log(actOrgName+"org created",true);
		
		hp.ClickOnContactLnk();
		/*Step 5: click on create contacts button*/
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactsImg();
		
		CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.createNewContact(driver, Lastname, OrgName);
		
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String actContactName=cip.ContactNameInfo();
		/*if(actContactName.contains(Lastname))
		{
			System.out.println(actContactName+"--->contact verified");
			
		}
		else
		{
			System.out.println("contact not created");
		}*/

		Assert.assertTrue(actContactName.contains(Lastname));//"abc"--assertion error--hard assert
		Reporter.log(actContactName+"contact is verified created",true);
		
		
	
		

	}

}
