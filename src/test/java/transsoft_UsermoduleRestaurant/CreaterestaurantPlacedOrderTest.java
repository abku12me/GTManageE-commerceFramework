package transsoft_UsermoduleRestaurant;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import transsoft.ObjectRepository.AdminLoginPage;
import transsoft.ObjectRepository.AllOrderAdminPage;
import transsoft.ObjectRepository.CheckoutOrderPage;
import transsoft.ObjectRepository.DashboardPage;
import transsoft.ObjectRepository.DishesUserPage;
import transsoft.ObjectRepository.HomePage;
import transsoft.ObjectRepository.UserHomePage;
import transsoft.ObjectRepository.UserLoginPage;
import transsoft.ObjectRepository.ValidateRestaurantDisplayPage;
import transsoft_GenericUtility.BaseClass;
import transsoft_GenericUtility.ExcelsheetUtilities;
import transsoft_GenericUtility.IConstantUtilities;
import transsoft_GenericUtility.JavaUtilities;
import transsoft_GenericUtility.PropertyFileUtilities;
import transsoft_GenericUtility.WebDriverUtilities;

public class CreaterestaurantPlacedOrderTest{

	@Test//(retryAnalyzer=transsoft_GenericUtility.retryAnalyzersImplementation.class)
	public void createrestaurantPlacedOrder() throws IOException {
		PropertyFileUtilities putil = new PropertyFileUtilities();
		ExcelsheetUtilities eutil = new ExcelsheetUtilities();
		JavaUtilities jutil = new JavaUtilities();
		WebDriverUtilities wutil = new WebDriverUtilities();
		
		String R_Path = putil.getPathfile("Restaurantimage");
		String M_Path = putil.getPathfile("menuimage");

		WebDriver driver = new ChromeDriver();
		wutil.maximize(driver);
		wutil.implicitWait(driver, 10);
		
		/* Get the path */
		String E_path = putil.getPathfile("Excelpath");
		String P_path = putil.getPathfile("propertypath");

		/* Read data from property file for user */
		String URL1 = putil.getPropertyPathandKey(IConstantUtilities.propertypath, "url1");
		String USERNAME1 = putil.getPropertyPathandKey(IConstantUtilities.propertypath, "username1");
		String PASSWORD1 = putil.getPropertyPathandKey(IConstantUtilities.propertypath, "password1");

		/* Read the data from property file for admin */
		String BROWSER = putil.getPropertyPathandKey(P_path, "browser");
		String URL = putil.getPropertyPathandKey(P_path, "url");
		String USERNAME = putil.getPropertyPathandKey(P_path, "username");
		String PASSWORD = putil.getPropertyPathandKey(P_path, "password");

		/* Login as user */
		UserLoginPage ulp = new UserLoginPage(driver);
		ulp.LoginToAppUser(driver, URL1, USERNAME1, PASSWORD1);

		/* click on restaurant link */
		UserHomePage uhp = new UserHomePage(driver);
		uhp.restaurantlink();

		/* click on view menu link and select the dish */
		ValidateRestaurantDisplayPage vrdp = new ValidateRestaurantDisplayPage(driver);
		vrdp.viewMenuLink(driver);
		DishesUserPage dup = new DishesUserPage(driver);
		dup.dishesselect(driver);

		/* click on checkout button */
		dup.checkout();

		/* click on order now and confirm the order */
		CheckoutOrderPage coh = new CheckoutOrderPage(driver);
		coh.clickOnOrderNowHandlealert(driver);

		/* logout from user */
		uhp.logoutAsUser();

		/* Login as admin */
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(driver, URL, USERNAME, PASSWORD);

		/* click on order link */
		HomePage hp = new HomePage(driver);
		hp.clickOnOrderLink();

		/* check order has been placed under order section or not */
		AllOrderAdminPage aop = new AllOrderAdminPage();
		String users = putil.getPropertyPathandKey(P_path, "username1");
		String orderplaced = aop.validateOrder(driver, users);
		Assert.assertTrue(orderplaced.contains(users),"order has not been placed under all order section");
		Reporter.log("order has been placed under all order section" + " " + orderplaced,true);
		
		/* click on dashboard to check total order is reflected or not */
		hp.clickOnDashboardlink();
		DashboardPage dp = new DashboardPage(driver);
		String ordercount = dp.validateOrderCount();
		Assert.assertTrue(ordercount.contains("Total Orders"),"newly added dishes will been reflected");
		Reporter.log("newly added dishes count will be= " + ordercount,true);
		
		driver.close();

	}

}
