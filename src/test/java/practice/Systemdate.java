package practice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class Systemdate {
	
	
	@Test
	public void syspractice()
	{
		Date date=new Date();
		String currentdate=date.toString();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		String modifieddate=sdf.format(currentdate);
		System.out.println(modifieddate);
	}

}
