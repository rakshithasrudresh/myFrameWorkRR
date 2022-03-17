package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice2 {

	@Test(dataProvider="fetchData")
	public void sampleDataProvider(String Name,String USN)
	{
		System.out.println(Name+"----"+USN);
	}
	@DataProvider
		public Object[][] fetchData()
		{
		Object[][] obj=new Object[6][2];
		
		obj[0][0]="Rakshitha";
		obj[0][1]="IRR07CS030";
		
		
		obj[1][0]="Vijaylaxmi";
		obj[1][1]="IRR07CS031";
		
		

		obj[2][0]="Afsheen";
		obj[2][1]="1RR07CS032";
	
		

		obj[3][0]="Anjali";
		obj[3][1]="1RR07CS033";
		
		obj[4][0]="Ashwini";
		obj[4][1]="1RR07CS034";
		
		obj[5][0]="Arpita";
		obj[5][1]="1RR07CS035";
	
		
	
		return obj;
		}

}
