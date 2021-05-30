package com.teenymeeny.selenium.customreporting;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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
import org.testng.annotations.BeforeTest;

public class FirstTest implements ITestListener {

	public static String baseUrl = "";
	PageObjectReferenceFramework pageReference = new PageObjectReferenceFramework();
	public WebDriver driver;

	@Test
	public void TC001_Enter_Member_Details() throws Exception {
		Reporter.log(baseUrl);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement firstNameElement = driver.findElement(pageReference.firstName);
		WebElement lastName = driver.findElement(pageReference.lastName);
		assertEquals(true, firstNameElement.isDisplayed());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='4px solid red'", firstNameElement);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		jse.executeScript("arguments[0].style.border='4px solid red'", lastName);
		String screenShotFile = "C:\\Screenshots\\file.png";
		Functions.seleniumScreenshot(driver, screenShotFile);
		Reporter.log("<a href=\"" + screenShotFile + "\">ScreenShot</a>");

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
	public void beforeTest() throws InterruptedException {
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
