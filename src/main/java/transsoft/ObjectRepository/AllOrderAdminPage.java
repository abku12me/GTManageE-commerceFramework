package transsoft.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllOrderAdminPage {
	
	
	/**
	 * This method will check order has been placed under admin order section
	 * @param driver
	 * @param users
	 * @return
	 */
	
	public String validateOrder(WebDriver driver,String users)
	{
		
		return driver.findElement(By.xpath("//td[.='"+users+"']")).getText();
	}
	

}
