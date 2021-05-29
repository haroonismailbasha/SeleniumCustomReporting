package com.teenymeeny.selenium.customreporting;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class FirstTest implements ITestListener {
	
	public static String baseUrl="";
	PageObjectReference pageReference=new PageObjectReference();
	
	
	 
  @Test
  public void TC001_Enter_Member_Details() throws InterruptedException {
	  Reporter.log(baseUrl);
	  WebDriver driver=new ChromeDriver();
	  driver.get(baseUrl);
	  Thread.sleep(5000);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  WebElement firstNameElement= driver.findElement(pageReference.firstName);
	  assertEquals(true, firstNameElement.isDisplayed());
	  
  }
  @AfterMethod
  public void afterMethod(ITestResult result) {
	  if(ITestResult.SUCCESS==result.getStatus()) {
		  System.out.println("Success");
	  }
	  else if(ITestResult.FAILURE==result.getStatus()) {
		  System.out.println("Failed");
	  }
	  
  }

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",this.getClass().getClassLoader().getResource("chromedriver.exe").getPath()); 
	  baseUrl="https://demoqa.com/automation-practice-form";
	  System.out.println("BaseUrl is "+ baseUrl);
	  
  }

}
