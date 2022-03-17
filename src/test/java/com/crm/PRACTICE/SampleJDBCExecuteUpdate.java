package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate
{

	@Test
	public void sampleJDBCExecuteUpdate() throws Throwable
	{
		Connection con=null;
		try{
		//step1:register the database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2:get connection from database
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		System.out.println("connection established");
		//step3:issue create statement
		Statement stat = con.createStatement();
		
		//step4:execute query
		//insert into student values(5,'anu','female');
		
		int result = stat.executeUpdate("insert into student values(7,'hani','male');");
		if(result==1)
		{
			System.out.println("data added successfully");
		}
		else
		{
			System.out.println("data not added");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		finally
		{
		//step5:close the database
		con.close();
		System.out.println("connection closed");
		}
	}
}
