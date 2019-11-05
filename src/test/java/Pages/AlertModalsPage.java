package Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Class representing Alert & Modals page.
 * 
 * @author Alan Buda
 */
public class AlertModalsPage extends Page {
	
	@FindBy(id = "normal-btn-success")
	private WebElement normalSuccessMessage;
	
	@FindBy(id = "autoclosable-btn-danger")
	private WebElement autocloseableMessage;
	
	@FindBy(className = "close")
	private WebElement closeIcon;
	
	@FindBy(xpath = "//div[contains(text(),'I will hide in 5 seconds.')]")
	private WebElement visibleMessage;
	
	@FindBy(xpath = "(//a[text()='Launch modal'])[1]")
	private WebElement singleModal;
	
	@FindBy(xpath = "(//a[text()='Launch modal'])[2]")
	private WebElement multipleModal;
	
	@FindBy(xpath = "(//a[text()='Close'])[1]")
	private WebElement closeButton;
	
	@FindBy(xpath = "(//a[text()='Launch modal'])[3]")
	private WebElement launchModal;
	
	@FindBy(xpath = "(//a[text()='Save changes'])[3]")
	private WebElement saveButton;
	
	@FindBy(xpath = "//a[text()='  Follow On Twitter ']")
	private WebElement twitterButton;
	
	@FindBy(xpath = "//a[text()='  Like us On Facebook ']")
	private WebElement facebookButton;
	
	@FindBy(xpath = "//a[text()='Follow Twitter & Facebook']")
	private WebElement bothButton;
	
	@FindBy(xpath = "//a[text()='Follow All']")
	private WebElement allButton;
	
	@FindBy(xpath = "//button[@class='btn btn-warning']")
	private WebElement showDialogButton;
	
	@FindBy(xpath = "(//button[contains(text(),'Click')])[1]")
	private WebElement firstAlert;
	
	@FindBy(xpath = "(//button[contains(text(),'Click')])[2]")
	private WebElement secondAlert;
	
	@FindBy(xpath = "(//button[contains(text(),'Click')])[3]")
	private WebElement thirdAlert;
	
	@FindBy(id = "textbox")
	private WebElement textField;
	
	@FindBy(id = "create")
	private WebElement generateButton;
	
	@FindBy(id = "link-to-download")
	private WebElement downloadButton;
	
	public AlertModalsPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Check Bootstrap Alert.
	 * 
	 * @return instance of AlertModalsPage object.
	 */
	public AlertModalsPage checkBootstrapAlerts() {
		normalSuccessMessage.click();
		closeIcon.click();
		autocloseableMessage.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOf(visibleMessage));
		return new AlertModalsPage(driver);
	}

	/**
	 * Check Bootstrap Modals.
	 * 
	 * @return instance of AlertModalsPage object.
	 */
	public AlertModalsPage checkBootstrapModals() {
		singleModal.click();
		closeButton.click();
		driver.navigate().refresh();
		multipleModal.click();
		launchModal.click();
		saveButton.click();
		driver.navigate().refresh();
		return new AlertModalsPage(driver);
	}
	
	/**
	 * Close all opened pop-ups.
	 * 
	 * @return instance of AlertModalsPage object.
	 */
	public AlertModalsPage closePopups() {
		String MainWindow=driver.getWindowHandle();					
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();			
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                    driver.switchTo().window(ChildWindow);	                                                                                                           
                     driver.close();		
            }		
        }		
        driver.switchTo().window(MainWindow);				
		return new AlertModalsPage(driver);
	}

	/**
	 * Click buttons and close Window Pop-ups.
	 * 
	 * @return instance of AlertModalsPage object.
	 */
	public AlertModalsPage closeWindowPopup() {
		twitterButton.click();
		closePopups();
		facebookButton.click();
		closePopups();
		bothButton.click();
		closePopups();
		allButton.click();
		closePopups();
		return new AlertModalsPage(driver);
	}

	/**
	 * Show progress bar and wait until it closes.
	 * 
	 * @return instance of AlertModalsPage object.
	 */
	public AlertModalsPage showProgressBar() {
		showDialogButton.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal fade in']")));
		wait.until(ExpectedConditions.visibilityOf(showDialogButton));
		driver.navigate().refresh();
		return new AlertModalsPage(driver);
	}

	/**
	 * Click alert box.
	 * 
	 * @return instance of AlertModalsPage object.
	 */
	public AlertModalsPage alertBox() {
		firstAlert.click();
		driver.switchTo().alert().accept();
		return new AlertModalsPage(driver);
	}
	
	/**
	 * Click alert box and close.
	 * 
	 * @return instance of AlertModalsPage object.
	 */
	public AlertModalsPage confirmBox() {
		secondAlert.click();
		driver.switchTo().alert().dismiss();
		return new AlertModalsPage(driver);
	}
	
	/**
	 * Click alert box and insert message.
	 * 
	 * @param message
	 * 			message to insert into alert
	 * 
	 * @return instance of AlertModalsPage object.
	 */
	public AlertModalsPage alertSearchBox(String message) {
		thirdAlert.click();
		driver.switchTo().alert().sendKeys(message);
		driver.switchTo().alert().accept();
		return new AlertModalsPage(driver);
	}

	/**
	 * Generate file with specific text.
	 * 
	 * @param text
	 * 			text to add to the file
	 * 
	 * @return instance of AlertModalsPage object.
	 * @throws InterruptedException 
	 */
	public AlertModalsPage generateFile(String text) {
		textField.sendKeys(text);
		generateButton.click();
		downloadButton.click();
		return new AlertModalsPage(driver);
	}
	
}
