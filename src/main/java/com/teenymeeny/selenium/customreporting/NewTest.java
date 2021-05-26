package com.teenymeeny.selenium.customreporting;

import org.testng.annotations.Test;

import java.net.URISyntaxException;
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
	  
	  String relativexpath="//*[@id=\"firstName\"]";
	  System.setProperty("webdriver.chrome.driver",this.getClass().getClassLoader().getResource("chromedriver.exe").getPath());
	  System.out.println("path is "+System.getProperty("webdriver.chrome.driver"));
	  WebDriver driver=new ChromeDriver();
	  String baseUrl = "https://demoqa.com/automation-practice-form";
	  driver.get(baseUrl);
	  String title=driver.getTitle();
	  Reporter.log("Title is "+ title);
	  System.out.println("Title is "+title);
	  Thread.sleep(10000);
	  WebElement input= driver.findElement(By.xpath(relativexpath));
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Reporter.log(String.valueOf(input.isDisplayed()));
	  driver.quit();
	  }
  

}
