package com.flipkart.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='B_NuCI']")
	private WebElement productName;
	
	@FindBy(xpath = "//a[text()='S']")
	private WebElement size_S;
	
	@FindBy(xpath = "//a[text()='M']")
	private WebElement size_M;
	
	@FindBy(xpath = "//a[text()='L']")
	private WebElement size_L;
	
	@FindBy(xpath = "//a[text()='XL']")
	private WebElement size_XL;
	
	@FindBy(xpath = "//a[text()='XXL']")
	private WebElement size_XXL;
	
	@FindBy(xpath = "//button[text()='Add to cart']")
	private WebElement addToCartButton;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSize_S() {
		return size_S;
	}

	public WebElement getSize_M() {
		return size_M;
	}

	public WebElement getSize_L() {
		return size_L;
	}

	public WebElement getSize_XL() {
		return size_XL;
	}

	public WebElement getSize_XXL() {
		return size_XXL;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}
}
