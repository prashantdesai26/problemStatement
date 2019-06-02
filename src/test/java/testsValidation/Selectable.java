package testsValidation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageObjects.HomePage;
import com.pageObjects.SelectablePage;
import com.utilities.DriverManager;
import com.utilities.commonFunctions;

public class Selectable extends DriverManager {
	
	private WebDriver driver;
	private HomePage home;
	private commonFunctions functions;
	private SelectablePage select;

		
	@BeforeClass
	public void setUp() {
		driver=getWebDriver();

		}
	
	
	@Test(priority = 1)
	public void clickSelectablelink()
	{
		home = new HomePage(driver);
		functions = new commonFunctions(driver);
		functions.hitURL();
		WebElement element = driver.findElement(home.selectablelink);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	@Test(priority = 2)
	public void checkSelectableBlock()
	{
		functions = new commonFunctions(driver);
		select = new SelectablePage(driver);
		
		WebElement selectableBlock = driver.findElement(select.selectableGrid);
		if (selectableBlock.isDisplayed())
		{
			Assert.assertEquals("True", "True","Selectable Grid displayed");
		}
		
		else
		{
			Assert.assertEquals("False", "False","Selectable Grid not displayed");
		}
	}
	
	@Test(priority = 3)
	public void checkBlockSelectable() throws InterruptedException 
	{
		functions = new commonFunctions(driver);
		select = new SelectablePage(driver);
		
		int blockCount = driver.findElements(select.selectableBlocks).size();
		
		for (int i=1;i<=blockCount;i++)
		{
			driver.findElement(By.xpath("(//li[contains(@class , 'ui-widget-content ui-selectee')])[" + i + "]")).click();
			WebElement selectedBlock = driver.findElement(select.selectedBlock);
			
			functions.explicitWait(selectedBlock);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			
			String attribute = driver.findElement(By.xpath("(//li[contains(@class , 'ui-widget-content ui-selectee')])[" + i + "]")).getAttribute("class");
			if(attribute.contains("selected"))
			{
				Assert.assertEquals("True", "True","Blocks selected successfully");
			}
			else
			{
				Assert.assertEquals("False", "True","Blocks not selected successfully"+attribute);
			}
		}
	}
	
	@Test(priority = 4)
	public void selectMultipleBlock()
	{
		functions = new commonFunctions(driver);
		select = new SelectablePage(driver);
		Actions action = new Actions(driver);
		
		int blockCount = driver.findElements(select.selectableBlocks).size();
		action.keyUp(Keys.CONTROL);
		
		for (int i=1;i<=blockCount;i++)
		{
			
			WebElement blockSelect = driver.findElement(By.xpath("(//li[contains(@class , 'ui-widget-content ui-selectee')])[" + i + "]"));
			action.click(blockSelect).build().perform();
			
		}
		
		action.keyUp(Keys.CONTROL);
		int SelectedBlockcount = driver.findElements(select.selectedBlock).size();
		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		if (SelectedBlockcount==blockCount)
		{
			Assert.assertEquals("True", "True","All Blocks selected successfully");
		}
		
		else
		{
			Assert.assertEquals("False", "True","Blocks not selected successfully");
		}
		
	}
	
	@AfterClass
	public void tearDown() 
	 {
		 driver.quit();
	 }
	

		

}
