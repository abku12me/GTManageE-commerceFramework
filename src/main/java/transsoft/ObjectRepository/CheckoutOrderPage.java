package transsoft.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import transsoft_GenericUtility.WebDriverUtilities;

public class CheckoutOrderPage extends WebDriverUtilities{
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	public CheckoutOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Business Libraries
	
	/**
	 * This method will click on order now button on user module
	 */
	public void clickOnOrderNowHandlealert(WebDriver driver)
	{
		submitBtn.click();
		alert(driver);
		alert(driver);
		
	}
	
	
	
	
	
	
	
	
	

}
