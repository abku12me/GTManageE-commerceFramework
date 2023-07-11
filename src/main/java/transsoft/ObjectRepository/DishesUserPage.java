package transsoft.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import transsoft_GenericUtility.WebDriverUtilities;

public class DishesUserPage extends WebDriverUtilities{
	
	@FindBy(xpath="//a[text()='French onion soup']/ancestor::div[@class='food-item']/descendant::input[@value='Add To Cart']")
	private WebElement fooditemRest;
	
	@FindBy(linkText="Checkout")
	private WebElement CheckoutBtn;
	
	public DishesUserPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}

	public WebElement getFooditemRest() {
		return fooditemRest;
	}

	public WebElement getCheckoutBtn() {
		return CheckoutBtn;
	}
	
	
	//Business Libraries
	
	/**
	 * This method will perform dish selection
	 */
	
	public void dishesselect(WebDriver driver)
	{
		fooditemRest.click();
		scrollwindow1(driver);
	}
	
	
	/**
	 * This method will perform click on checkout
	 */
	
	public void checkout()
	{
		CheckoutBtn.click();
	}
	

}
