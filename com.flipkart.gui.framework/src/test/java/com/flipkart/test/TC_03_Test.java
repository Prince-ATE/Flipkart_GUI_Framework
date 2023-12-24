package com.flipkart.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.flipkart.generic.basetest.Base_Class;
import com.flipkart.generic.listenerutility.ListImpClass;
import com.flipkart.objectrepositoryutility.BeautyAndGroomingProductsPage;
import com.flipkart.objectrepositoryutility.WelcomePage;

@Listeners(com.flipkart.generic.listenerutility.ListImpClass.class)
public class TC_03_Test extends Base_Class {

	@Test
	public void fetchAllTheProductDetails() throws Throwable {
		
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getCrossButton().click();
			
		Assert.assertEquals(welcomePage.getFashionTab().isDisplayed(), true);
		ListImpClass.test.log(Status.INFO, "Navigated to Welcome page");
		
		//Move cursor to Beauty, Toy & More tab
		Actions action = new Actions(driver);
		action.moveToElement(welcomePage.getFashionTab()).perform();
		Thread.sleep(2000);
		action.moveToElement(welcomePage.getBeautyToysMoreTab()).perform();
		action.moveToElement(welcomePage.getBeautyToysMoreTab()).perform();
		
		//move cursor to View All option
		action.moveToElement(welcomePage.getViewAllLink()).click().perform();
		ListImpClass.test.log(Status.INFO, "Navigated to Beauty and Grooming Products page");
		
		//Provide filter
		BeautyAndGroomingProductsPage beautyPage = new BeautyAndGroomingProductsPage(driver);
		beautyPage.getPriceHighToLowFilter().click();
		Thread.sleep(2000);
		
		//Fetch all the product details
		String s = "";
		int count = 1;
		for (WebElement element : beautyPage.getBeautyProductsList()) {
			
			s = s+" "+count+" = "+element.getText()+" || ";
			count++;
			
		}
		ListImpClass.test.log(Status.INFO, "Product Names = "+s);
	}
}
