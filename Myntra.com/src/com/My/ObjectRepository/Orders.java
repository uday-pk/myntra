package com.My.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Orders {
	@FindBy(xpath="//div[@class='error-primaryMessage']")
	private WebElement errorMsg;
	
	public WebElement getErrorMsg()
	{
		return errorMsg;
	}
}
