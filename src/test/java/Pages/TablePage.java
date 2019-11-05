package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

/**
 * Class representing Table page.
 * 
 * @author Alan Buda
 */
public class TablePage extends Page {
	
	@FindBy(className = "next_link")
	private WebElement nextButton;
	
	@FindBy(className = "prev_link")
	private WebElement prevButton;
	
	@FindBy(id = "task-table-filter")
	private WebElement taskField;
	
//	@FindBy(className = "btn btn-default btn-xs btn-filter")
	@FindBy(xpath = "//button[@class='btn btn-default btn-xs btn-filter']")
	private WebElement filterIcon;
	
	@FindBy(xpath = "//input[@placeholder='#']")
	private WebElement recordField;
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement usernameField;
	
	@FindBy(xpath = "//button[text()='Green']")
	private WebElement greenButton;
	
	@FindBy(xpath = "//button[text()='Orange']")
	private WebElement orangeButton;
	
	@FindBy(xpath = "//button[text()='Red']")
	private WebElement redButton;
	
	@FindBy(name = "example_length")
	private WebElement recordNoList;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchInput;
	
	public TablePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Click buttons from Table Pagination example.
	 * 
	 * @return instance of TablePage object.
	 */
	public TablePage tablePagination() {
		nextButton.click();
		Assert.assertTrue(driver.findElement(By.xpath("//tr/th[7]")).getText().equals("Table heading 6"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(prevButton));
		prevButton.click();
		return new TablePage(driver);
	}

	/**
	 * Filter table by tasks.
	 * 
	 * @param task
	 * 			value to search from table
	 * 		
	 * @return instance of TablePage object.
	 */
	public TablePage tableSearchTasks(String task) {
		taskField.sendKeys(task);
		taskField.clear();
		return new TablePage(driver);
	}
	
	/**
	 * Filter table by specific column.
	 * 
	 * @param username
	 * 			first record to search by username
	 * @param recordNo
	 * 			second record to search by number of record
	 * 
	 * @return instance of TablePage object.
	 */
	public TablePage tableSearchListedUsers(String username,String recordNo) {
		filterIcon.click();
		usernameField.sendKeys(username);
		Assert.assertTrue(driver.findElement(By.xpath("(//div[div/h3[text()='Listed Users']]/table/tbody/tr/td[2])[1]")).getText().equals(username));
		usernameField.clear();
		recordField.sendKeys(recordNo);
		return new TablePage(driver);
	}

	/**
	 * Count records by filter.
	 * 
	 * @return instance of TablePage object.
	 */
	public TablePage tableFilter() {
		int greenRecordNo = driver.findElements(By.xpath("//tr[@data-status='pagado']")).size();
		int orangeRecordNo = driver.findElements(By.xpath("//tr[@data-status='pendiente']")).size();
		int redRecordNo = driver.findElements(By.xpath("//tr[@data-status='cancelado']")).size();
		greenButton.click();
		Assert.assertEquals(driver.findElements(By.xpath("//tr[@style='']")).size(),greenRecordNo);
		orangeButton.click();
		Assert.assertEquals(driver.findElements(By.xpath("//tr[@style='']")).size(),orangeRecordNo);
		redButton.click();
		Assert.assertEquals(driver.findElements(By.xpath("//tr[@style='']")).size(),redRecordNo);
		return new TablePage(driver);
	}

	/**
	 * Show specific number of records.
	 * 
	 * @param numberOfRecords
	 * 			number of records to show
	 * 
	 * @return instance of TablePage object.
	 */
	public TablePage showNumberOfRecords(String numberOfRecords) {
		recordNoList.click();
		driver.findElement(By.xpath("//option[@value='" + numberOfRecords + "']")).click();
		return new TablePage(driver);
	}
	
	/**
	 * Sort table by specific column.
	 * 
	 * @param columnName
	 * 			name of the column to sort
	 * 
	 * @return instance of TablePage object.
	 */
	public TablePage sortByColumn(String columnName) {
		driver.findElement(By.xpath("//th[text()='" + columnName + "']")).click();
		return new TablePage(driver);
	}
	
	/**
	 * Search records with specific value.
	 * 
	 * @param value
	 * 			value to search
	 * 
	 * @return instance of TablePage object.
	 */
	public TablePage searchRecords(String value) {
		searchInput.sendKeys(value);
		List<WebElement> list = driver.findElements(By.xpath("//tr[@role='row']/td[3]"));
		for(WebElement element : list) {
			Assert.assertTrue(element.getText().equals(value));
		}
		return new TablePage(driver);
	}
	
}
