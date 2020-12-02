package Tests;

import org.testng.annotations.Test;

/**
 * Test class for Alert & Modals scenario.
 * 
 * @author Alan Buda
 */
public class AlertModalsTest extends BaseTest {
	
	@Test(description = "Do an exercises from Bootstrap Alerts Demo")				
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

}
