package transsoft_GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic method to fetch the data from excel sheet
 * @author Abhishek
 */
public class ExcelsheetUtilities {
	
	/**
	 * This method fetch the data from excel sheet based on index
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcelsheet(String filepath,String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet(sheetname);
		DataFormatter df=new DataFormatter();
		String value=df.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		wb.close();
		return value;
		
	}
	
	/**
	 * This method will fetch data from excel sheet based on test id and column name
	 * @param sheetname
	 * @param testtid
	 * @param colHeader
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readdataFromExcelBasedOnTestID(String filepath,String sheetname,String testtid,String columnHeader) throws EncryptedDocumentException, IOException {
	
		FileInputStream fis1=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum();
		int testrownum=0;
		
		for(int i=0;i<=rowcount;i++)
		{
		 String acttestid = sh.getRow(i).getCell(0).toString();
			if(acttestid.equalsIgnoreCase(testtid)) {
				break;
			}
			testrownum++;
			
		}
		
		int testColnum=0;
		int cellcount=sh.getRow(testrownum-1).getLastCellNum();
		for(int j=0;j<cellcount;j++)
		{
			   String actColHeader=sh.getRow(testrownum-1).getCell(j).toString();
			if(actColHeader.equalsIgnoreCase(columnHeader)) {
				break;
			}
			
			testColnum++;	
		}
		
		String value=sh.getRow(testrownum).getCell(testColnum).toString();
		wb.close();
		return value;
	
}	
	
	/**
	 * This method will used to write the data in a excel sheet
	 * @param filepath
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataInExcelsheet(String filepath,String sheetname,int rownum,int cellnum,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis1);
		wb.createSheet(sheetname).createRow(rownum).createCell(cellnum).setCellValue(value);
		FileOutputStream fos=new FileOutputStream(filepath);
		wb.write(fos);
		wb.close();
		
		
	}
	
	/**
	 * read the date based on testId and Required Column name 
	 * @param filePath
	 * @param sheetName
	 * @param testId
	 * @param columnHeader
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	
	
	public String getDataFromExcelBasedTestId(String filePath, String sheetName , String testId, String columnHeader ) throws Throwable, IOException {
		FileInputStream fis1 = new FileInputStream(filePath);
		Workbook wb =  WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int testRowNum = 0;
		String actTestID="";
		String actColHeaderName="";
		String data="";
		
		for(int i=0; i<=rowCount; i++) {
			try { actTestID = sheet.getRow(i).getCell(0).toString();} catch (Exception e) {}

			if(actTestID.equalsIgnoreCase(testId)) {
				break;				
			}
			testRowNum++;
		}
		int testColNum =0;
		int celCountforTest = sheet.getRow(testRowNum-1).getLastCellNum();
		for(int j=0; j<celCountforTest; j++) {
			try {actColHeaderName =  sheet.getRow(testRowNum-1).getCell(j).toString(); } catch (Exception e) {}
			if(actColHeaderName.equalsIgnoreCase(columnHeader)) {
				break;
			}
			testColNum++;
		}
		try {data =  sheet.getRow(testRowNum).getCell(testColNum).toString();}catch (Exception e) {}
		return data;

	
	}
	
	/**
	 * This method will fetch all the data from the excel sheet
	 * @param excelpath
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public Object[][] readmultipleDataFromexcel(String excelpath,String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int lastrow = sh.getLastRowNum();
		int lastcell = sh.getRow(0).getLastCellNum();
		
		Object[][]data=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				
			}
			
		}
		
		return data;
			
	}	
	
	/**
	 * This method will fetch all the data from the excel sheet except header
	 * @param excelpath
	 * @param sheetname
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void fetchaAllTestData(String excelpath,String sheetname ) throws EncryptedDocumentException, IOException	
	{
		FileInputStream fis=new FileInputStream(excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		DataFormatter df=new DataFormatter();
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			int row=sh.getRow(i).getLastCellNum();
			for(int j=0;j<row;j++)
			{
				String data=df.formatCellValue(sh.getRow(i).getCell(j));
				System.out.println(data);
			}
			
		}
		System.out.println();
		
	}
		
	public void writeDataBasedOnTestIdCol(String excelpath,String sheetname,String testid,String columnHeader,String setdata) throws EncryptedDocumentException, IOException	
	{
		FileInputStream fis=new FileInputStream(excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum();
		int testrowcount=0;
		for(int i=0;i<=rowcount;i++)
		{
			String test=sh.getRow(i).getCell(0).toString();
			if(test.equalsIgnoreCase(testid))
			break;
		
			testrowcount++;
			int colcount=0;
                 

			
			
		}
		
		
		
		
		
		
		
	}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	


