package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pageObjects.HomePage;

public class commonFunctions extends DriverManager {
	
	private WebDriver driver;
	private HomePage home;
	
	
	public commonFunctions(WebDriver driver) {
        this.driver = driver;
    }
	
	
	public void hitURL()
	{
		home = new HomePage(driver);
		driver.get("https://demoqa.com");
		WebElement element = driver.findElement(home.homeTab);
	     explicitWait(element);
		if (driver.findElement(By.xpath("//a[@title = 'Home' and contains(@href,'demoqa.com')]")).isDisplayed())
		{
			Assert.assertEquals("True","True","Home Page appeared");
			driver.manage().window().maximize();
		}
		
		else
		{
			Assert.assertEquals("True","False","Home page did not appear");
		}
		
		
	}
	
	public void explicitWait(WebElement Element)
	{
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(Element));
	}
	
}
