package com.teenymeeny.selenium.customreporting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.sun.org.apache.xpath.internal.axes.SelfIteratorNoPredicate;

public class Functions {
	public static void seleniumScreenshot(WebDriver webdriver, String fileWithPath) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);

	}
	
	public static void beforeSuiteMethod() {
		System.out.println("Creation of file before test suite");
		File checkAccess=new File("Filecheck.txt");
		if(checkAccess.isFile()) {
			System.out.println("File created");
		}
	}
	
	
	/**
	 * @author haroon  
	 * @Date 06/02/2021
	 * @param driver WebDriver Instance
	 * @param baseUrl URL of the webpage
	 * @param pageObjectElement page object reference
	 * @return true or false 
	 **/
	public static boolean checkElementExists(WebDriver driver, String baseUrl,By pageObjectElement) throws SeleniumExceptions {
		driver.get(baseUrl);
		WebElement input=null;
		input = driver.findElement(pageObjectElement);
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
	 * @Date 06/13/2021
	 * @return void test-output reports folder is renamed
	 **/
	public static void renameReportsFolder() throws IOException {
		System.out.println(System.getProperty("user.dir")+"\\test-output");
		Path sourceFilePath=Paths.get(System.getProperty("user.dir")+"\\test-output");
		Path targetFilePath=Paths.get(System.getProperty("user.dir")+"\\REFLEXIS_AUTOMATION_"+getDateTimeStamp());
		Files.move(sourceFilePath, targetFilePath);
	}
	
	/**
	 * @author haroon 
	 * @Date 06/13/2021
	 * @return 24 hours time in yyyy-MM-dd-HH-mm-ss format
	 **/
	public static String getDateTimeStamp() {
		String timeStamp = (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()).replace(".", "-"));
		System.out.println("timeStamp "+ timeStamp);
		return timeStamp;
		
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
	
	
	public static void checkingException(WebDriver driver,By pageObjectElement) throws SeleniumExceptions {
		WebElement we=null;
		try {
			we=driver.findElement(pageObjectElement);
		}
		catch(Exception ex) {
			throw new SeleniumExceptions("Test");
		}
	}
	
	
	
	public static void screenShot(WebDriver driver,WebElement webelement, String fileName,String screenshotPath) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        jse.executeScript("arguments[0].style.border='4px solid red'", webelement);
        String screenShotFile = screenshotPath +fileName+".png";
        seleniumScreenshot(driver, screenShotFile);
        Reporter.log("<a href=\"" + screenShotFile + "\">ScreenShot</a>");
	}
	
	

}
