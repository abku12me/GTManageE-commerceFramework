package practice;

import org.testng.annotations.Test;
import java.sql.*;

public class updatetheDb {
	
	
	@Test
	public void updaterecord() throws SQLException
	{
		Driver driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		String url="jdbc:mysql://rmgtestingserver:3333/projects";
		String username="root@%";
		String password="root";
	   Connection con=DriverManager.getConnection(url, username, password);
		Statement Stat = con.createStatement();
		String query1="update project set Project_Name='Transsoft' where status='In Progress' ";
		int result=Stat.executeUpdate(query1);
      String query2="select Project_Name from project where status='Completed' ";
		ResultSet result1=Stat.executeQuery(query2);
     	while(result1.next())
		{
			System.out.println(result1.getString(1));
			
		
		}
	
	
			
		
		
		
	}

}
