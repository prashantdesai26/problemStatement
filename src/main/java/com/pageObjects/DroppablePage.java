package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.DriverManager;

public class DroppablePage extends DriverManager{
	
private WebDriver driver;
	
	public DroppablePage(WebDriver driver) {
        this.driver = driver;
    }
	
	public final By dragElement = By.xpath("//div[@id = 'draggable']");
	public final By dropElement = By.xpath("//div[@id = 'droppable']");
//	public final By dropElementPostDrop = By.xpath("//div[@class = 'ui-widget-header ui-droppable ui-state-highlight']//p[contains(text(),'dropped')]");
	//public final By nonTargetElement = By.xpath("//div[@id = 'droppable']");

}
