package com.flipkart.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobilesPage {

	public MobilesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='Brand']")
	private WebElement brandFilter;
	
	@FindBy(xpath = "//div[text()='Brand']/../..//div[text()='SAMSUNG']")
	private WebElement samsungFilter;
	
	@FindBy(xpath = "//div[text()='RAM']")
	private WebElement ramFilter;
	
	@FindBy(xpath = "//div[text()='RAM']/../..//div[text()='4 GB']")
	private WebElement _4GBRamFilter;
	
	@FindBy(xpath = "//div[text()='Battery Capacity']")
	private WebElement batteryCapacityFilter;
	
	@FindBy(xpath = "//div[text()='Battery Capacity']/../..//div[text()='4000 - 4999 mAh']")
	private WebElement _4000_4999_mAhFilter;
	
	@FindBy(xpath = "(//div[contains(@class,'FdLqY')])[2]")
	private WebElement priceController;

	@FindBy(xpath = "//div[contains(@class,'rR')]")
	private List<WebElement> mobilesList;
	
	public WebElement getBrandFilter() {
		return brandFilter;
	}

	public WebElement getSamsungFilter() {
		return samsungFilter;
	}

	public WebElement getRamFilter() {
		return ramFilter;
	}

	public WebElement get_4GBRamFilter() {
		return _4GBRamFilter;
	}

	public WebElement getBatteryCapacityFilter() {
		return batteryCapacityFilter;
	}

	public WebElement get_4000_4999_mAhFilter() {
		return _4000_4999_mAhFilter;
	}

	public WebElement getPriceController() {
		return priceController;
	}

	public List<WebElement> getMobilesList() {
		return mobilesList;
	}
}
