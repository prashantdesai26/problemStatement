package testsValidation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageObjects.AccordionPage;
import com.pageObjects.Datepickerpage;
import com.pageObjects.HomePage;
import com.utilities.DriverManager;
import com.utilities.commonFunctions;

public class Datepicker extends DriverManager{
	
	
		
		private WebDriver driver;
		private HomePage home;
		private commonFunctions functions;
		private Datepickerpage dateselector;
		
		@BeforeClass
		public void setUp() {
			driver=getWebDriver();

			}
		
		@Test(priority = 1)
		public void clickDatePickerlink()
		{
			home = new HomePage(driver);
			functions = new commonFunctions(driver);
			functions.hitURL();
			//driver.findElement(home.accordionlink).click();
			WebElement element = driver.findElement(home.dateSelectorlink);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
			
		}
		
		@Test(priority = 2)
		public void clickdateselectorbox()
		{
			functions = new commonFunctions(driver);
			dateselector = new Datepickerpage(driver);
			
			WebElement datepicker = driver.findElement(dateselector.dateselectorbox);
			functions.explicitWait(datepicker);
			if (datepicker.isDisplayed())
			{
				Assert.assertEquals("True","True","Date Selector box displayed");
			}
			
			else
			{
				Assert.assertEquals("False", "True","Date selector box did not display");
			}
		}
		
		@Test(priority = 3)
		public void checkCalenderGrid()
		{
			dateselector = new Datepickerpage(driver);	
			WebElement datepicker = driver.findElement(dateselector.dateselectorbox);
			datepicker.click();		
			WebElement monthGrid = driver.findElement(dateselector.Dategrid);
			if (monthGrid.isDisplayed())
			{
				Assert.assertEquals("True","True","Date Selector Grid displayed");
			}
			
			else
			{
				Assert.assertEquals("False","True","Date Selector Grid not displayed");
			}
		}
		
		
		@Test(priority = 4)
		public void selectDate()
		{
			dateselector = new Datepickerpage(driver);			
			
			WebElement datepicker = driver.findElement(dateselector.dateselectorbox);
			datepicker.click();
			
			if (datepicker.isDisplayed())
			{
				Assert.assertEquals("True","True","Date Selector box displayed");
				WebElement monthGrid = driver.findElement(dateselector.Dategrid);
				if (monthGrid.isDisplayed())
				{
					WebElement monthNext = driver.findElement(dateselector.clickNextMonth);
					monthNext.click();
					
					WebElement dateselect = driver.findElement(dateselector.selectDate);
					dateselect.click();
					
					String textInBox = datepicker.getText();
					
					if(textInBox.contains("/"))
					{
						Assert.assertEquals("True","True","Date selected successfully");
					}
					
				}
				
			}
			
			else
			{
				Assert.assertEquals("False", "True","Date selector box did not display");
			}
		}
		
		@AfterClass
		public void tearDown() 
		 {
			 driver.quit();
		 }

}
