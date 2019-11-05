package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.PageAPI;

/**
 * Test class for Progress Bars scenario.
 * 
 * @author Alan Buda
 */
public class ProgressBarsTest {

	public PageAPI pageAPI = new PageAPI();
	
	@BeforeClass(description = "Initialize driver with specified properties")
	public void init() throws IOException {
		pageAPI.setDriver(30, TimeUnit.SECONDS);
	}
	
	@Test(description = "Open main page of Selenium East")				
	public void openMainPage() {
		pageAPI.openMainPage();		
	}
	
	@Test(description = "Do an exercises from JQuery Download Progress bars Demo", dependsOnMethods = "openMainPage")				
	public void jqueryDownloadExercises() {	
		pageAPI.pickDemo("Progress Bars & Sliders", "JQuery Download Progress bars");
		pageAPI.jqueryDownload();
	}
	
	@Test(description = "Do an exercises from Bootstrap Progress bar Demo", dependsOnMethods = "jqueryDownloadExercises")				
	public void bootstrapProgressBarExercises() {	
		pageAPI.pickDemo("Progress Bars & Sliders", "Bootstrap Progress bar");
		pageAPI.bootstrapDownload();
	}
	
	@Test(description = "Do an exercises from Drag & Drop Sliders Demo", dependsOnMethods = "bootstrapProgressBarExercises")				
	public void dragDropSlidersExercises() {	
		pageAPI.pickDemo("Progress Bars & Sliders", "Drag & Drop Sliders");
		pageAPI.dragDropSliders();
	}

	@AfterClass(description = "Close all browser windows and safely end the session")
	public void afterTest() {
		pageAPI.closeDriver();		
	}		

}
