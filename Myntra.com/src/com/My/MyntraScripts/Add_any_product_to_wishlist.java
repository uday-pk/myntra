package com.My.MyntraScripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.My.GenericLib.Base;
import com.My.ObjectRepository.HomePage;
import com.My.ObjectRepository.LogIn;
import com.My.ObjectRepository.Product;
import com.My.ObjectRepository.ProductDescription;
@Listeners(com.My.GenericLib.ListenerImp.class)
public class Add_any_product_to_wishlist extends Base {
@Test
public void wishlist()
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
	
	Reporter.log("Succesfully loggedin");
	
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
	
	home.getSearchBar().sendKeys(lib.getExcelData("Homepage", 2, 0),Keys.ENTER);
	
	WebElement product = home.getWhlPdct();
	Actions act=new Actions(driver);
	
	act.moveToElement(product).perform();
	
	home.getWishBtn().click();
	

	
	driver.navigate().back();
//	Product pdct=PageFactory.initElements(driver, Product.class);
//	
//	pdct.getPrdctImg().click();
//	
//	String parent = util.switchToNewWindow(driver);
//	
//	ProductDescription desc=PageFactory.initElements(driver, ProductDescription.class);
//	
//	desc.getWishList().click();
//	desc.getWishList().click();
//
//	driver.switchTo().window(parent);
}
}
