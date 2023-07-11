package practice;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AdvancedSelenium.elementRepository.LoginPage;
import transsoft.ObjectRepository.AdminLoginPage;
import transsoft.ObjectRepository.HomePage;
import transsoft_GenericUtility.ExcelsheetUtilities;

public class PracticeDataProvider {

	ExcelsheetUtilities eutil = new ExcelsheetUtilities();

	@Test(dataProvider = "category")
	public void categoryCreation(String categoryname) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/index.php");
		driver.findElement(By.name("username")).sendKeys("admin", Keys.TAB, "codeastro", Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Restaurant']")).click();
		driver.findElement(By.linkText("Add Category")).click();
		driver.findElement(By.name("c_name")).sendKeys(categoryname);
	}

	@DataProvider(name = "category")
	public Object[][] getdataprov() throws EncryptedDocumentException, IOException {
		Object[][] data = eutil.readmultipleDataFromexcel(".\\Dataprovider\\dataprovider.xlsx", "dataprovider");
		return data;
	}

}
