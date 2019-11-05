package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class representing Progress Bars page.
 * 
 * @author Alan Buda
 */
public class ProgressBarsPage extends Page {
	
	@FindBy(id = "downloadButton")
	private WebElement startDownload;
	
	@FindBy(xpath = "//button[text()='Close']")
	private WebElement closeDownload;
	
	@FindBy(id = "cricle-btn")
	private WebElement downloadButton;
	
	@FindBy(xpath = "//input[@onchange='range.value=value']")
	private WebElement graySlider;
	
	@FindBy(xpath = "//input[@onchange='rangeSuccess.value=value']")
	private WebElement greenSlider;
	
	@FindBy(xpath = "//input[@onchange='rangeWarning.value=value']")
	private WebElement orangeSlider;
	
	@FindBy(xpath = "//input[@onchange='rangeDanger.value=value']")
	private WebElement redSlider;
	
	@FindBy(xpath = "//input[@onchange='rangePrimary.value=value']")
	private WebElement darkBlueSlider;
	
	@FindBy(xpath = "//input[@onchange='rangeInfo.value=value']")
	private WebElement blueSlider;
	
	public ProgressBarsPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Start download and wait until finish.
	 * 
	 */
	public ProgressBarsPage jqueryDownload() {
		startDownload.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Complete!']")));
		closeDownload.click();
		return new ProgressBarsPage(driver);
	}
	
	/**
	 * Start download and wait until finish.
	 * 
	 */
	public ProgressBarsPage bootstrapDownload() {
		downloadButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='100%']")));
		return new ProgressBarsPage(driver);
	}

	public ProgressBarsPage dragDropSliders() {
		
        Actions move = new Actions(driver);
        move.dragAndDropBy(graySlider, 30, 0).build().perform();
        move.dragAndDropBy(greenSlider, 20, 0).build().perform();
        move.dragAndDropBy(orangeSlider, 10, 0).build().perform();
        move.dragAndDropBy(darkBlueSlider, 15, 0).build().perform();
        move.dragAndDropBy(blueSlider, -10, 0).build().perform();
        move.dragAndDropBy(redSlider, -20, 0).build().perform();

		return new ProgressBarsPage(driver);
	}
	
}
