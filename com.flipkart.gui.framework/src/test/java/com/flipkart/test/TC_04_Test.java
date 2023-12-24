package com.flipkart.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.flipkart.generic.basetest.Base_Class;
import com.flipkart.objectrepositoryutility.CartPage;
import com.flipkart.objectrepositoryutility.MobilesPage;
import com.flipkart.objectrepositoryutility.ProductPage;
import com.flipkart.objectrepositoryutility.WelcomePage;

public class TC_04_Test extends Base_Class {

	@Test
	public void checkingCart() throws InterruptedException {
		
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getCrossButton();
		
		//Searching iphone
		String searchItem = "Iphone";
		welcomePage.getSearchTextField().sendKeys(searchItem,Keys.ENTER);
		MobilesPage mobiles = new MobilesPage(driver);
		
		//Adding 5 iphones into the cart
		for (int i = 0; i < 5; i++) {
			String title = mobiles.getMobilesList().get(i).getText();
			mobiles.getMobilesList().get(i).click();
			utility.switchToTabOnTitle(driver, title);
			ProductPage product = new ProductPage(driver);
			product.getAddToCartButton().click();
			driver.close();
			utility.switchToTabOnTitle(driver, searchItem);
		}
		//Navigating to Cart page
		driver.navigate().back();
		Thread.sleep(2000);
		welcomePage.getCrossButton().click();;
		welcomePage.getCartLink().click();
		
		//Removing items based on price 
		CartPage cartPage = new CartPage(driver);
		for (WebElement element : cartPage.getCartItemsList()) {
				String productName = element.getText();
				String priceXpath = "(//a[text()='"+productName+"']/ancestor::div)[11]/descendant::span[contains(@class,'WpvJ')]";
				String price = driver.findElement(By.xpath(priceXpath)).getText();
				System.out.println(price);
			}
		}
	}