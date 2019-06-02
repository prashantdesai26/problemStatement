package testsValidation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pageObjects.AccordionPage;
import com.pageObjects.HomePage;
import com.utilities.DriverManager;
import com.utilities.ExtentTestManager;
import com.utilities.commonFunctions;

public class Accordion extends DriverManager{
	
	private WebDriver driver;
	private HomePage home;
	private commonFunctions functions;
	private AccordionPage accordion;
	static ExtentTest test;

	
	@BeforeClass
	public void setUp() {
		driver=getWebDriver();

		}
	
	@Test(priority = 1)
	public void clickAccordionlink()
	{
		home = new HomePage(driver);
		functions = new commonFunctions(driver);
		functions.hitURL();
		//driver.findElement(home.accordionlink).click();
		WebElement element = driver.findElement(home.accordionlink);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	
		
	}
	
	/*
	 * This method clicks on each accordion to check collapse and expand
	 * 
	 */
	
	@Test(priority = 2)
	public void checkAccordianCollapse()
	{
		accordion = new AccordionPage(driver);
		functions = new commonFunctions(driver);
		
		if (driver.findElement(accordion.accordiancollapsepresent).isDisplayed())
		{		
			Assert.assertEquals("True","True", "Accordion page load successful");
			int accordionCount = driver.findElements(accordion.accordiancollapsepresent).size();
			for (int i=1;i<=accordionCount;i++)
			{
				WebElement selectaleAccordion = driver.findElement(By.xpath("(//h3[contains(@id,'ui-id-')])"+ "[" + i  + "]"));
				selectaleAccordion.click();
				String strUI = selectaleAccordion.getAttribute("class");
				if (strUI.contains("active ui-state-active"))
				{
					Assert.assertEquals("True","True","Accordian collapsed");
					
				}		
				
			}
	}
		else
		{
			Assert.assertEquals("False","True", "Accordion page not loaded successful");
			
		}

}
	
	/*
	 * This method checks the presence of text under each accordion
	 * 
	 */

	@Test(priority = 3 )
	public void checkAccordionText()
	{
		accordion = new AccordionPage(driver);
		functions = new commonFunctions(driver);
		
		int accordionCount = driver.findElements(accordion.accordiancollapsepresent).size();
		for (int i=1;i<=accordionCount;i++)
		{
			WebElement selectaleAccordion = driver.findElement(By.xpath("(//h3[contains(@id,'ui-id-')])"+ "[" + i  + "]"));
			WebElement accordionText = driver.findElement(accordion.accordionText);
			WebElement accordionTextCheck = driver.findElement(accordion.accordionTextCheck);
			selectaleAccordion.click();
			String strUI = selectaleAccordion.getAttribute("class");
			if (strUI.contains("active ui-state-active"))
			{
				Assert.assertEquals("True","True","Accordian collapsed");
				
			}
			if (accordionText.isDisplayed())
			{
				if (accordionTextCheck.isDisplayed())
				{
					Assert.assertEquals("True", "True","Accordion Text Displayed");
					
				}
			}			
			
		}
	}
	
	@Test(priority = 4)
	public void checkAccordionDoNotCloseOnreclicking()
	{
		accordion = new AccordionPage(driver);
		functions = new commonFunctions(driver);
		int accordionCount = driver.findElements(accordion.accordiancollapsepresent).size();
		for (int i=1;i<=accordionCount;i++)
		{
			WebElement selectaleAccordion = driver.findElement(By.xpath("(//h3[contains(@id,'ui-id-')])"+ "[" + i  + "]"));
			selectaleAccordion.click();
			selectaleAccordion.click();
			String strUI = selectaleAccordion.getAttribute("class");
			
			if(strUI.contains("active ui-state-active"))
			{
				Assert.assertEquals("True", "True","Accordion did not collapse on second click");
				
			}
			
			else
			{
				Assert.assertEquals("False", "True","Accordion collapsed on second click");
				
			}
		}
		
	}
	
	@AfterClass
	public void tearDown() 
	 {
		 driver.quit();
	 }
}
