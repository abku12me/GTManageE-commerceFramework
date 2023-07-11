package transsoft.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import transsoft_GenericUtility.WebDriverUtilities;

public class AddMenuPage extends WebDriverUtilities{
	
	//welcome
	//lets begin
	@FindBy(name="d_name")
	private WebElement dishnameEdTx;
	
	@FindBy(name="about")
	private WebElement aboutEdTx;
	
	@FindBy(name="price")
	private WebElement priceEdTx;
	
	@FindBy(name="file")
	private WebElement fileupload;
	
	@FindBy(name="res_name")
	private WebElement restaurantdrop;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='container-fluid']/div[@class='alert alert-success alert-dismissible fade show']")
	private WebElement alertsuccessMenu;
	
	public AddMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getDishnameEdTx() {
		return dishnameEdTx;
	}

	public WebElement getAboutEdTx() {
		return aboutEdTx;
	}

	public WebElement getPriceEdTx() {
		return priceEdTx;
	}

	public WebElement getFileupload() {
		return fileupload;
	}

	public WebElement getRestaurantdrop() {
		return restaurantdrop;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getAlertsuccessMenu() {
		return alertsuccessMenu;
	}
	
     //Business Libraries
	
	/**
	 * This method will add menu with valid data and save it
	 * @param menu
	 * @param description
	 * @param price
	 * @param menufilepath
	 * @param resturantname
	 */
	public void addMenu(String menu,String description,String price,String menufilepath,String resturantname)
	{
		
		dishnameEdTx.sendKeys(menu);
		aboutEdTx.sendKeys(description);
		priceEdTx.sendKeys(price);
		fileupload.sendKeys(menufilepath);
		dropdown(resturantname, restaurantdrop);
		submitBtn.click();
	}
	
	/**
	 * This method will validate menu is added or not
	 * @return
	 */
	public String  validateMenu()
	{
		return alertsuccessMenu.getText();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
