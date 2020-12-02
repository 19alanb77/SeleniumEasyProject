package Tests;

import org.testng.annotations.Test;

/**
 * Test class for Others scenario.
 * 
 * @author Alan Buda
 */
public class OthersTest extends BaseTest {
	
	@Test(description = "Do an exercises from Drag and Drop Demo")				
	public void dragAndDrop() {	
		pageAPI.pickDemo("Others", "Drag and Drop");
		pageAPI.dragAndDrop();
	}
	
	@Test(description = "Do an exercises from Dynamic Data Loading Demo", dependsOnMethods = "dragAndDrop")				
	public void dynamicData() {	
		pageAPI.pickDemo("Others", "Dynamic Data Loading");
		pageAPI.dynamicData();
	}	

}
