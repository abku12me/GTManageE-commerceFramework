package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import transsoft_GenericUtility.ExcelsheetUtilities;

public class FetchAllData {
	
	
	ExcelsheetUtilities eutil=new ExcelsheetUtilities();
	
	@DataProvider
	public Object[][] fetchAll() throws EncryptedDocumentException, IOException
	{
		Object[][] data=eutil.readmultipleDataFromexcel(".\\Dataprovider\\dataprovider.xlsx", "dataprovider");
		return data;
		
	}
	@Test(dataProvider="fetchAll")
	public void alldata()
	{
		System.out.println("hello");
		
	}
	
	
	
	
	
	
	

}
