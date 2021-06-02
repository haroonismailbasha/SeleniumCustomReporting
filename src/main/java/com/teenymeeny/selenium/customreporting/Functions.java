package com.teenymeeny.selenium.customreporting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Functions {
	public static void seleniumScreenshot(WebDriver webdriver, String fileWithPath) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);

	}
	/**
	 * @author haroon  
	 * @Date 06/02/2021
	 * @param driver WebDriver Instance
	 * @param baseUrl URL of the webpage
	 * @param pageObjectElement page object reference
	 * @return true or false 
	 **/
	public static boolean checkElementExists(WebDriver driver, String baseUrl,By pageObjectElement) {
		driver.get(baseUrl);
		WebElement input = driver.findElement(pageObjectElement);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return input.isDisplayed();
	}
	
	
	/**
	 * @author haroon
	 * @Date 06/02/2021
	 * @param driver WebDriver Instance
	 * @param pageObjectElement page object reference
	 * @param waitTime implicit wait time in seconds
	 * @return sleepTimeInSeconds Thread sleep, 0 if NA 
	 **/
	
	public static void clickElement(WebDriver driver,By pageObjectElement,int waitTime,int sleepTimeInSeconds) throws InterruptedException {
		WebElement webElement=driver.findElement(pageObjectElement);
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		webElement.click();
		Thread.sleep(sleepTimeInSeconds*1000);
		
	}
	
	/**
	 * @author haroon 
	 * @Date 06/02/2021
	 * @param driver WebDriver Instance
	 * @param pageObjectElement page object reference
	 * @param inputText Text to enter the field, it can be two doublequotes if blank
	 * @param waitTime implicit wait time in seconds
	 * @return sleepTimeInSeconds Thread sleep, 0 if NA 
	 **/
	
	public static void enterText(WebDriver driver,By pageObjectElement,String inputText,int waitTime,int sleepTimeInSeconds) throws InterruptedException {
		WebElement webElement=driver.findElement(pageObjectElement);
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		webElement.sendKeys(inputText);
		Thread.sleep(sleepTimeInSeconds*1000);
	}
	
	/**
	 * @author haroon 
	 * @Date 06/02/2021
	 * @param propertiesPath provide String for path including file name.
	 **/
	public static Properties getProperties(String propertiesPath) throws FileNotFoundException, IOException {
		Properties properties=new Properties();
		properties.load(new FileReader(new File(propertiesPath)));
		return properties;
	}
	
	

}
