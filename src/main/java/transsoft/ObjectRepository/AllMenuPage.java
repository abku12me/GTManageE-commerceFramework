package transsoft.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllMenuPage {
	
	
	
	public String validatAllMenu(String menu,WebDriver driver)
	{
		return driver.findElement(By.xpath("//td[text()='"+menu+"']")).getText();
		
	}
	
	
	

}
