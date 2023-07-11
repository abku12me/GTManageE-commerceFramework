package transsoft.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	
	@FindBy(xpath="//a[@href='restaurants.php']")
	private WebElement restaurantsLink;
	
	
	@FindBy(linkText="Logout")
	private WebElement LogoutLink;
	
	public UserHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);	
	}

	public WebElement getRestaurantsLink() {
		return restaurantsLink;
	}
	
	public WebElement getLogoutLink() {
		return LogoutLink;
	}

	//Business Libraries
	/**
	 * This method will perform click action on user restaurant module
	 */
	public void restaurantlink()
	{
		restaurantsLink.click();
	}
	
	/**
	 * This method will perform logout action from user module
	 */
	public void logoutAsUser()
	{
		LogoutLink.click();
	}
	
	
	

}
