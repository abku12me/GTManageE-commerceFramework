package transsoft_GenericUtility;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *This class consists of generic method related to web driver 
 * @author abhishek
 *
 */

public class WebDriverUtilities {
	
	/**
	 * This method will maximize the browser
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	
	/**
	 * This method will minimize the browser
	 * @param driver
	 */
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();
		
	}
	
	/**
	 * This method will wait element to be loaded inside the web page
	 * @param driver
	 * @param longsec
	 */
	public void implicitWait(WebDriver driver,int longsec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longsec));
	}
	
	/**
	 * This method will chk the particular condition is satisfied or not(explicit wait)
	 * @param driver
	 * @param longsec
	 * @param element
	 */
	public void explicitWait(WebDriver driver,int longsec ,WebElement element )
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(longsec));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	/**
	 * this method will select the option from the drop down based on indexing
	 * @param element
	 * @param indexnum
	 */
	public void dropdown(WebElement element,int indexnum )
	{
		Select s=new Select(element);
		s.selectByIndex(indexnum);
	}
	
	/**
	 * this method will select the option from the drop down based on value
	 * @param element
	 * @param indexnum
	 */
	public void dropdown(WebElement element,String value )
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * this method will select the option from the drop down based on visible Text
	 * @param element
	 * @param indexnum
	 */
	public void dropdown(String value,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(value);
	}
	
	/**
	 * This method will perform mouse over action to particular element inside the web page
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will switch to window based on title of the page
	 * @param driver
	 * @param partialwintitle
	 */
	
	public void windowHandle(WebDriver driver,String partialwintitle )
	{
		Set<String> allid = driver.getWindowHandles();
		for(String id:allid)
		{
			String wintitle=driver.switchTo().window(id).getTitle();
			if(wintitle.contains(partialwintitle))
				break;
			
		}
		
	}
	
	
	/**
	 * This method will switch to window based on url of the page
	 * @param driver
	 * @param partialwintitle
	 */
	
	public void windowHandle(String partialUrltitle,WebDriver driver)
	{
		Set<String> allid = driver.getWindowHandles();
		for(String id:allid)
		{
			String wintitle=driver.switchTo().window(id).getTitle();
			if(wintitle.contains(partialUrltitle))
				break;
			
		}
		
	}
	
	/**
	 * This method will perform scroll action based on x and y co-ordinate (0,600)
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollwindow(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,600);");
		
	}
	
	/**
	 * This method will scroll window based on given(0,400)
	 * @param driver
	 */
	public void scrollwindow1(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400);");
		
	}
	
	
	/**
	 * This method wil perform accept action on alert pop-up
	 * @param driver
	 */
	public void alert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	
	
	/**
	 * This method wil perform dismiss action on alert pop-up
	 * @param driver
	 */
	public void alertdismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
		
	}
	
	/**
	 * This method wil get text present in the alert pop-up
	 * @param driver
	 */
	public String alertGetText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
		
	}
	
	/**
	 * This method wil pass text on alert pop up
	 * @param driver
	 */
	public String alertText(WebDriver driver,String textvalue)
	{
	    driver.switchTo().alert().sendKeys(textvalue);
		return textvalue;
		
	}
	
	/**
	 * This method will switch page to frame based on index
	 * @param driver
	 * @param indexnum
	 */
	
	public void framehandle(WebDriver driver,int indexnum )
	{
		driver.switchTo().frame(indexnum);
	}
	
	/**
	 * This method will switch page to frame based on id and name attribute value
	 * @param driver
	 * @param indexnum
	 */
	
	public void framehandle(WebDriver driver,String idandnameattributevalue)
	{
		driver.switchTo().frame(idandnameattributevalue);
	}
	
	/**
	 * This method will switch page to frame based on Web element
	 * @param driver
	 * @param indexnum
	 */
	
	public void framehandle(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
	/**
	 * This method will switch back to default page frame
	 * @param driver
	 * @param indexnum
	 */
	
	public void framedefault(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	
	/**
	 * This method will perform scroll action to particular web element
	 * @param driver
	 * @param element
	 */
	
	public void scrollToElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	/**
	 * This method will take the screenshot of the entire page
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException 
	 */
	
	public String screenshot(WebDriver driver,String screenshotname) throws IOException
	{
		TakesScreenshot shot=(TakesScreenshot)driver;
		File scr=shot.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\Screenshot\\"+screenshotname+".png");
		FileUtils.copyFile(scr, dst);
		return dst.getAbsolutePath();
	}
	
	
	
	/**
	 * This method will perform double click action any where into the web page
	 * @param driver
	 */
	public void doubleClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform double click action on particular web element
	 * @param driver
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	
	/**
	 * This method will wait and then perform the click action
	 * @param element
	 * @throws InterruptedException
	 */
	
	public void customWaitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<20)
		{
			element.click();
			break;
		}
		  Thread.sleep(2000);
		  count++;		
	}
	
	
	/**
	 * This method wait for the element and type the data
	 * @param element
	 * @throws InterruptedException
	 */
	
	public void waitAndType(WebElement element,String data ) throws InterruptedException
	{
		int count=0;
		while(count<20)
		{
			element.sendKeys(data);
			break;
		}
		  Thread.sleep(2000);
		  count++;		
	}
	
	/**
	 * This method will perform uploading file thru desktop by using robot class
	 * @param filepath
	 * @throws AWTException
	 */
	
	public void uploadPop(String filepath) throws AWTException
	{
		StringSelection path=new StringSelection(filepath);
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContents(path, null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	/**
	 * This method will disable notification pop
	 */
	public void notificationPop()
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
	}
	
	/**
	 * This method will wait til the element is click able
	 * @param driver
	 * @param longsec
	 * @param element
	 */
	public void clickToBeClickable(WebDriver driver,int longsec,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(longsec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	/**
	 * This method will work on fluent wait till the visibility of particular element
	 * @param driver
	 * @param longsec1
	 * @param longsec2
	 * @param element
	 */
	public void visibilityofFluentWait(WebDriver driver,int longsec1,int longsec2,WebElement element)
	{
		FluentWait wait=new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(longsec1));
		wait.pollingEvery(Duration.ofSeconds(longsec2));
		wait.ignoring(TimeoutException.class);
		wait.until(ExpectedConditions.visibilityOf(element));		
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src,dst).perform();
	}
	
	
	/**
	 * This method will perform drag and drop action corresponding x and y coordinate
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,int xoffset,int yoffset)
	{
		Actions act=new Actions(driver);
		act.dragAndDropBy(src, xoffset, yoffset).perform();
	}
	
//	public void sizeOfBrowser(WebDriver driver,int width,int height)
//	{
//		driver.manage().window().setSize(new Dimension(width,height));
//	}
	
	
	/**
	 * this method will perform click and hold action into the web page
	 * @param driver
	 */
	public void clickAndHold(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.clickAndHold().perform();	
	}
	
	
	/**
	 * this method will perform click and hold action to the particular web-element
	 * @param driver
	 */
	public void clickAndHoldTo(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();	
	}
	
	
	/**
	 * This method will release element any where into the web-page
	 * @param driver
	 */
	public void releaseElement(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.release().perform();
	}
	
	
	/**
	 * This method will release element to the particular location
	 * @param driver
	 */
	public void releaseElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.release(element).perform();
	}
	
	
	/**
	 * This method will perform thread sleep action
	 * @param millsec
	 * @throws InterruptedException
	 */
	public void threadSleep(int millsec) throws InterruptedException
	{
		
		Thread.sleep(millsec);
	}
	/**
	 * This method will take screenshot to particular Web-element
	 * @param element
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
	
	public String screenshotToPartEle(WebElement element,String screenshotname) throws IOException
	{
		File scr=element.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\Screensho\\"+screenshotname+".png");
		FileUtils.copyFile(scr, dst);
		return dst.getAbsolutePath();
	}
	
	
	/**
	 * This method will paste the path by using robot class
	 * @throws AWTException
	 */
	public void pasteWithRobClass() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	
	
//	public void getLocation(WebDriver driver)
//	{
//		driver.manage().window().setPosition(new Point(100,100));
//		
//		
//	}
	
	
	
	
	
	
	
	

}
