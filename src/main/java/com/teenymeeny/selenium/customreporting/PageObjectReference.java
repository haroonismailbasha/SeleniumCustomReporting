package com.teenymeeny.selenium.customreporting;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectReference {
	ChromeDriver driver;
	By firstName = By.xpath("//*/input[@id='firstName']");
	By lastName = By.xpath("//*/input[@id='lastName']");
}
