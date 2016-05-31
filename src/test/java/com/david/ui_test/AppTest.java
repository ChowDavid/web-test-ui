package com.david.ui_test;

import java.util.concurrent.TimeUnit;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;



/**
 * Unit test for simple App.
 */
public class AppTest{
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    //driver = new FirefoxDriver();
		driver = new HtmlUnitDriver();
	    //baseUrl = "http://localhost:18080";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testWebdriver() throws Exception {
	    driver.get(baseUrl + "/web-test/");
	    driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("David");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("123");
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	    try {
	    	driver.wait(2000);
	    } catch (Exception e){}
	    System.out.println(driver.getPageSource());
	    assertTrue(driver.getPageSource().contains("Served at: Hello 123 David /web-test"));
	  }
	  
	  @Test
	  public void testWebdriver1() throws Exception {
	    driver.get(baseUrl + "/web-test/");
	    driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("123");
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	    try {
	    	driver.wait(2000);
	    } catch (Exception e){}
	    System.out.println(driver.getPageSource());
	    assertTrue(driver.getPageSource().contains("Served at: Hello 123  /web-test"));
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
