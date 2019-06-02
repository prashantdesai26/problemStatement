package testsValidation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageObjects.DroppablePage;
import com.pageObjects.HomePage;
import com.utilities.DriverManager;
import com.utilities.commonFunctions;

public class Droppable extends DriverManager {
	
	private WebDriver driver;
	private HomePage home;
	private commonFunctions functions;
	private DroppablePage droppable;
	

	
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
		WebElement element = driver.findElement(home.droppablelink);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	@Test(priority = 2)
	public void dragElementtoTarget()
	{
		droppable = new DroppablePage(driver);
		Actions action = new Actions(driver);
		WebElement dragElement = driver.findElement(droppable.dragElement);
		WebElement dropElement = driver.findElement(droppable.dropElement);
		action.dragAndDrop(dragElement, dropElement).build().perform();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		String changedAttribute = dropElement.getAttribute("class");
		if (changedAttribute.contains("highlight"))
		{
			Assert.assertEquals("True", "True","Element dropped to target element");
		}
		
		else
		{
			Assert.assertEquals("False", "True","Element dropped not to target element");
		}
	}
	
	@Test(priority = 3)
	public void dragElementToOtherSpot()
	{
		droppable = new DroppablePage(driver);
		Actions action = new Actions(driver);
		WebElement dragElement = driver.findElement(droppable.dragElement);
		WebElement dropElement = driver.findElement(droppable.dropElement);
		action.dragAndDropBy(dragElement, 500, 100);
		String changedAttribute = dropElement.getAttribute("class");
		if (!changedAttribute.contains("highlight"))
		{
			Assert.assertEquals("True", "True","Functionality working as expected");
		}
		
		else
		{
			Assert.assertEquals("False", "True","Functionality not working as expected");
		}
		
	}
	
	@AfterClass
	public void tearDown() 
	 {
		 driver.quit();
	 }
	
	
}
