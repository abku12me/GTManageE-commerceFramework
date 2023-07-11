package transsoft.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	
	@FindBy(linkText="Login")
	private WebElement LoginLink;
	
	@FindBy(name="username")
	private WebElement usernameEdTx;
	
	@FindBy(name="password")
	private WebElement passwordEdTx;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	
	public UserLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}


	public WebElement getLoginLink() {
		return LoginLink;
	}


	public WebElement getUsernameEdTx() {
		return usernameEdTx;
	}


	public WebElement getPasswordEdTx() {
		return passwordEdTx;
	}


	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	//Business Libraries
	/**
	 * This method will perform login action as user module
	 * @param driver
	 * @param URL1
	 * @param username
	 * @param password
	 */
	
	public void LoginToAppUser(WebDriver driver,String URL1,String username,String password)
	{
		driver.get(URL1);
		LoginLink.click();
		usernameEdTx.sendKeys(username);
		passwordEdTx.sendKeys(password);
		submitBtn.click();
	}
	
	
	
	
	
	
	

}
