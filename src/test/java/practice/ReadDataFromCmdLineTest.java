package practice;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.mysql.cj.xdevapi.JsonParser;

import transsoft_GenericUtility.ExcelsheetUtilities;
import transsoft_GenericUtility.IConstantUtilities;
import transsoft_GenericUtility.PropertyFileUtilities;

public class ReadDataFromCmdLineTest {
	ExcelsheetUtilities eutil=new ExcelsheetUtilities();
	PropertyFileUtilities putil=new PropertyFileUtilities();
	
	@Test
	public void readDataFromCmdLine()
	{
		String value=System.getProperty("url");
		System.out.println(value);
		String BROWSER=System.getProperty("browser");
		System.out.println(BROWSER);
		String USERNAME=System.getProperty("username");
		System.out.println(USERNAME);	
	}
	
	@Test
	public void readDataFromJason() throws IOException, ParseException
	{
		/*parse the json file*/
		JSONParser parser=new JSONParser();
		
		//FileInputStream fil=new FileInputStream(".\\src\\test\\resources\\CommonData.json");
		 FileReader fil=new FileReader(".\\src\\test\\resources\\CommonData.json");
		
		Object obj=parser.parse(fil);
		
		/*downcast the obj into json object,automatically all the data loaded into key and value pair*/
		JSONObject map=(JSONObject)obj;
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
	
		
		
	}
	
	@Test
	public void practice() throws Throwable
	{
		String value=eutil.readdataFromExcelBasedOnTestID(IConstantUtilities.excelpath, "Restaurants", "TC_41", "Restaurant Name");
		System.out.println(value);
		String E_path = putil.getPathfile("Excelpath");
		System.out.println(E_path);
		
	}
	

}
