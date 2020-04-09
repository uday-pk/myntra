package com.My.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDescription {

	@FindBy(xpath="//div[contains(@class,' pdp-add-to-wis')]")
	private WebElement wishlist;
	
	public WebElement getWishList()
	{
		return wishlist;
	}
}
