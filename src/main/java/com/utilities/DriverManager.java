package com.utilities;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	
	static WebDriver driver;
	

 public static WebDriver getWebDriver() {
	 

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\" +"Webdrivers\\chromedriver.exe" );

        driver = new ChromeDriver();     

        return driver;

}
 
 
 
 @AfterClass
 public void tearDown() 
 {
	 driver.quit();
 }
 
 }
