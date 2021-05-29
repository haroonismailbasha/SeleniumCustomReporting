package com.teenymeeny.selenium.customreporting;

import org.testng.annotations.Test;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

public class NewTest {
	@Test
	public void f() throws Exception {
		System.out.println("Custom Reporting");

		By Checking = By.xpath("//*[@id=\\\"firstName\\\"]");
		By Checking2 = By.xpath("//*[@id=\\\"firstName\\\"]");

		String relativexpath = "//*[@id=\"firstName\"]";
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getClassLoader().getResource("chromedriver.exe").getPath());
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://demoqa.com/automation-practice-form";
		WebElement input = driver.findElement(By.xpath(relativexpath));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log(String.valueOf(input.isDisplayed()));

//	  driver.findElement(Test).isDisplayed();

		System.exit(1);
		Functions.checkElementExists(driver, baseUrl, relativexpath);
		Reporter.log(String.valueOf(Functions.checkElementExists(driver, baseUrl, relativexpath)));
//	  String baseUrl = "https://demoqa.com/automation-practice-form";
//	  driver.get(baseUrl);
//	  String title=driver.getTitle();
//	  Reporter.log("Title is "+ title);
//	  Thread.sleep(10000);

		driver.quit();
	}

}
