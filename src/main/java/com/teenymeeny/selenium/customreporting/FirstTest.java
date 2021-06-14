package com.teenymeeny.selenium.customreporting;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class FirstTest implements ITestListener {

	public static String baseUrl = "";
	PageObjectReference pageReference = new PageObjectReference();
	public WebDriver driver;

	@BeforeSuite
	public void beforeSuite() throws IOException {
		Functions.beforeSuiteMethod();
		Functions.renameReportsFolder();
		Functions.getDateTimeStamp();
		
	}
	
	@Test
	public void TC001_Enter_Member_Details() throws Exception {
		Reporter.log(baseUrl);
		WebElement firstNameElement = driver.findElement(pageReference.firstName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		firstNameElement.sendKeys("Testing");
		Thread.sleep(5000);
		// Line 30-33 can be replaced with below function
		Functions.enterText(driver, pageReference.firstName, "Testing", 10, 5);
		
		//Similarly can use below function to click element
		Functions.clickElement(driver, pageReference.firstName, 10, 5);	
		
		WebElement lastName = driver.findElement(pageReference.lastName);
		assertEquals(true, firstNameElement.isDisplayed());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='4px solid red'", firstNameElement);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		jse.executeScript("arguments[0].style.border='4px solid red'", lastName);
		String screenShotFile = "C:\\Screenshots\\file.png";
		Functions.seleniumScreenshot(driver, screenShotFile);
		Reporter.log("<a href=\"" + screenShotFile + "\">ScreenShot</a>");
//		driver.switchTo().frame(0).getTitle();

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {

		if (ITestResult.SUCCESS == result.getStatus()) {
			System.out.println("Success");
		} else if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println("Failed");
		}
		driver.quit();

	}

	@BeforeTest
	public void beforeTest() throws InterruptedException, FileNotFoundException, IOException {
		Properties properties=Functions.getProperties(this.getClass().getClassLoader().getResource("Props.properties").getPath());
		System.out.println("key1 is "+ properties.getProperty("key1"));
		
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getClassLoader().getResource("chromedriver.exe").getPath());
		baseUrl = "https://demoqa.com/automation-practice-form";
		System.out.println("BaseUrl is " + baseUrl);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
		driver.get(baseUrl);
		Thread.sleep(2000);
	}
	
	

}
