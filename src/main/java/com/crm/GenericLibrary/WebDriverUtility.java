package com.crm.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * this class consists of all the generic methods
 *  related to webdriveraction
 * @author Rakshitha
 *
 */
public class WebDriverUtility
{
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * this method will wit for 20 seconds for the page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	/**
	 * this method wil wait for 10seconds for an 
	 * element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	/**
	 * this method wil wait for 20 seconds for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	/**
	 * This method wil select data from dropdown using Index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);

	}
	
	/**
	 * this method wil select data from dropdown using visible text
	 * @param element
	 * @param index
	 */
	
	public void select(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);

	}
	/**
	 * this method will select data from dropdown using visible value
	 * @param value
	 * @param element
	 */
	
	
	public void select(String value,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
		
	}
	
	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mousehover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	/**
	 * This mehod will perform drag and drop
	 * @param driver
	 * @param src
	 * @param target
	 */
	
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement target)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, target).perform();
			
	}
	/**
	 *This method  will double click on element 
	 * @param driver
	 * @param Element
	 */
	
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element);
		
	}
	/**
	 * this method perform double click on webpage
	 * @param driver
	 */
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
		
	}
	/**
	 * this method wil right click on webpage
	 * @param driver
	 */
	
	public void rightClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
		
	}
	/**
	 * this method will right click on element
	 * @param driver
	 * @param Element
	 */
	
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		
	}
	
	/**
	 * this method will press enter key
	 * @param driver
	 */
	
	public void enterKeyPress(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		
	}
	
	
	/**
	 * this method will press enter key
	 * @param driver
	 * @throws Throwable 
	 */
	
	public void enterKey() throws Throwable
	{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		
	}
	
	/**
	 * this method will release enter key
	 * @throws Throwable
	 */
	public void enterRelease() throws Throwable
	{
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
		
	}
	/**
	 * this method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * this method will switch the frame based on name or id
	 * @param driver
	 * @param index
	 */
	
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * this method will switch the frame based on address of the element
	 * @param driver
	 * @param index
	 */
	
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 * this method will accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method will cancel the pop up
	 * @param driver
	 */
	
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method will switch between windows
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		//step1:use getwindowHandles to capture all window ids
		Set<String> windows=driver.getWindowHandles();
		
		//step2:iterate thru thw windows
		Iterator<String> it=windows.iterator();
		
		//step3:check whether there is next window
		while(it.hasNext())
		{
			//step 4:capture current window id
			String winId=it.next();
			
			//step5:switch to current window and capture title
			String currentWinTitle=driver.switchTo().window(winId).getTitle();
			
			//step6:check whether the current window is expected
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
		
		
	}
	
	/**
	 * this method wil take screenshot and store it in folder called as SCreenshot
	 * @param driver
	 * @param screenShotName
	 * @throws Throwable
	 */
	
	public String getScreenShot(WebDriver driver,String screenShotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=".\\Screenshot\\"+screenShotName+".png";
		File dst=new File(path);
		Files.copy(src, dst);
		return dst.getAbsolutePath();
	}
	
	/**
	 * this method will perform random scroll
	 * @param driver
	 */
	public void scrollAction(WebDriver driver){
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	/**
	 * this method will scroll untill the specified element is found
	 * @param driver
	 * @param element
	 */
	
	public void scrollAction(WebDriver driver,WebElement element){
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window(0,"+y+")",element);
		//js.executeScript("argument[0].scrollIntoView()",element);
	}
}
