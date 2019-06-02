package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.DriverManager;

public class SelectablePage extends DriverManager {
	
	private WebDriver driver;
	
	public SelectablePage(WebDriver driver) {
        this.driver = driver;
    }
	
	public final By selectableGrid = By.xpath("//ol[@id = 'selectable']");
	public final By selectableBlocks = By.xpath("//li[@class = 'ui-widget-content ui-selectee']");
	public final By selectedBlock = By.xpath("//li[@class = 'ui-widget-content ui-selectee ui-selected']");
	

}
