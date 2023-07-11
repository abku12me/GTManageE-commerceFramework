package transsoft_GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import transsoft.ObjectRepository.AdminLoginPage;
import transsoft.ObjectRepository.HomePage;
import transsoft.ObjectRepository.UserHomePage;
import transsoft.ObjectRepository.UserLoginPage;

/**
 * This class consists of basic configuration annotation of testng
 * 
 * @author abhishek
 *
 */

public class BaseClass {

	public PropertyFileUtilities putil = new PropertyFileUtilities();
	public ExcelsheetUtilities eutil = new ExcelsheetUtilities();
	public JavaUtilities jutil = new JavaUtilities();
	public WebDriverUtilities wutil = new WebDriverUtilities();
	public DatabaseUtilities dutil=new DatabaseUtilities();
	
	public WebDriver driver = null;
	public static WebDriver ListenerDriver;

	@BeforeSuite(alwaysRun=true)
	public void DBConnection() throws SQLException, IOException {
		
		dutil.getConnection();
		System.out.println("Database connection successfully");
	}
    //@Parameters("BROWSER")
	@BeforeClass(alwaysRun=true)
	public void launchBrowser() throws IOException {
	String BROWSER = putil.getPropertyPathandKey(IConstantUtilities.propertypath, "browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			ListenerDriver=driver;
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			ListenerDriver=driver;
		} else
		driver = new ChromeDriver();
		ListenerDriver=driver;
		wutil.maximize(driver);
		wutil.implicitWait(driver,12);

	}

	@BeforeMethod(alwaysRun=true)
	public void LoginToAdminApplication() throws IOException {
		String URL = putil.getPropertyPathandKey(IConstantUtilities.propertypath, "url");
		String USERNAME = putil.getPropertyPathandKey(IConstantUtilities.propertypath, "username");
		String PASSWORD = putil.getPropertyPathandKey(IConstantUtilities.propertypath, "password");
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(driver, URL, USERNAME, PASSWORD);
	}

	@BeforeMethod(enabled=false)
	public void LoginToUserApplication() throws IOException {
		String URL1 = putil.getPropertyPathandKey(IConstantUtilities.propertypath, "url1");
		String USERNAME1 = putil.getPropertyPathandKey(IConstantUtilities.propertypath, "username1");
		String PASSWORD1 = putil.getPropertyPathandKey(IConstantUtilities.propertypath, "password1");
		UserLoginPage ulp = new UserLoginPage(driver);
		ulp.LoginToAppUser(driver, URL1, USERNAME1, PASSWORD1);

	}

	@AfterMethod(alwaysRun=true)
	public void logoutFromAdminApp() {
		HomePage hp = new HomePage(driver);
		hp.getLogoutLink();

	}

	@AfterMethod(enabled=false)
	public void logoutFromUserApp() {
		UserHomePage uhp = new UserHomePage(driver);
		uhp.logoutAsUser();

	}

	@AfterClass(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
	}

	@AfterSuite(alwaysRun=true)
	public void closeDB() {
		System.out.println("Database closed successfully");

	}

}
