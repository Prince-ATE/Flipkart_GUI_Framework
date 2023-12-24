package com.flipkart.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KurtasForMenPage {

	public KurtasForMenPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class,'IRpwTa')]")
	private List<WebElement> selectKurta;

	public List<WebElement> getSelectKurta() {
		return selectKurta;
	}
	
}
