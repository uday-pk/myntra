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
import com.My.ObjectRepository.Bag;
import com.My.ObjectRepository.HomePage;
import com.My.ObjectRepository.LogIn;

@Listeners(com.My.GenericLib.ListenerImp.class)
public class Verify_the_user_is_able_to_check_the_bag extends Base {
@Test
public void bag()
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
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.switchTo().window(pid);
	
	home.getBag().click();
	
	Bag bg=PageFactory.initElements(driver, Bag.class);
	
	String empMsg = bg.getEmptymessage().getText();
	
	Assert.assertEquals(empMsg, "There is nothing in your bag. Let's add some items.");
	
	Reporter.log("empty bag messagre is displayed");
	
	driver.navigate().back();
	
}
}
