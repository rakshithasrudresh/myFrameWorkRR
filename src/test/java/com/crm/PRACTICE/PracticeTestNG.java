package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeTestNG {
	@Test()
	public void createOrg()
	{
		System.out.println("org created");
		//Assert.fail();
		Reporter.log("Org created--report");
	}
	
	
	@Test()
	public void modifyOrg()
	{
		System.out.println("org modified");
		Reporter.log("Org modigied--report+console",true);
	}
	
	@Test()
	public void deleteOrg()
	{
		System.out.println("org deleted");
	}
	
	

}
