package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import transsoft_GenericUtility.ExcelsheetUtilities;
import transsoft_GenericUtility.IConstantUtilities;
import transsoft_GenericUtility.JavaUtilities;
import transsoft_GenericUtility.PropertyFileUtilities;
import transsoft_GenericUtility.WebDriverUtilities;

public class ExcelPractice {
	
	PropertyFileUtilities putil=new PropertyFileUtilities();
	ExcelsheetUtilities eutil=new ExcelsheetUtilities();
	JavaUtilities jutil=new JavaUtilities();
	WebDriverUtilities wutil=new WebDriverUtilities();
	
	
	
	
	
	
	@Test
	public void excel() throws Throwable
	{
		String P_path=putil.getPathfile("propertypath");
		String R_Path=putil.getPathfile("Restaurantimage");
	    String M_Path=putil.getPathfile("menuimage");
		
		String E_path=putil.getPathfile("Excelpath");
		
	String RestaurantAddress=putil.getPropertyPathandKey(P_path, "password1");
				
			System.out.println(RestaurantAddress);
			System.out.println("hi");
				
		
		
	}
	
	
	
	
	
}
