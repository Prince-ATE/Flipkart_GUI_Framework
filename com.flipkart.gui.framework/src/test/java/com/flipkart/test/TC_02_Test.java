package com.flipkart.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.flipkart.generic.basetest.Base_Class;
import com.flipkart.generic.listenerutility.ListImpClass;
import com.flipkart.objectrepositoryutility.MobilesPage;
import com.flipkart.objectrepositoryutility.ProductPage;
import com.flipkart.objectrepositoryutility.WelcomePage;

@Listeners(com.flipkart.generic.listenerutility.ListImpClass.class)
public class TC_02_Test extends Base_Class {

	@Test
	public void fetchProductDetails() throws Throwable {
		
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getCrossButton().click();
		Assert.assertEquals(welcomePage.getFashionTab().isDisplayed(), true);
		ListImpClass.test.log(Status.INFO, "Navigated to Welcome page");

		//Search for a product
		String PRODUCT = fLib.getDataFromPropertiesFile("search");
		welcomePage.getSearchTextField().sendKeys(PRODUCT, Keys.ENTER);
		ListImpClass.test.log(Status.INFO, "Navigated to Mobiles page");

		//Add filter's
		MobilesPage mobilesPage = new MobilesPage(driver);
		jsUtility.scrollIntoViewTop(driver, mobilesPage.getBrandFilter());
		Thread.sleep(2000);
		mobilesPage.getSamsungFilter().click();
		
		jsUtility.scrollIntoViewTop(driver, mobilesPage.getRamFilter());
		Thread.sleep(2000);
		mobilesPage.get_4GBRamFilter().click();
		
		jsUtility.scrollIntoViewTop(driver, mobilesPage.getBatteryCapacityFilter());
		Thread.sleep(2000);
		mobilesPage.getBatteryCapacityFilter().click();
		mobilesPage.get_4000_4999_mAhFilter().click();	
		Thread.sleep(2000);
		
		//Click on the 1st product
		mobilesPage.getMobilesList().get(0).click();
		String title = mobilesPage.getMobilesList().get(0).getText();
		ListImpClass.test.log(Status.INFO, "Navigated to specific Mobile page");
		utility.switchToTabOnTitle(driver, title);
		
		//Fetch the product details
		ProductPage products = new ProductPage(driver);
		ListImpClass.test.log(Status.INFO, "Product Name : "+products.getProductName().getText());
		
		String priceXpath = "//span[@class='B_NuCI']/../../../..//div[contains(@class,'jeq')]";
		ListImpClass.test.log(Status.INFO, "Product Price : "+driver.findElement(By.xpath(priceXpath)).getText());
		
		String discountXPath = "//span[@class='B_NuCI']/../../../..//div[contains(@class,'Dcoz')]";
		ListImpClass.test.log(Status.INFO, "Product Discount Percetage  : "+driver.findElement(By.xpath(discountXPath)).getText());
	}
}
