package transsoft.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	@FindBy(xpath="//p[.='Dishes']/../..")
	private WebElement Dashboardcpat;
	
	@FindBy(xpath="//p[.='Total Orders']/..")
	private WebElement TotalOrders;
	
	

	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}

	public WebElement getDashboardcpat() {
		return Dashboardcpat;
	}
	
	public WebElement getTotalOrders() {
		return TotalOrders;
	}
	
	
	//Business Libraries
	
	public String validateDashboardDish()
	{
		return Dashboardcpat.getText();
	}
	
	/**
	 * This method will validate whether order placed under dashboard section
	 * @return
	 */
	
	public String validateOrderCount()
	{
		return TotalOrders.getText();
		
	}
	
	

}
