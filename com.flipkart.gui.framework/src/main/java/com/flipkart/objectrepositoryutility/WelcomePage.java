package com.flipkart.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Login")
	private WebElement loginLink;

	@FindBy(xpath = "//a[text()='Cart']")
	private WebElement cartLink;
	
	@FindBy(xpath = "//span[text()='Fashion']")
	private WebElement FashionTab;

	@FindBy(linkText = "Men's Kurtas")
	private WebElement mensKurtaLink;

	@FindBy(xpath = "//span[text()='Beauty, Toys & More']")
	private WebElement beautyToysMoreTab;

	@FindBy(xpath = "//a[text()='View All']")
	private WebElement viewAllLink;

	@FindBy(xpath = "//input[@name='q']")
	private WebElement searchTextField;
	
	@FindBy(xpath = "//span[contains(@class,'XB')]")
	private WebElement crossButton;

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getFashionTab() {
		return FashionTab;
	}

	public WebElement getMensKurtaLink() {
		return mensKurtaLink;
	}

	public WebElement getBeautyToysMoreTab() {
		return beautyToysMoreTab;
	}

	public WebElement getViewAllLink() {
		return viewAllLink;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getCrossButton() {
		return crossButton;
	}

	public WebElement getCartLink() {
		return cartLink;
	}
	
}
