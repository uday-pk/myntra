package com.My.GenericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.My.ObjectRepository.HomePage;
import com.My.ObjectRepository.LogIn;

public class Base {
public static WebDriver scrndriver;
public FileLib lib=new FileLib();
public FileUtil util=new FileUtil();
public WebDriver driver;

public WebDriverWait wait;

@BeforeClass
	public void configBC()
	 {
		if(lib.getPropertyKeyvalue("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
			driver=new ChromeDriver();
			
			scrndriver=driver;
		}
		else 
		{
			System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
			driver=new FirefoxDriver();
			scrndriver=driver;
		}
		driver.manage().window().maximize();
		driver.navigate().to(lib.getPropertyKeyvalue("url"));
		String url=driver.getCurrentUrl();
		
		Assert.assertEquals(url, "https://www.myntra.com/");
		Reporter.log("Myntra website is opened");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 30);
	 }

@BeforeMethod
public void configBM()
{
//HomePage home=PageFactory.initElements(driver, HomePage.class);
//	
//	WebElement menu=home.getProfileMenu();
//	
//	menu.click();
//	
//	home.getLoginBtn().click();
//	
//    LogIn log=PageFactory.initElements(driver, LogIn.class);
//	
//	log.getGoogleBtn().click();
//	
//	String pid = util.switchToNewWindow(driver);
//	
//	log.getEmailTF().sendKeys(lib.getExcelData("LogIn", 1, 0),Keys.ENTER);
//	
//	wait.until(ExpectedConditions.elementToBeClickable(log.getPasswordTF()));
//	
//	try {
//		Thread.sleep(10000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	log.getPasswordTF().sendKeys(lib.getExcelData("LogIn", 1, 1),Keys.ENTER);
//	
//	//driver.switchTo().window(pid);
	
	
}

@AfterMethod
public void configAM()
{
HomePage home=PageFactory.initElements(driver, HomePage.class);

home.getProfileMenu().click();

home.getLogout().click();

Reporter.log("Succesfully logged out");
}


@AfterClass
public void configAC()
{
	
	driver.quit();
}
}
