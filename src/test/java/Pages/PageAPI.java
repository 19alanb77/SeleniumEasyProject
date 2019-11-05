package Pages;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Configs.ConfigKeys;

/**
 * 
 * Class that allows to manage functionality of tests between Pages and Tests.
 *
 * @author Alan Buda
 */
public class PageAPI {
	
	public static WebDriver driver;

	/**
	 * Method creates and sets the WebDriver with specified properties.
	 * 
	 * @param time
	 *            The amount of time to wait
	 * @param unit
	 *            The unit of measure for time
	 */
	public void setDriver(long time, TimeUnit unit) {
		System.setProperty("webdriver.gecko.driver", ConfigKeys.getConfigKey("driver_path"));
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(time, unit);
		driver.manage().window().maximize();
	}
	
	/**
	 * Close all windows associated with driver.
	 */
	public void closeDriver() {
		driver.quit();
	}
	
	/**
	 * Pick specific demo to test.
	 * 
	 * @param category
	 *            Name of the category that contains demo
	 * @param demo
	 *            Name of the demo to pick
	 */
	public void pickDemo(String category,String demo) {
		WebElement categoryElement = driver.findElement(By.xpath("//a[text()='" + category + "']"));
		WebElement demoElement = driver.findElement(By.xpath("(//a[text()='" + demo + "'])[2]"));
		WebDriverWait wait = new WebDriverWait(driver,5);
		categoryElement.click();
		wait.until(ExpectedConditions.elementToBeClickable(demoElement));
		demoElement.click();	
	}

	/**
	 * Open main page specified by key main_page.
	 * 
	 */
	public void openMainPage() {
		driver.get(ConfigKeys.getConfigKey("main_page"));
		assertTrue(driver.findElement(By.cssSelector("a[title='Home']")).isDisplayed());
	}
	
	/**
	 * Do an exercises from Simple Form Demo.
	 * 
	 * @param message
	 *            Text of the message to enter
	 * @param firstValue
	 *            First value to sum
	 * @param secondValue
	 *            Second value to sum
	 */
	public void simpleFormDemo(String message,String firstValue,String secondValue) {
		new InputFormsPage(driver)
			.checkMessage(message)
			.checkEquation(firstValue,secondValue);
	}

	/**
	 * Do an exercises from Checkbox Demo.
	 * 
	 */
	public void checkboxDemo() {
		new InputFormsPage(driver)
			.clickCheckbox()
			.clickCheckboxList();
	}

	/**
	 * Do an exercises from Radio Buttons Demo.
	 * 
	 * @param firstRadio
	 *            Value of radio button from first exercise
	 * @param radio
	 *            Value of radio button from second exercise
	 * @param age
	 *            Value of age button to pick
	 */
	public void radioButtonsDemo(String firstRadio, String secondRadio, String age) {
		new InputFormsPage(driver)
			.checkRadioButton(firstRadio)
			.checkGroupRadioButton(secondRadio,age);
	}

	/**
	 * Do an exercises from Select Dropdown List.
	 * 
	 * @param arg0
	 *            Value picked from first list
	 * @param args
	 *            Values picked from second list
	 */
	public void selectDropdownList(String arg0,String... args) {
		new InputFormsPage(driver)
			.cllickSelectedValue(arg0)
			.clickValuesFromList(args);
		
	}

	/**
	 * Do an exercises from Input Form Submit.
	 * 
	 * @param name
	 *            Value of First Name field
	 * @param lastName
	 *            Value of Last Name field
	 * @param email
	 *            Value of E-mail field
	 * @param phone
	 *            Value of Phone field
	 * @param address
	 *            Value of Address field
	 * @param city
	 *            Value of City field
	 * @param state
	 *            Value picked from State list
	 * @param zip
	 *            Value of Zip Code field
	 * @param domain
	 *            Value of Website or domain name field
	 * @param hosting
	 *            Value of hosting radio button
	 * @param description
	 *            Value of Project Description field
	 */
	public void fillInputForm(String name, String lastName, String email, String phone, String address,
			String city, String state, String zip, String domain, String hosting, String description) {
		new InputFormsPage(driver)
			.fillInputFormSubmit(name,lastName,email,phone,address,city,state,zip,domain,hosting,description);
	}

	/**
	 * Fill and submit Ajax form.
	 * 
	 * @param name
	 *            Value of Name field
	 * @param comment
	 *            Value of Comment field
	 */
	public void sendAjaxForm(String name, String comment) {
		new InputFormsPage(driver)
			.submitAjax(name,comment);
	}

	/**
	 * Pick values from JQuery dropdowns.
	 * 
	 * @param searchBox
	 *            Value to find and pick from Search Box
	 * @param select
	 *            Value to pick from Multi Select dropdown
	 * @param disabled
	 *            Value to pick from Drop Down with Disabled values
	 * @param category
	 *            Value to pick from Drop-down with Category related options
	 */
	public void pickOptionFromDropdownList(String searchBox, String select, String disabled, String category) {
		new InputFormsPage(driver)
			.pickFromSearchBox(searchBox)
			.pickFromMultipleSelect(select)
			.pickFromDisabledValues(disabled)
			.pickFromCategoryRelatedOptions(category);	
	}

	/**
	 * Do an exercises from Bootsrap Date Picker Demo.
	 * 
	 */
	public void bootstrapDateDemo() {
		new DatePickersPage(driver)
			.bootstrapDateExample()
			.bootstrapDateRangeExample();
	}

	/**
	 * Do an exercises from JQuery Date Picker Demo.
	 * 
	 * @param month
	 * 			Value to pick from Months list
	 */
	public void jqueryDateDemo(String month) {
		new DatePickersPage(driver)
			.jqueryDateRangePicker(month);
	}

	/**
	 * Do an exercises from Table Pagination Demo.
	 * 
	 */
	public void tablePagination() {
		new TablePage(driver)
			.tablePagination();
	}

	/**
	 * Do an exercises from Table Data Search Demo.
	 * 
	 * @param task
	 * 			value to search from table
	 * @param username
	 * 			first record to search by username
	 * @param recordNo
	 * 			second record to search by number of record
	 * 
	 */
	public void tableDataSearch(String task,String username,String recordNo) {
		new TablePage(driver)
			.tableSearchTasks(task)
			.tableSearchListedUsers(username,recordNo);
	}

	/**
	 * Do an exercises from Table Filter Demo.
	 * 
	 */
	public void tableFilter() {
		new TablePage(driver)
			.tableFilter();
	}

	/**
	 * Do an exercises from Table Sort & Search Demo.
	 * 
	 * @param numberOfRecords
	 * 			number of record to show
	 * @param columnName
	 * 			name of the column to sort
	 * @param value
	 * 			value to search in table
	 * 
	 */
	public void sortTable(String numberOfRecords,String columnName,String value) {
		new TablePage(driver)
			.showNumberOfRecords(numberOfRecords)
			.sortByColumn(columnName)
			.searchRecords(value);
	}
}
