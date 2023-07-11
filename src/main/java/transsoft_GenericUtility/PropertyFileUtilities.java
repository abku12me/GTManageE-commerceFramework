package transsoft_GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic method to fetch the data from properties file
 * @author abhishek
 */

public class PropertyFileUtilities {
	/**
	 * This method is used to fetch the data from properties file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtilities.propertypath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;	
	}
	
	
	/**
	 * used to provide path and key to fetch the data from property file 
	 * @param filepath
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyPathandKey(String filepath,String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(filepath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
		
		
	}
	
	
	/**
	 * This method will provide the file path for location \src\test\resources\FilePath.properties
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPathfile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\FilePath.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;	
	}
	
	

}
