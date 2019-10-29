package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

/**
 * Class representing Input Forms page.
 * 
 * @author Alan Buda
 */
public class InputFormsPage extends Page {
	
	@FindBy(id = "user-message")
	private WebElement messageInput;
	
	@FindBy(xpath = "//button[text()='Show Message']")
	private WebElement showMessageButton;
	
	@FindBy(id = "display")
	private WebElement messageResult;
	
	@FindBy(id = "sum1")
	private WebElement firstValueButton;
	
	@FindBy(id = "sum2")
	private WebElement secondValueButton;
	
	@FindBy(xpath = "//button[text()='Get Total']")
	private WebElement getTotalButton;
	
	@FindBy(id = "displayvalue")
	private WebElement equationResult;
	
	@FindBy(id = "isAgeSelected")
	private WebElement checkbox;
	
	@FindBy(id = "check1")
	private WebElement checkAll;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[3]")
	private WebElement option2;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[5]")
	private WebElement option4;
	
	@FindBy(id = "buttoncheck")
	private WebElement checkedValueButton;
	
	@FindBy(xpath = "//button[text()='Get values']")
	private WebElement getValueButton;
	
	@FindBy(id = "select-demo")
	private WebElement selectDemo;
	
	@FindBy(id = "multi-select")
	private WebElement multiSelect;
	
	@FindBy(id = "printMe")
	private WebElement firstSelected;
	
	@FindBy(id = "printAll")
	private WebElement getAllSelected;
	
	@FindBy(name = "first_name")
	private WebElement nameField;
	
	@FindBy(name = "last_name")
	private WebElement lastNameField;
	
	@FindBy(name = "email")
	private WebElement emailField;
	
	@FindBy(name = "phone")
	private WebElement phoneField;
	
	@FindBy(name = "address")
	private WebElement addressField;
	
	@FindBy(name = "city")
	private WebElement cityField;
	
	@FindBy(name = "state")
	private WebElement selectList;
	
	@FindBy(name = "zip")
	private WebElement zipCodeField;
	
	@FindBy(name = "website")
	private WebElement domainField;
	
	@FindBy(name = "comment")
	private WebElement descriptionField;
	
	@FindBy(id = "title")
	private WebElement nameAjaxField;
	
	@FindBy(id = "description")
	private WebElement commentAjaxField;
	
	@FindBy(name = "btn-submit")
	private WebElement submitButton;
	
	@FindBy(xpath = "//span[@aria-labelledby='select2-country-container']")
	private WebElement searchBoxField;
	
	@FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
	private WebElement searchBoxText;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	private WebElement JQuerySelect;
	
	@FindBy(xpath = "(//span[@class='select2-selection__arrow'])[2]")
	private WebElement disabledSelect;
	
	@FindBy(id = "files")
	private WebElement filesDropdown;
	
	public InputFormsPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Enter value to message box.
	 * 
	 * @param message
	 *            Text of the message to enter
	 *            
	 * @return instance of InputFormsPage object.
	 * 
	 */
	public InputFormsPage checkMessage(String message) {
		messageInput.sendKeys(message);
		showMessageButton.click();
		Assert.assertTrue(messageResult.getText().equals(message));
		return new InputFormsPage(driver);
	}
	
	/**
	 * Enter two values and sum them up.
	 * 
	 * @param firstValue
	 *            First value to sum
	 * @param secondValue
	 *            Second value to sum
	 *            
	 * @return instance of InputFormsPage object.
	 * 
	 */
	public InputFormsPage checkEquation(String firstValue, String secondValue) {
		firstValueButton.sendKeys(firstValue);
		secondValueButton.sendKeys(secondValue);
		getTotalButton.click();
		Assert.assertEquals(Integer.parseInt(equationResult.getText()), Integer.parseInt(firstValue)+Integer.parseInt(secondValue));
		return new InputFormsPage(driver);		
	}

	/**
	 * Click checkbox from first exercise.
	 * 
	 * @return instance of InputFormsPage object.
	 * 
	 * 
	 */
	public InputFormsPage clickCheckbox() {
		checkbox.click();
		return new InputFormsPage(driver);
	}
	
	/**
	 * Click checkbox and check value of Check All Button.
	 *
	 * @return instance of InputFormsPage object.
	 * 
	 */
	public InputFormsPage clickCheckboxList() {
		checkAll.click();
		Assert.assertTrue(checkAll.getAttribute("value").equals("Uncheck All"));
		option2.click();
		option4.click();
		Assert.assertTrue(checkAll.getAttribute("value").equals("Check All"));
		return new InputFormsPage(driver);
	}
	
	/**
	 * Pick radio button and check value.
	 * 
	 * @param radio
	 *            Value of radio button to pick
	 *            
	 * @return instance of InputFormsPage object.
	 * 
	 */
	public InputFormsPage checkRadioButton(String radio) {
		driver.findElement(By.xpath("//input[@value='" + radio + "' and @name='optradio']")).click();
		checkedValueButton.click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"Radio button '" + radio + "' is checked\"]")).isDisplayed());
		return new InputFormsPage(driver);
	}
	
	/**
	 * Pick radio button and age button with check value.
	 * 
	 * @param radio
	 *            Value of radio button to pick
	 * @param age
	 *            Value of age button to pick
	 *            
	 * @return instance of InputFormsPage object.
	 * 
	 */
	public InputFormsPage checkGroupRadioButton(String radio, String age) {
		driver.findElement(By.xpath("//input[@value='" + radio + "' and @name='gender']")).click();
		driver.findElement(By.xpath("//input[@value='" + age.replace("to", "-") + "' and @name='ageGroup']")).click();
		getValueButton.click();
		return new InputFormsPage(driver);
	}

	/**
	 * Pick value from dropdown list.
	 * 
	 * @param arg0
	 *            Value from the list to pick
	 *            
	 * @return instance of InputFormsPage object.
	 * 
	 */
	public InputFormsPage cllickSelectedValue(String arg0) {
		Select day = new Select(selectDemo);
		day.selectByVisibleText(arg0);
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Day selected :- " + arg0 + "']")).isDisplayed());
		return new InputFormsPage(driver);
	}
	
	/**
	 * Pick few values from dropdown list.
	 * 
	 * @param args
	 *            Values from the list to pick
	 *            
	 * @return instance of InputFormsPage object.
	 * 
	 */
	public InputFormsPage clickValuesFromList(String[] args) {
		 for (String valueToBeSelected : args) {
		    new Select(multiSelect).selectByVisibleText(valueToBeSelected);
		    multiSelect.sendKeys(Keys.CONTROL);
		 }
//		 firstSelected.click();
//		 Assert.assertTrue(driver.findElement(By.xpath("//p[text()='First selected option is : " + args[0] + "']")).isDisplayed());
//		 getAllSelected.click();
//		 for (String selectedValues : args) {
//			 Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'" + selectedValues + "')]")).isDisplayed());
//		 }
		return new InputFormsPage(driver);
	}

	/**
	 * Fill input form.
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
	 *            
	 * @return instance of InputFormsPage object.
	 */
	public InputFormsPage fillInputFormSubmit(String name, String lastName, String email, String phone, String address,
			String city, String state, String zip, String domain, String hosting, String description) {
		nameField.sendKeys(name);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		phoneField.sendKeys(phone);
		addressField.sendKeys(address);
		cityField.sendKeys(city);
		new Select(selectList).selectByVisibleText(state);
		zipCodeField.sendKeys(zip);
		domainField.sendKeys(domain);
		driver.findElement(By.xpath("//input[@value='" + hosting.toLowerCase() + "' and @name='hosting']")).click();
		descriptionField.sendKeys(description);
		return new InputFormsPage(driver);
	}

	/**
	 * Fill and submit Ajax form.
	 * 
	 * @param name
	 *            Value of Name field
	 * @param comment
	 *            Value of Comment field
	 *            
	 * @return instance of InputFormsPage object.
	 */
	public InputFormsPage submitAjax(String name, String comment) {
		nameAjaxField.sendKeys(name);
		commentAjaxField.sendKeys(comment);
		submitButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Form submited Successfully!" + "']")));
		return new InputFormsPage(driver);
	}

	/**
	 * Pick value from Search Box.
	 * 
	 * @param searchBox
	 *            Value to find and pick from Search Box
	 *            
	 * @return instance of InputFormsPage object.
	 */
	public InputFormsPage pickFromSearchBox(String searchBox) {
		searchBoxField.click();
		searchBoxText.sendKeys(searchBox);
		driver.findElement(By.xpath("//li[text()='" + searchBox + "']")).click();
		return new InputFormsPage(driver);
	}
	
	/**
	 * Pick value from Multi Select dropdown.
	 * 
	 * @param select
	 *            Value to pick from Multi Select dropdown
	 *            
	 * @return instance of InputFormsPage object.
	 */
	public InputFormsPage pickFromMultipleSelect(String select) {
		JQuerySelect.click();
		JQuerySelect.sendKeys(select);
		driver.findElement(By.xpath("//li[text()='" + select + "']")).click();
		return new InputFormsPage(driver);
	}
	
	/**
	 * Pick value from Drop Down with Disabled values.
	 * 
	 * @param disabled
	 *            Value to pick from Drop Down with Disabled values
	 *            
	 * @return instance of InputFormsPage object.
	 */
	public InputFormsPage pickFromDisabledValues(String disabled) {
		disabledSelect.click();
		driver.findElement(By.xpath("//li[text()='" + disabled + "']")).click();
		return new InputFormsPage(driver);
	}
	
	/**
	 * Pick value from Drop-down with Category related options.
	 * 
	 * @param category
	 *            Value to pick from Drop-down with Category related options
	 *            
	 * @return instance of InputFormsPage object.
	 */
	public InputFormsPage pickFromCategoryRelatedOptions(String category) {
		new Select(filesDropdown).selectByVisibleText(category);
		return new InputFormsPage(driver);
	}
	
}
