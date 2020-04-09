package com.My.MyntraScripts;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.My.GenericLib.Base;
import com.My.ObjectRepository.HomePage;
import com.My.ObjectRepository.LogIn;
@Listeners(com.My.GenericLib.ListenerImp.class)
public class Verify_user_is_able_to_login_through_google_account extends Base {
@Test
public void orders() throws Exception
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
	
	
	
	
	
	
	
}
}
