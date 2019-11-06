package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


/**
 * Class representing List Box page.
 * 
 * @author Alan Buda
 */
public class ListBoxPage extends Page {
	
	@FindBy(xpath = "(//input[@name='SearchDualList'])[1]")
	private WebElement leftSearchBox;
	
	@FindBy(xpath = "(//input[@name='SearchDualList'])[2]")
	private WebElement rightSearchBox;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-sm move-left']")
	private WebElement leftArrowButton;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-sm move-right']")
	private WebElement rightArrowButton;
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addButton;
	
	@FindBy(xpath = "//button[text()='Remove All']")
	private WebElement removeAllButton;
	
	@FindBy(id = "input-search")
	private WebElement inputSearch;
	
	public ListBoxPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Move values from one column to another.
	 * 
	 * @param leftValue
	 * 			value to move from left column
	 * @param rightValue
	 * 			value to move from right column
	 * 
	 * @return instance of ListBoxPage object.
	 */
	public ListBoxPage bootstrapList(String leftValue,String rightValue) {
		driver.findElement(By.xpath("(//li[text()='" + leftValue + " '])[1]")).click();
		rightArrowButton.click();
		rightSearchBox.sendKeys(leftValue);
		rightSearchBox.clear();
		leftArrowButton.click();
		leftSearchBox.sendKeys(rightValue);
		return new ListBoxPage(driver);
	}

	/**
	 * Move values from one column to another.
	 * 
	 * @param args
	 * 			values to move to another column
	 * 
	 * @return instance of ListBoxPage object.
	 */
	public ListBoxPage jqueryList(String ...args) {
		for(String value:args) {
			driver.findElement(By.xpath("//option[text()='" + value + "']")).click();
			addButton.click();
		}
		removeAllButton.click();
		return new ListBoxPage(driver);
	}

	/**
	 * Find user by name.
	 * 
	 * @param name
	 * 			name of the user to find
	 * 
	 * @return instance of ListBoxPage object.
	 */
	public ListBoxPage dataListFilter(String name) {
		inputSearch.sendKeys(name);
		Assert.assertTrue(driver.findElement(By.xpath("(//h4[contains(text(),'" + name + "')])[1]")).isDisplayed());
		return new ListBoxPage(driver);
	}
	
}
