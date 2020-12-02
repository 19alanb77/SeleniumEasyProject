package Tests;

import org.testng.annotations.Test;

/**
 * Test class for Progress Bars scenario.
 * 
 * @author Alan Buda
 */
public class ProgressBarsTest extends BaseTest {
	
	@Test(description = "Do an exercises from JQuery Download Progress bars Demo")				
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

}
