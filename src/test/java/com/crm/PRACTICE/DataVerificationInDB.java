package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataVerificationInDB {
	@Test
	public void dataVerificationindb() throws Throwable
	{
		String expData="Rakshitha";
		
		//step1:register the database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2:get connector from database-provide db name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		
		//step 3:issue create statement
		Statement state = con.createStatement();
		
		//step 4:execute query
		ResultSet result = state.executeQuery("select * from student;");
		while(result.next())
		{
			String actData=result.getString(2);
			if (expData.equalsIgnoreCase(actData))
			{
				System.out.println(actData+"   data is verified");
				//break;
				
			}
			else
			{
				System.out.println("data not verified");
			}
			
		}
		//step5:close the database
		con.close();	
	}
}
