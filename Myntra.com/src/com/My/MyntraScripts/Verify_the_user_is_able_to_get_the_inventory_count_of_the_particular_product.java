package com.My.MyntraScripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.My.GenericLib.Base;
import com.My.ObjectRepository.HomePage;
import com.My.ObjectRepository.LogIn;
import com.My.ObjectRepository.Product;

import junit.framework.Assert;
@Listeners(com.My.GenericLib.ListenerImp.class)
public class Verify_the_user_is_able_to_get_the_inventory_count_of_the_particular_product extends Base
{
@Test
public void dem()
{
HomePage home=PageFactory.initElements(driver, HomePage.class);
	
	WebElement menu=home.getProfileMenu();
	
	menu.click();
	
	home.getLoginBtn().click();
	
    LogIn log=PageFactory.initElements(driver, LogIn.class);
	
	log.getGoogleBtn().click();
	
	String pid = util.switchToNewWindow(driver);
	
	log.getEmailTF().sendKeys(lib.getExcelData("LogIn", 1, 0),Keys.ENTER);
	
	wait.until(ExpectedConditions.elementToBeClickable(log.getPasswordTF()));
	
	
	
	log.getPasswordTF().sendKeys(lib.getExcelData("LogIn", 1, 1),Keys.ENTER);
	
	driver.switchTo().window(pid);

  // HomePage home=PageFactory.initElements(driver, HomePage.class);
	
	try 
	{
		Thread.sleep(10000);
	}
	catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	HomePage hm=PageFactory.initElements(driver, HomePage.class);
	
	hm.getSearchBar().sendKeys(lib.getExcelData("Homepage", 1, 0),Keys.ENTER);
	
	String title=driver.getTitle();
	
	Product pdct=PageFactory.initElements(driver, Product.class);
	
	String count=pdct.getInventoryCount().getText();
	
	Reporter.log(count);
	
	
	driver.navigate().back();
	
	
}

}
