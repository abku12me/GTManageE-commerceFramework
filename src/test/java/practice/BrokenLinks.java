package practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinks {
	
	
	
	@Test
	public void getAllBrokenLinks()
	{
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/index.php");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		ArrayList<Object> brokenlink=new ArrayList<Object>();
		for(int i=0;i<links.size();i++)
		{
			String alllinks = links.get(i).getAttribute("href");
			URL url;
			int statuscode=0;
			try {
				
				url=new URL(alllinks);
				URLConnection conn = url.openConnection();
				HttpURLConnection httpcon=(HttpURLConnection)conn;
				statuscode=httpcon.getResponseCode();
				if(statuscode>=400)
				{
					brokenlink.add(alllinks+" "+statuscode);
				}
			}
				
				catch(Exception e)
				{
					continue;
				}
				
			}
			System.out.println(brokenlink);
		}
		
		
		
		
		
		
	}


