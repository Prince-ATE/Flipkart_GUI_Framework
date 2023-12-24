package com.flipkart.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.flipkart.generic.basetest.Base_Class;
import com.flipkart.generic.listenerutility.ListImpClass;
import com.flipkart.objectrepositoryutility.KurtasForMenPage;
import com.flipkart.objectrepositoryutility.WelcomePage;

@Listeners(com.flipkart.generic.listenerutility.ListImpClass.class)
public class TC_01_Test extends Base_Class {

	@Test
	public void fetchPriceOfMensKurta() throws InterruptedException {
		
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.getCrossButton().click();
			
		Assert.assertEquals(welcomePage.getFashionTab().isDisplayed(), true);
		ListImpClass.test.log(Status.INFO, "Navigated to Welcome page");
		
		//Move cursor to Fashion tab
		utility.mousemoveOnElement(driver, welcomePage.getFashionTab());
		
		//move cursor to Men's Kurtas section and click
		utility.mousemoveOnElement(driver, welcomePage.getMensKurtaLink());
		welcomePage.getMensKurtaLink().click();
		ListImpClass.test.log(Status.INFO, "Navigated to Men's Kurtas page");
		
		//Click on any one of the Kurta
		KurtasForMenPage kurtasForMen = new KurtasForMenPage(driver);
		String kurtaName = kurtasForMen.getSelectKurta().get(3).getText();
		kurtasForMen.getSelectKurta().get(3).click();
		utility.switchToTabOnTitle(driver, kurtaName);
		ListImpClass.test.log(Status.INFO, "Navigated to specific Kurta page");
		
		//Fetch the price
		String xpath = "//span[text()='"+kurtaName+"']/../../../..//div[contains(@class,'jeq')]";
		ListImpClass.test.log(Status.INFO, "Product Price : "+driver.findElement(By.xpath(xpath)).getText());
		ListImpClass.test.addScreenCaptureFromBase64String("./screenshots/screenshot1.png");
	}
}
