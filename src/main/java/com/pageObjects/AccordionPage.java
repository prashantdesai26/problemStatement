package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.DriverManager;

public class AccordionPage extends DriverManager {
	
	private WebDriver driver;
	
	public AccordionPage(WebDriver driver) {
        this.driver = driver;
    }
	
	public final By accordiancollapsepresent = By.xpath("//h3[contains(@id,'ui-id-')]");
	public final By accordioncollapsed = By.xpath("//h3[contains(@class,'active ui-state-active')]");
	public final By accordionText = By.xpath("//div[contains(@class,'accordion-content-active')]");
	public final By accordionTextCheck  = By.xpath("//div[contains(@class,'accordion-content-active')]//p[contains(text(),'')]");
	

}
