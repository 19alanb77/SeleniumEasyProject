package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.PageAPI;

/**
 * Test class for Alert & Modals scenario.
 * 
 * @author Alan Buda
 */
public class AlertModalsTest {

	public PageAPI pageAPI = new PageAPI();
	
	@BeforeClass(description = "Initialize driver with specified properties")
	public void init() throws IOException {
		pageAPI.setDriver(30, TimeUnit.SECONDS);
	}
	
	@Test(description = "Open main page of Selenium East")				
	public void openMainPage() {
		pageAPI.openMainPage();		
	}
	
	@Test(description = "Do an exercises from Bootstrap Alerts Demo", dependsOnMethods = "openMainPage")				
	public void bootstrapAlert() {	
		pageAPI.pickDemo("Alerts & Modals", "Bootstrap Alerts");
		pageAPI.bootstrapAlerts();
	}
	
	@Test(description = "Do an exercises from Bootstrap Modals Demo", dependsOnMethods = "bootstrapAlert")				
	public void bootstrapModal() {	
		pageAPI.pickDemo("Alerts & Modals", "Bootstrap Modals");
		pageAPI.bootstrapModals();
	}
	
	@Test(description = "Do an exercises from Window Popup Modal Demo", dependsOnMethods = "bootstrapModal")				
	public void windowPopupModal() {	
		pageAPI.pickDemo("Alerts & Modals", "Window Popup Modal");
		pageAPI.windowPopup();
	}
	
	@Test(description = "Do an exercises from Progress Bar Modal Demo", dependsOnMethods = "windowPopupModal")				
	public void progressBarModal() {	
		pageAPI.pickDemo("Alerts & Modals", "Progress Bar Modal");
		pageAPI.progressBarModal();
	}
	
	@Test(description = "Do an exercises from Javascript Alerts Demo", dependsOnMethods = "progressBarModal")				
	public void javascriptAlert() {	
		pageAPI.pickDemo("Alerts & Modals", "Javascript Alerts");
		pageAPI.javascriptAlerts("Test message");
	}
	
	@Test(description = "Do an exercises from File Download Demo", dependsOnMethods = "javascriptAlert")				
	public void fileDownload() {	
		pageAPI.pickDemo("Alerts & Modals", "File Download");
		pageAPI.fileDownload("Example text Alan Buda");
	}

	@AfterClass(description = "Close all browser windows and safely end the session")
	public void afterTest() {
		pageAPI.closeDriver();		
	}		

}
