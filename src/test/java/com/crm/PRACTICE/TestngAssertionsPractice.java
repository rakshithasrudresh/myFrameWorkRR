package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestngAssertionsPractice
{
	@Test
	public void assertionPractice()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("this is test 1");
		sa.assertEquals(1,0);
		System.out.println("passed");
		sa.assertAll();
		Assert.assertEquals(1,0);
		
	}

}
