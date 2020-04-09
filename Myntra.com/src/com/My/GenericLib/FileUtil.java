package com.My.GenericLib;

import java.util.Iterator;
import java.util.Set;

import javax.swing.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FileUtil {

	
	
	/**
	 * uday
	 * This method for select the dropdown options
	 * @param we
	 * @param value
	 */
	public void selectByValue(WebElement we,String value)
	{
		Select sel=new Select(we);
		sel.selectByValue(value);
	}
	
	
	
	/**
	 * uday
	 * This method is used for switch the driver control to new window
	 * @param driver
	 * @return
	 */
	public String switchToNewWindow(WebDriver driver)
	{
		Set<String> ids = driver.getWindowHandles();
		
		Iterator<String> it=ids.iterator();
		
		String pid=it.next();
		String cid=it.next();
		
		driver.switchTo().window(cid);
		
		return pid;
	}
	
	public void moveToElement(WebDriver driver,WebElement we)
	
	{
	Actions act=new Actions(driver);
	act.moveToElement(we).perform();
		
	}
	
}
