package com.flipkart.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BeautyAndGroomingProductsPage {

	public BeautyAndGroomingProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class,'rs')]")
	private List<WebElement> beautyProductsList;
	
	@FindBy(xpath = "//div[text()='Price -- High to Low']")
	private WebElement priceHighToLowFilter;

	public List<WebElement> getBeautyProductsList() {
		return beautyProductsList;
	}

	public WebElement getPriceHighToLowFilter() {
		return priceHighToLowFilter;
	}
	
}
