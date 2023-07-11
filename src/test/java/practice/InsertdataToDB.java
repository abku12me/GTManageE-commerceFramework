package practice;

import java.io.IOException;
import java.sql.*;
import org.testng.annotations.Test;

import transsoft_GenericUtility.DatabaseUtilities;

public class InsertdataToDB {
	
	@Test
	public void insertdataToDB() throws SQLException, IOException
	{
		DatabaseUtilities dutil=new DatabaseUtilities();
	try {
		
		String query="insert into project values('TY_PROJ_564','Flipkart','29/06/2023','abhishek','on going','4') ";
		dutil.executeUpadte(query);
		}
	
		finally {
		dutil.closeDB();
		}
		
		
		
		
	}

}
