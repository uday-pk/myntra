package com.My.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(className="desktop-searchBar")
	private WebElement searchBar;

	public WebElement getSearchBar() {
		return searchBar;
	}
	
	@FindBy(xpath="//span[@class='myntraweb-sprite desktop-iconUser sprites-headerUser']")
	private WebElement profileMenu;
	
	public WebElement getProfileMenu()
	{
		return profileMenu;
	}
	
	@FindBy(xpath="//a[text()='log in']")
	private WebElement loginBtn;
	
	public WebElement getLoginBtn()
	{
		return loginBtn;
		
	}
	
	@FindBy(xpath="//div[@class='desktop-infoSection' and text()='Orders']")
	private WebElement orders;
	
	public WebElement getOrders()
	{
		return orders;
	}
	
	@FindBy(xpath="//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")
	private WebElement bag;
	
	public WebElement getBag()
	{
		return bag;
	}
	
	@FindBy(xpath="(//li[@class='product-base'])[1]")
	private WebElement whlPdct;
	
	public WebElement getWhlPdct()
	{
		return whlPdct;
	}
	
	@FindBy(xpath="(//span[@class='product-actionsButton product-wishlist product-prelaunchBtn'])[1]")
	private WebElement wishbtn;
	
	public WebElement getWishBtn()
	{
		return wishbtn;
	}
	
	@FindBy(xpath="//div[text()=' Logout ']")
	private WebElement logout;
	
	public WebElement getLogout()
	{
		return logout;
	}
}
