package com.teenymeeny.selenium.customreporting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class learning {
  @Test
  public void f() {
	  System.out.println("Im actual test");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Checking before test");
  }

}
