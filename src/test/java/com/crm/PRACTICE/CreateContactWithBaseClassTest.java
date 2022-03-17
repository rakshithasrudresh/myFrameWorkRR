package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.HomePage;


@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)

public class CreateContactWithBaseClassTest extends BaseClass {
	            // @Test(groups="smokeSuite")
	@Test(retryAnalyzer=com.crm.GenericLibrary.RetryAnalyserImplementation.class)
				public void createContactTest() throws Throwable
				{

					String Lastname=eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
			
					/*Step 4: Navigate to Organizations Link*/
					HomePage hp=new HomePage(driver);
					hp.ClickOnContactLnk();
					Assert.fail();
						
					/*Step 5: click on create contacts button*/
					ContactsPage cp=new ContactsPage(driver);
					cp.clickOnCreateContactsImg();
					
					
					/*Step 6: enter mandatory fields and save*/
					CreateContactsPage ccp=new CreateContactsPage(driver);
					ccp.createNewContact(Lastname);
					ccp.getSaveBtn();
					
					
					/*Step 7: logout of application*/
					
					ContactsInfoPage cip=new ContactsInfoPage(driver);
					String actContactName=cip.ContactNameInfo();
					if(actContactName.contains(Lastname))
					{
						System.out.println(actContactName+"--->contact verified");
						
					}
					else
					{
						System.out.println("contact not created");
					}
					
					
			}
}
