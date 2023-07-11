package practice;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class verifiedProjectCreated {
	
	@Test
	public void projectvalidation() throws SQLException
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
		ResultSet result = sta.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String value=result.getString(4);
			if(value.contains("project_name"))
				System.out.println("project created");
			flag=true;
			break;
			
		}
		if(!flag)
			System.out.println("project not created");
		}
		finally {
			conn.close();
		}
		
	}

}
