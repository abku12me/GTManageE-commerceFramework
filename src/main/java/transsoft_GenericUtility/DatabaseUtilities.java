package transsoft_GenericUtility;
import java.io.IOException;
import java.sql.*;

/**
 * This class consists of generic method related to database
 * @author abhishek
 *
 */

public class DatabaseUtilities {
	PropertyFileUtilities putil=new PropertyFileUtilities();
	
	Connection con=null;
	/**
	 * This method helps to connect with database
	 * @throws SQLException
	 * @throws IOException
	 */
	
	public void getConnection() throws SQLException, IOException
	{
		String URl=putil.getPropertyPathandKey(IConstantUtilities.databasepath, "url");
		String USERNAME=putil.getPropertyPathandKey(IConstantUtilities.databasepath, "username");
		String PASSWORD=putil.getPropertyPathandKey(IConstantUtilities.databasepath, "password");
		Driver driverref=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driverref);
		con = DriverManager.getConnection(URl, USERNAME, PASSWORD);	
	}
	
	/**
	 * This method is used to insert/update/delete the data from DB
	 * @param query
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public int executeUpadte(String query) throws SQLException, IOException
	{
		getConnection();
		Statement stat = con.createStatement();
		int result=stat.executeUpdate(query);
		if(result==1)
		    System.out.println("Data is created");
		
		else
			System.out.println("Data is not created");
		return result;
	}
	
	/**
	 * This method will execute the query based on column index and verified the expected data
	 * @param query
	 * @param columnndex
	 * @param expecteddata
	 * @throws SQLException
	 * @throws IOException
	 */
	
	public void validateexecuteQuery(String query,int columnndex,String expecteddata) throws SQLException, IOException
	{
		getConnection();
		Statement stat = con.createStatement();
		ResultSet result=stat.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			if(result.getString(columnndex).equals(expecteddata))
			{
				flag=true;
				break;
			}
			
		}
		
		if(flag)
			System.out.println(expecteddata+"data is verified in DB");
		else
			System.out.println(expecteddata+"data is not verified in DB");
		
		
	}
	
	/**
	 * This method will execute query based on column index
	 * @param query
	 * @param columindex
	 * @throws SQLException
	 * @throws IOException
	 */
	
	
	
	public void executeQuery(String query,String columindex) throws SQLException, IOException
	{
		getConnection();
		Statement stat=con.createStatement();
		ResultSet result=stat.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(columindex));
		}
		
	}
	
	
	
	/**
	 * This method will close the database
	 * @throws SQLException
	 */
	
	public void closeDB() throws SQLException
	{
		con.close();
	}
	
	
	
	
	
	
	
	
	

}
