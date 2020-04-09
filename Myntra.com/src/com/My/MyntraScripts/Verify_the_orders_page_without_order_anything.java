package com.My.MyntraScripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.My.GenericLib.Base;
import com.My.ObjectRepository.HomePage;
import com.My.ObjectRepository.LogIn;
import com.My.ObjectRepository.Orders;
@Listeners(com.My.GenericLib.ListenerImp.class)
public class Verify_the_orders_page_without_order_anything extends Base {

	@Test
	public void orders()
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

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.switchTo().window(pid);
		
		//HomePage home=PageFactory.initElements(driver, HomePage.class);
		wait.until(ExpectedConditions.elementToBeClickable(home.getProfileMenu()));
		home.getProfileMenu().click();
		
		home.getOrders().click();
		
		Orders ord=PageFactory.initElements(driver, Orders.class);
		
		String actError = ord.getErrorMsg().getText();
		
		Assert.assertEquals(actError, "NO ACTIVE ORDERS");
		
		Reporter.log("error message is dispalyed");
		
		driver.navigate().back();
	}
}
