package transsoft.ObjectRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import transsoft_GenericUtility.WebDriverUtilities;

public class AddRestaurantPage extends WebDriverUtilities {
	
	
	@FindBy(name="res_name")
	private WebElement resnameEtTx;
	
	@FindBy(name="email")
	private WebElement emailEtTx;
	
	@FindBy(name="phone")
	private WebElement phoneEtTx;
	
	@FindBy(name="url")
	private WebElement urlEtTx;
	
	@FindBy(name="o_hr")
	private WebElement openhrdrop;
	
	@FindBy(name="c_hr")
	private WebElement closehrdrop;
	
	@FindBy(name="o_days")
	private WebElement daysdrop;
	
	@FindBy(name="file")
	private WebElement fileupload;
	
	@FindBy(name="c_name")
	private WebElement categorydrop;
	
	@FindBy(name="address")
	private WebElement addressEdtx;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible fade show']")
	private WebElement alertsuccessReatau;
	
	
	public AddRestaurantPage(WebDriver Driver)
	{
		PageFactory.initElements(Driver,this);
	}
	

	public WebElement getResnameEtTx() {
		return resnameEtTx;
	}

	public WebElement getEmailEtTx() {
		return emailEtTx;
	}

	public WebElement getPhoneEtTx() {
		return phoneEtTx;
	}

	public WebElement getUrlEtTx() {
		return urlEtTx;
	}

	public WebElement getOpenhrdrop() {
		return openhrdrop;
	}

	public WebElement getClosehrdrop() {
		return closehrdrop;
	}

	public WebElement getDaysdrop() {
		return daysdrop;
	}

	public WebElement getFileupload() {
		return fileupload;
	}

	public WebElement getCategorydrop() {
		return categorydrop;
	}

	public WebElement getAddressEdtx() {
		return addressEdtx;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getAlertsuccessReatau() {
		return alertsuccessReatau;
	}
	
	
	//Business Libraries
	/**
	 * This method will create the restaurant with valid data and save it
	 * @param resturantname
	 * @param BussinessEmail
	 * @param phone
	 * @param weburl
	 * @param imagefilepath
	 * @param driver
	 * @param category
	 * @param RestaurantAddress
	 * @throws AWTException 
	 */
	
	public void addRestaurant(String resturantname,String BussinessEmail,String phone,String weburl,String imagefilepath,WebDriver driver,String category,String RestaurantAddress) throws AWTException
	{
		resnameEtTx.sendKeys(resturantname);
		emailEtTx.sendKeys(BussinessEmail);
		phoneEtTx.sendKeys(phone);
		urlEtTx.sendKeys(weburl);
		dropdown(openhrdrop,5);
		dropdown(closehrdrop,6);
		dropdown(daysdrop,3);
		//fileupload.click();
		//uploadPop("C:\\Users\\mishr\\OneDrive\\Desktop\\SDET\\Documents\\restaurant.jpg");
		
		fileupload.sendKeys(imagefilepath);
		scrollwindow(driver);
		dropdown(category, categorydrop);
		addressEdtx.sendKeys(RestaurantAddress);
		submitBtn.click();
	}
	
	
	/**
	 * This method will validate whether restaurant created or not
	 * @return
	 */
	public String validaterestautantadded()
	{
		return alertsuccessReatau.getText();
	}
	
	
	

}
