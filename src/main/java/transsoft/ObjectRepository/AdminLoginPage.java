package transsoft.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	
	@FindBy(name="username")
	private WebElement usernameEdtTx;
	
	@FindAll({@FindBy(name="password"),@FindBy(css="[placeholder='Password']")})
	private WebElement passwordEdtTx;
	
	@FindBys({@FindBy(name="submit"),@FindBy(xpath="//input[@value='Login']")})
	private WebElement submitBtn;
	
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getUsernameEdtTx() {
		return usernameEdtTx;
	}

	public WebElement getPasswordEdtTx() {
		return passwordEdtTx;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	//Business Libraries
	
	/**
	 * This method will login as admin with valid cred
	 * @param username
	 * @param password
	 */
	
	public void adminLogin(WebDriver driver,String url,String username,String password)
	{
		driver.get(url);
		usernameEdtTx.sendKeys(username);
		passwordEdtTx.sendKeys(password);
		submitBtn.click();
		
	}
	
	
	
	

}
