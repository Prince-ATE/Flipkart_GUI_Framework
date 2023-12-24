package com.flipkart.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='Remove']")
	private WebElement removeButton;

	@FindBy(xpath = "//a[contains(@class,'gBNbID')]")
	private List<WebElement> cartItemsList;
	
	public WebElement getRemoveButton() {
		return removeButton;
	}

	public List<WebElement> getCartItemsList() {
		return cartItemsList;
	}
	
}
