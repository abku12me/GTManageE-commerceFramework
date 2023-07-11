package trassoft_AddMenu;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import transsoft.ObjectRepository.AddMenuPage;
import transsoft.ObjectRepository.AddRestaurantCategoryPage;
import transsoft.ObjectRepository.AddRestaurantPage;
import transsoft.ObjectRepository.AdminLoginPage;
import transsoft.ObjectRepository.AllMenuPage;
import transsoft.ObjectRepository.DashboardPage;
import transsoft.ObjectRepository.HomePage;
import transsoft_GenericUtility.BaseClass;
import transsoft_GenericUtility.ExcelsheetUtilities;
import transsoft_GenericUtility.IConstantUtilities;
import transsoft_GenericUtility.JavaUtilities;
import transsoft_GenericUtility.PropertyFileUtilities;
import transsoft_GenericUtility.WebDriverUtilities;

@Listeners(transsoft_GenericUtility.ListenerImplementation.class)
public class AddModuletoDashboardTest extends BaseClass {

	@Test//(retryAnalyzer=transsoft_GenericUtility.retryAnalyzersImplementation.class)
	public void addModuleToDashboard() throws IOException, InterruptedException, AWTException {

		/* Get the file path */
		String E_path = putil.getPathfile("Excelpath");
		String P_path = putil.getPathfile("propertypath");

		/* Read data from excel sheet for Restaurant */
		String RestaurantName = eutil.readdataFromExcelBasedOnTestID(E_path, "Restaurants", "TC_41", "Restaurant Name");
		String BussinessEmail = eutil.readdataFromExcelBasedOnTestID(E_path, "Restaurants", "TC_41",
				"Bussiness E-mail");
		String phone = eutil.readdataFromExcelBasedOnTestID(E_path, "Restaurants", "TC_41", "Phone");
		String weburl = eutil.readdataFromExcelBasedOnTestID(E_path, "Restaurants", "TC_41", "Website URL");
		String RestaurantAddress = eutil.readdataFromExcelBasedOnTestID(E_path, "Restaurants", "TC_41",
				"Restaurant Address");

		/* Read data from excel sheet for category */
		String categoryname = eutil.readdataFromExcelBasedOnTestID(E_path, "Category", "TC-03", "Category");

		/* Read data from excel sheet for menu */
		String Dish = eutil.readdataFromExcelBasedOnTestID(E_path, "Menu", "TC_01", "Dish Name");
		String description = eutil.readdataFromExcelBasedOnTestID(E_path, "Menu", "TC_01", "Description");
		String price = eutil.readdataFromExcelBasedOnTestID(E_path, "Menu", "TC_01", "Price");

		/* click on restaurant link with add category */
		HomePage hp = new HomePage(driver);
		hp.clickOnAllRestaurantLinkwithAddcatg();

		wutil.threadSleep(1000);
		/* add category with category name and save */
		String category = categoryname + jutil.getRandom();
		AddRestaurantCategoryPage arc = new AddRestaurantCategoryPage(driver);
		arc.addCategory(category);
		
		/* Valid category is created or not */
		String actualcateg = arc.validateCategory();
		Assert.assertTrue(actualcateg.contains("New Category Added Successfully"));
		Reporter.log(actualcateg + " " + "category created successfully",true);

		/* click on add restaurant link */
		hp.clickOnAddRestaurantLink();
		wutil.threadSleep(1000);

		/* create restaurant with mandatory field */
		String resturantname = RestaurantName;
		AddRestaurantPage arp = new AddRestaurantPage(driver);
		arp.addRestaurant(resturantname, BussinessEmail, phone, weburl,
				"C:\\Users\\mishr\\OneDrive\\Desktop\\SDET\\Documents\\restaurant.jpg", driver, category,
				RestaurantAddress);

		/* validating add restaurant created or not */
		String restaurantAdd = arp.validaterestautantadded();
		Assert.assertTrue(restaurantAdd.contains("New Restaurant Added Successfully"));
		Reporter.log(restaurantAdd + " " + "Restaurant created successfully",true);
	
		/* click on menu link and also click on add menu link */
		hp.clickOnAddMenu();

		
		/* add menu with manadatory field and click on save button */
		String menu = Dish;
		AddMenuPage amp = new AddMenuPage(driver);
		amp.addMenu(menu, description, price, "C:\\Users\\mishr\\OneDrive\\Desktop\\HTML Concepts\\image\\BlackTea.jpg",
				resturantname);

		/* validate the menu added or not */
		amp.validateMenu();
		String actualmenu = amp.validateMenu();
		Assert.assertTrue(actualmenu.contains("New Dish Added Successfully"),"Dish has not been created successfully");
		Reporter.log(actualmenu + " " + "Dish created successfully",true);

		/* check menu adeed under all menu section */
		hp.clickOnAllmenuLink();
		AllMenuPage amps = new AllMenuPage();
		String actualallmen = amps.validatAllMenu(menu, driver);
		Assert.assertTrue(actualallmen.contains(menu),"new menu not added under all menu list");
		Reporter.log(menu + " " + "new menu added under all menu list",true);
	
		/* check the dashboard count */
		DashboardPage dbp = new DashboardPage(driver);
		hp.clickOnDashboardlink();
		String dishescount = dbp.validateDashboardDish();
		Assert.assertTrue(dishescount.contains("Dishes"),"Dish has not been displayed under dashboard");
		Reporter.log(dishescount + " " + "Dish has been displayed under dashboard",true);
		

	}

}
