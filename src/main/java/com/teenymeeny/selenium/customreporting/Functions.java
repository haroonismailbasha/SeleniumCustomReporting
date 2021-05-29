package com.teenymeeny.selenium.customreporting;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Functions {
	public static void seleniumScreenshot(WebDriver webdriver,String fileWithPath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                File DestFile=new File(fileWithPath);
                FileUtils.copyFile(SrcFile, DestFile);

    }
	public static boolean checkElementExists(WebDriver driver,String baseUrl,String relativeXpath) {
		driver.get(baseUrl);
		WebElement input= driver.findElement(By.xpath(relativeXpath));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return input.isDisplayed();
	}
	
	public static String returnAString(String MyName) {
		return MyName;
	}
}
