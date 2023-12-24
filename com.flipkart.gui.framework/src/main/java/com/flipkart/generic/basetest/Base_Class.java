package com.flipkart.generic.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.flipkart.generic.fileutility.FileUtility;
import com.flipkart.generic.javascriptutility.JavaScriptUtility;
import com.flipkart.generic.webdriverutility.JavaUtility;
import com.flipkart.generic.webdriverutility.WebDriverUtility;

public class Base_Class {

	public FileUtility fLib = new FileUtility();
	public WebDriverUtility utility = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
	public JavaScriptUtility jsUtility = new JavaScriptUtility();
	public WebDriver driver;
	public static WebDriver sDriver;
	
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void openBrowser() throws Throwable {
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		
		String URL = fLib.getDataFromPropertiesFile("url");
		if (BROWSER.equals("chrome")) {
			System.out.println("=====> Chrome Browser Launched Successfully <=====");
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("=====> Firefox Browser Launched Successfully <=====");
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
			System.out.println("=====> Edge Browser Launched Successfully <=====");
		} else {
			driver = new ChromeDriver();
			System.out.println("=====> Default Browser i.e. Chrome Launched Successfully <=====");
		}
		driver.manage().window().maximize();
		driver.get(URL);
		utility.waitForPageToLoad(driver);
		sDriver = driver;
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		System.out.println("=====> Browser Closed Successfully <=====");
	}
}
