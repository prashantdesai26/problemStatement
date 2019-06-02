package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.DriverManager;

public class Datepickerpage extends DriverManager {

private WebDriver driver;
	
	public Datepickerpage(WebDriver driver) {
        this.driver = driver;
    }
	
	public final By dateselectorbox = By.xpath("//input[@id = 'datepicker']");
	public final By Dategrid = By.xpath("//div[@id = 'ui-datepicker-div']");
	public final By clickNextMonth = By.xpath("//a[@class = 'ui-datepicker-next ui-corner-all']");
	public final By selectDate = By.xpath("//td[@data-handler = 'selectDay']");
	
}
