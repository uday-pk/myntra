package com.My.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product {

	@FindBy(xpath="(//h3[text()='H&M']/following-sibling::h4[text()='Cotton T-shirt Regular Fit']/parent::div[@class='product-productMetaInfo']//div)[1]//span")
	private WebElement productPrice;
	
	public WebElement getPrice()
	{
		return productPrice;
		
	}
	
	@FindBy(xpath="//span[@class='title-count']")
	private WebElement inventoryCount;
	
	public WebElement getInventoryCount()
	{
		return inventoryCount;
	}
	
	
	@FindBy(xpath="//span[@class='product-actionsButton product-wishlist product-prelaunchBtn']")
	private WebElement wishlist;
	
	public WebElement getWishlist()
	{
		return wishlist;
	}
	
	@FindBy(xpath="(//h3[text()='FOREVER 21'])[1]")
	private WebElement product;
	
	public WebElement getProduct()
	{
		return product;
	}
	
	@FindBy(xpath="//img[@alt='FOREVER 21 Women Mustard Yellow Solid Puffer Jacket']")
	private WebElement prdctImg;
	
	public WebElement getPrdctImg()
	{
		return prdctImg;
	}
	
	
}
