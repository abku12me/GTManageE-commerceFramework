package transsoft.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	@FindBy(xpath="//span[.='Restaurant']")
	private WebElement RestaurantLink;
	
	@FindBy(linkText="All Restaurant")
	private WebElement AllRestaurantLink;
	
	@FindBy(linkText="Add Category")
	private WebElement AddCategoryLink;
	
	@FindBy(linkText="Add Restaurant")
	private WebElement AddRestaurantLink;
	
	@FindBy(xpath="//span[.='Menu']")
	private WebElement MenuLink;
	
	@FindBy(linkText="Add Menu")
	private WebElement AddMenuLink;
	
	@FindAll({@FindBy(linkText="All Menues"),@FindBy(xpath="//a[.='All Menues']")})
	private WebElement AllMenueslink;
	
	@FindBy(xpath="//span[.='Orders']")
	private WebElement Orderslink;
	
	
	@FindBy(xpath="//span[.='Dashboard']")
	private WebElement DashboardLink;
	
	@FindBy(xpath="//span[.='Users']")
	private WebElement UsersLink;
	
	@FindBy(xpath="//img[@class='profile-pic']")
	private WebElement profilepiclink;
	
	
	@FindBy(xpath="//a[@href='logout.php']")
	private WebElement logoutLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getRestaurantLink() {
		return RestaurantLink;
	}

	public WebElement getAllRestaurantLink() {
		return AllRestaurantLink;
	}

	public WebElement getAddCategoryLink() {
		return AddCategoryLink;
	}

	public WebElement getAddRestaurantLink() {
		return AddRestaurantLink;
	}

	public WebElement getMenuLink() {
		return MenuLink;
	}

	public WebElement getAddMenuLink() {
		return AddMenuLink;
	}

	public WebElement getAllMenueslink() {
		return AllMenueslink;
	}

	public WebElement getOrderslink() {
		return Orderslink;
	}

	public WebElement getDashboardLink() {
		return DashboardLink;
	}

	public WebElement getUsersLink() {
		return UsersLink;
	}

	public WebElement getProfilepiclink() {
		return profilepiclink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	//Business libraries
	/**
	 * This method will click on add category link
	 */
	
	public void clickOnAllRestaurantLinkwithAddcatg()
	{
		RestaurantLink.click();
		AddCategoryLink.click();
		
	}
	
	/**
	 * This method will perfrom click on add restaurant
	 */
	public void clickOnAllRestaurantLinkwithAddRest()
	{
		RestaurantLink.click();
		AddRestaurantLink.click();
	}
	
	/**
	 * This method will perform click on add menu
	 */
	public void clickOnAddMenu()
	{
		MenuLink.click();
		AddMenuLink.click();
	}
	
	/**
	 * This method will perform click on order link
	 */
	public void clickOnOrderLink()
	{
		Orderslink.click();
	}
	
	
	/**
	 * This method will perform click on dashboard link
	 */
	public void clickOnDashboardlink()
	{
		DashboardLink.click();
	}
	
	/**
	 * This method will perform click on users link
	 */
	public void clickOnuserlink()
	{
		UsersLink.click();
	}
	
	/**
	 * This method will click on all menues link
	 */
	public void clickOnAllmenuLink()
	{
		AllMenueslink.click();
		
	}
	
	public void clickOnAddRestaurantLink()
	{
		AddRestaurantLink.click();
	}
	
	
	
	
	
	
	
}
