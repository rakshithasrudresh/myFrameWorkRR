package com.crm.PRACTICE;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganisationsPage;
import com.crm.ObjectRepository.OrganizationInfoPage;

public class CreateOrgForAssertionsTest 
{
	
	public class CreateOrgBaseClassTest extends BaseClass
	{
		 //@Test(groups="regressionSuite")
		@Test
				public void createOrgTest() throws Throwable
				{
				 SoftAssert sa=new SoftAssert();
				 
					String OrgName=eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
					
					/*Step 4: Navigate to Organizations Link*/
				HomePage hp=new HomePage(driver);
				hp.ClickOnOrgLnk();
				String ExpData="Organizations";
				String actData=driver.findElement(By.linkText("Organizations")).getText();
				Assert.assertEquals(actData, ExpData);
					
					/*Step 5: click on create org organization button*/
					OrganisationsPage op=new OrganisationsPage(driver);
					op.clickOnCreateOrgImg();
					String expHeader="Creating New Organization";
					String actHeader=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
					sa.assertEquals(actHeader, expHeader);
					
					
					/*Step 6: enter mandatory fields and save*/
					CreateOrganizationPage cop=new CreateOrganizationPage(driver);
					cop.createNewOrg(OrgName);
					
					//verification
					OrganizationInfoPage oip=new OrganizationInfoPage(driver);
					String actOrgName=oip.OrgNameInfo();
					Reporter.log(actOrgName+"org created",true);
					Assert.assertTrue(actOrgName.contains(OrgName));//OrgName
					System.out.println("pass");
				//	sa.assertAll("all ok");
					System.out.println("assert all ok");
					
					sa.assertTrue(actOrgName.contains("abc"));
					System.out.println("pass");
					sa.assertAll("all ok");
					
					
					
					
					
			}
		
		}





}
