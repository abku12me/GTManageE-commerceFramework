package transsoft_Restaurant;

import org.testng.Assert;
import org.testng.Reporter;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import transsoft.ObjectRepository.AddRestaurantCategoryPage;
import transsoft.ObjectRepository.AddRestaurantPage;
import transsoft.ObjectRepository.AdminLoginPage;
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

public class CreateRestaurantTest extends BaseClass {

	@Test(groups="SmokeSuite")
	public void createRestaurant() throws IOException, InterruptedException, AWTException {

         /*Get the path*/
		String E_path = putil.getPathfile("Excelpath");
		String P_path = putil.getPathfile("propertypath");
		String R_Path = putil.getPathfile("Restaurantimage");
		String M_Path = putil.getPathfile("menuimage");
		
		/* Read data from property file for users*/
		String URL1 = putil.getPropertyPathandKey(IConstantUtilities.propertypath, "url1");
		String USERNAME1 = putil.getPropertyPathandKey(IConstantUtilities.propertypath, "username1");
		String PASSWORD1 = putil.getPropertyPathandKey(IConstantUtilities.propertypath, "password1");

		/* Read data from excel sheet for Restaurant */
		String BussinessEmail = eutil.readdataFromExcelBasedOnTestID(E_path, "Restaurants", "TC_41","Bussiness E-mail");
		String phone = eutil.readdataFromExcelBasedOnTestID(E_path, "Restaurants", "TC_41", "Phone");
		String weburl = eutil.readdataFromExcelBasedOnTestID(E_path, "Restaurants", "TC_41", "Website URL");
		String RestaurantAddress = eutil.readdataFromExcelBasedOnTestID(E_path, "Restaurants", "TC_41","Restaurant Address");

		/* Read data from excel sheet for category */
		String categoryname = eutil.readdataFromExcelBasedOnTestID(E_path, "Category", "TC-03", "Category");

		/* click on restaurant link with add category */
		HomePage hp = new HomePage(driver);
		hp.clickOnAllRestaurantLinkwithAddcatg();
		Thread.sleep(2000);

		/* add category with category name and save */
		String category = categoryname + jutil.getRandom();
		AddRestaurantCategoryPage arc = new AddRestaurantCategoryPage(driver);
		arc.addCategory(category);

		/* Valid category is created or not */
		String categorytext = arc.validateCategory();
		Assert.assertTrue(categorytext.contains("New Category Added Successfully"),"category not created successfully");
	    Reporter.log(categorytext + " " + "category created successfully",true);
	
		/* click on add restaurant link */
		hp.clickOnAddRestaurantLink();
		wutil.threadSleep(1000);

		/* create restaurant with mandatory field */
		String resturantname = eutil.readdataFromExcelBasedOnTestID(E_path,"Restaurants","TC_41", "Restaurant Name");

		AddRestaurantPage arp = new AddRestaurantPage(driver);
		arp.addRestaurant(resturantname, BussinessEmail, phone, weburl,"C:\\Users\\mishr\\OneDrive\\Desktop\\SDET\\Documents\\restaurant.jpg", driver, category,RestaurantAddress);

		/* validating add restaurant created or not */
		String resttext = arp.validaterestautantadded();
		Assert.assertTrue(resttext.contains("New Restaurant Added Successfully"),"Restaurant not created successfully");
		Reporter.log(resttext + " " + "Restaurant created successfully",true);
		
		  wutil.threadSleep(1000);
		               
////		   /*click register user*/
//		   driver.findElement(By.linkText("Register")).click();
////		   
////		   /*enter all the manadatory field*/
//	   driver.findElement(By.name("username")).sendKeys("dante003");
//		   driver.findElement(By.name("firstname")).sendKeys("abhishek");
//		   driver.findElement(By.name("lastname")).sendKeys("kumar");
//		   driver.findElement(By.name("email")).sendKeys("mishramech003@gmail.com");
//		   driver.findElement(By.name("phone")).sendKeys("9945345612");
//		   driver.findElement(By.name("password")).sendKeys("mech006");
//		   driver.findElement(By.name("cpassword")).sendKeys("mech006");
//		   driver.findElement(By.name("address")).sendKeys("A B kundalhalli gate bangalore-560037");

//		   JavascriptExecutor jse1=(JavascriptExecutor)driver;
//	       jse1.executeScript("window.scrollBy(0,400);");
//	       driver.findElement(By.name("submit")).click();
		
		/* Login as user */

		/* Click on login button */
		UserLoginPage ulp = new UserLoginPage(driver);
		ulp.LoginToAppUser(driver, URL1, USERNAME1, PASSWORD1);

		/* click on restaurant link */
		UserHomePage uhp = new UserHomePage(driver);
		uhp.restaurantlink();

		/* validating same restaurant is displayed under restaurant user section */
		ValidateRestaurantDisplayPage vrdp = new ValidateRestaurantDisplayPage(driver);
		vrdp.validateResturantUnderUsersec(driver, resturantname);
		String restname = vrdp.validateResturantUnderUsersec(driver, resturantname);
		Assert.assertTrue(restname.contains(resturantname),"Newly added restaurant has not been displayed in user module as");
		Reporter.log("Newly added restaurant displayed in user module as " + restname,true);
	




	}

}
