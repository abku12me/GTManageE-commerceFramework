package transsoft.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRestaurantCategoryPage {
	
	
	@FindBy(name="c_name")
	private WebElement CategortName;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible fade show']")
	private WebElement alertsuccess;
	

	public AddRestaurantCategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}


	public WebElement getCategortName() {
		return CategortName;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public WebElement getAlertsuccess() {
		return alertsuccess;
	}
	
	
	//Business libraries
	
	/**
	 * This method will add the category with valid data
	 * @param category
	 */
	public void addCategory(String category)
	{
		CategortName.sendKeys(category);
		submitBtn.click();
	}
	
	/**
	 * This method will validate whether category is added or not 
	 * @return
	 */
	public String validateCategory()
	{
		String validcateg=alertsuccess.getText();
		return validcateg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
