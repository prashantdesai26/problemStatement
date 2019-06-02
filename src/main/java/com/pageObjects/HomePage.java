package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utilities.*;


public class HomePage extends DriverManager {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
        this.driver = driver;
    }
	
	public final By homeTab = By.xpath("//a[@title = 'Home' and contains(@href,'demoqa.com')]");
	public final By accordionlink = By.xpath("//a[contains(@href,'demoqa.com/accordion/')]");
	public final By draggablelink = By.xpath("//a[contains(@href,'demoqa.com/draggable/')]");
	public final By droppablelink = By.xpath("//a[contains(@href,'demoqa.com/droppable/')]");
	public final By selectablelink = By.xpath("//a[contains(@href,'demoqa.com/selectable/')]");
	public final By dateSelectorlink = By.xpath("//a[contains(@href,'demoqa.com/datepicker/')]");
	
	
	

}
