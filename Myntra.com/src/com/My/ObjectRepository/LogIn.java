package com.My.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.My.GenericLib.Base;
import com.My.GenericLib.FileLib;
import com.My.GenericLib.FileUtil;

public class LogIn extends Base{
	

	
	
	@FindBy(xpath="//button[@id='gPlusLogin']")
	private WebElement googleBtn;
	
	public WebElement getGoogleBtn()
	{
		return googleBtn;
	}
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement emailTF;
	
	public WebElement getEmailTF()
	{
		return emailTF;
	}
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTF;
	
	public WebElement getPasswordTF()
	{
		return passwordTF;
	}
	
	}
