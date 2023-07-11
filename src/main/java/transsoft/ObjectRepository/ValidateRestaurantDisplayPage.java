package transsoft.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import transsoft_GenericUtility.WebDriverUtilities;

public class ValidateRestaurantDisplayPage extends WebDriverUtilities{
	
	@FindBy(linkText="View Menu")
	private WebElement ViewMenulink;
	
	
	public ValidateRestaurantDisplayPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}

	public WebElement getViewMenulink() {
		return ViewMenulink;
	}

	
	//Business Libraries

	/**
	 * This method will perform click action on view menu link
	 */
   public void viewMenuLink(WebDriver driver)
   {
	   ViewMenulink.click();
	   scrollwindow1(driver);
   }





	/**
	 * This method will validate whether restaurant created under user section
	 * @param driver
	 * @param resturantname
	 * @return
	 */
	public String validateResturantUnderUsersec(WebDriver driver,String resturantname)
	{
		return driver.findElement(By.xpath("//a[text()='"+resturantname+"']")).getText();
	}
	
	

}
