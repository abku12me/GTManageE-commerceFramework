package practice;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import transsoft_GenericUtility.DatabaseUtilities;

public class selectQueryfromDB {
	
	
	@Test
	public void fetchDataFromDB() throws SQLException
	{
		Connection conn=null;
		
		try {
		Driver driver=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		String url="jdbc:mysql://rmgtestingserver:3333/projects";
		String username="root@%";
		String password="root";
		conn = DriverManager.getConnection(url,username,password);
		Statement sta = conn.createStatement();
		String query="select * from project";
		ResultSet result=sta.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+""+result.getString(5)+""+result.getString(6));
		}
		}
		finally {
			conn.close();
		}
	}

}
