package transsoft_GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic method related to java components
 * @author abhishek
 */

public class JavaUtilities {
	/**
	 * This method will get the system current date
	 * @return
	 */
	
	public String getSystemDate() 
	{
		Date date=new Date();
		String sysdate=date.toString();
		return sysdate;
		
	}
	
	/**
	 * This method will provide format system date as date month year time
	 * @return
	 */
	
	public String getSystemFormat()
	{
		Date date=new Date();
	 String data[]=date.toString().split(" ");
	   String date1=data[2];
	   String month=data[1];
	   String year=data[5];
	   String time=data[3];
	   String formatdate=date1+"-"+month+"-"+year+"-"+time;
	   return formatdate;
		
	}
	
	/**
	 * This method will provide any date in a year based on given formatting as "dd-MM-YYYY"
	 * @param datenum
	 * @return
	 */
	
	public String getCalendarDate(int datecount)
	{
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR,datecount);
		Date currentdate = cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
		String formatdate=sdf.format(currentdate);
		return formatdate;
	
	}
	
	/**
	 * This method will get the current system date in format as YYYY-MM-dd" 
	 * @return
	 */
	
	public String getSystemformateWithSimple()
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		String modifieddate=sdf.format(date);
		return modifieddate;
	}
	
	
	/**
	 * This method will return some random number 
	 * @return
	 */
	public int getRandom()
	{
		
		Random r=new Random();
		int rannum=r.nextInt(2000);
		return rannum;
	}
	
		
		
		
	
	
	
	
	
	

}
