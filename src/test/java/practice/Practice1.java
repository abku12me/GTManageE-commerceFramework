package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AdvancedSelenium.genericLib.ListenerImplementation;
import transsoft_GenericUtility.BaseClass;
import transsoft_GenericUtility.ExcelsheetUtilities;
import transsoft_GenericUtility.IConstantUtilities;
import transsoft_GenericUtility.JavaUtilities;
//@Listeners(transsoft_GenericUtility.ListenerImplementation.class)
public class Practice1{
	
	
	ExcelsheetUtilities eutil=new ExcelsheetUtilities();
	@Test(dataProvider="file")
	public void base() throws EncryptedDocumentException, IOException
	{
		Assert.fail();
	
	eutil.fetchaAllTestData(IConstantUtilities.excelpath, "Restaurants");
		
	}
	
	@DataProvider(name="file")
	public Object[][] writeData() throws EncryptedDocumentException, IOException
	{
		//eutil.writeDataInExcelsheet(IConstantUtilities.excelpath, "Data1",1, 2,"abhishek");
		
		Object[][] data = eutil.readmultipleDataFromexcel(IConstantUtilities.excelpath, "Sheet1");
		return data;
	}

	@Test(retryAnalyzer=transsoft_GenericUtility.retryAnalyzersImplementation.class)
	public void retryMethod()
	{
		
		System.out.println("hello");
		Assert.fail();
		
	}
	@Test
	public void getTime()
	{
		JavaUtilities jutil=new JavaUtilities();
		String date=jutil.getSystemFormat();
		System.out.println(date);
		
		System.out.println(jutil.getSystemformateWithSimple());
		System.out.println(jutil.getSystemDate());
		
	}
	
	@Test(dataProvider="data")
	public void logincred(String user,String pass)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/index.php");
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pass);
	}
	
	
	@DataProvider(name="data")
	public Object[][] getData()
	{
		Object[][] ref=new Object[2][2];
		ref[0][0]="admin1";
		ref[0][1]="manager";
		ref[1][0]="admin2";
		ref[1][1]="manager";
		return ref;
	}
	
	
	
	
	
	
	
		
	
	
	
	
	
	
	

}
