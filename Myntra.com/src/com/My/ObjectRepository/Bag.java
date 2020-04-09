package com.My.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Bag {

	@FindBy(xpath="//div[@class='emptyCart-base-emptyDesc']")
	private WebElement emptyMsg;
	
	public WebElement getEmptymessage()
	{
		return emptyMsg;
	}
}
