package com.crm.genericImplemented;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganisationsPage;
import com.crm.ObjectRepository.OrganizationInfoPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateOrgBaseClassTest extends BaseClass
{
	 //@Test(groups="regressionSuite")
	@Test
			public void createOrgTest() throws Throwable
			{
			 
				String OrgName=eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
				
				/*Step 4: Navigate to Organizations Link*/
			HomePage hp=new HomePage(driver);
			hp.ClickOnOrgLnk();
			
			Assert.fail();
				
				/*Step 5: click on create org organization button*/
				OrganisationsPage op=new OrganisationsPage(driver);
				op.clickOnCreateOrgImg();
				/*Step 6: enter mandatory fields and save*/
				CreateOrganizationPage cop=new CreateOrganizationPage(driver);
				cop.createNewOrg(OrgName);
				
				//verification
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
	 
	 @Test
	 public void createSampleTestCase()
	 {
		 System.out.println("sample test");
		 Assert.fail();
	 }
	}



