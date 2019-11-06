package Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


/**
 * Class representing Others page.
 * 
 * @author Alan Buda
 */
public class OthersPage extends Page {
	
	@FindBy(id = "mydropzone")
	private WebElement drop;
	
	@FindBy(id = "save")
	private WebElement getUser;
	
	public OthersPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Drag items to another place.
	 * 
	 * @return instance of OthersPage object.
	 */
	public OthersPage dragAndDropItems() {
		List<WebElement> list = driver.findElements(By.xpath("//span[contains(text(),'Draggable')]"));
		
		for(WebElement element : list) {					
			Actions actions=new Actions(driver);
			actions.dragAndDrop(element, drop).build().perform();	
		}
		return new OthersPage(driver);
	}

	/**
	 * Generate dynamic data.
	 * 
	 * @return instance of OthersPage object.
	 */
	public OthersPage loadDynamicData() {
		getUser.click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'First Name')]")).isDisplayed());
		return new OthersPage(driver);
	}
	
}
