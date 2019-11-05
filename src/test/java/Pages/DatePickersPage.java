package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

/**
 * Class representing Date Pickers page.
 * 
 * @author Alan Buda
 */
public class DatePickersPage extends Page {
	
	@FindBy(xpath = "//input[@placeholder='dd/mm/yyyy']")
	private WebElement calendar;
	
	@FindBy(xpath = "//input[@placeholder='Start date']")
	private WebElement startDateField;
	
	@FindBy(xpath = "//input[@placeholder='End date']")
	private WebElement endDateField;
	
	@FindBy(xpath = "//th[@class='today']")
	private WebElement today;
	
	@FindBy(xpath = "//th[@class='clear']")
	private WebElement clear;
	
	@FindBy(xpath = "(//td[text()='6'])[1]")
	private WebElement firstPickedDay;
	
	@FindBy(xpath = "(//td[text()='12'])[1]")
	private WebElement secondPickedDay;
	
	@FindBy(id = "from")
	private WebElement fromDateField;
	
	@FindBy(id = "to")
	private WebElement toDateField;
	
	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement monthPicker;
	
	@FindBy(xpath = "(//a[text()='6'])[1]")
	private WebElement firstPickedJQueryDay;
	
	@FindBy(xpath = "(//a[text()='12'])[1]")
	private WebElement secondPickedJQueryDay;
	
	public DatePickersPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Check values from calendar and pick date.
	 *  
	 * @return instance of InputFormsPage object.
	 */
	public DatePickersPage bootstrapDateExample() {
		calendar.click();
		Assert.assertTrue(driver.findElement(By.xpath("(//td[text()='30'])[last()]")).getAttribute("class").equals("disabled day"));
		Assert.assertTrue(driver.findElement(By.xpath("(//tr/td[7])[last()]")).getAttribute("class").equals("new disabled disabled-date day"));
		Assert.assertTrue(driver.findElement(By.xpath("(//tr/th[1])[3]")).getText().equals("Mo"));
		today.click();
		calendar.click();
		clear.click();
		return new DatePickersPage(driver);
	}
	
	/**
	 * Check values from calendar and pick start and end date.
	 *  
	 * @return instance of InputFormsPage object.
	 */
	public DatePickersPage bootstrapDateRangeExample() {
		startDateField.click();
		Assert.assertTrue(driver.findElement(By.xpath("(//tr/td[1])[1]")).getAttribute("class").equals("old disabled disabled-date day"));
		Assert.assertTrue(driver.findElement(By.xpath("(//tr/th[1])[3]")).getText().equals("Su"));
		firstPickedDay.click();
		endDateField.click();
		secondPickedDay.click();
		return new DatePickersPage(driver);
	}
	
	/**
	 * Pick date range from JQuery Date Picker.
	 *  
	 * @param month
	 * 			Value to pick from Months list
	 * 
	 * @return instance of InputFormsPage object.
	 */
	public DatePickersPage jqueryDateRangePicker(String month) {
		fromDateField.click();
		monthPicker.click();
		driver.findElement(By.xpath("//option[text()='" + month + "']")).click();
		firstPickedJQueryDay.click();
		toDateField.click();
		driver.findElement(By.xpath("//option[text()='" + month + "']")).click();
		secondPickedJQueryDay.click();
		return new DatePickersPage(driver);
	}
	
}
