package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.PageAPI;

/**
 * Test class for Others scenario.
 * 
 * @author Alan Buda
 */
public class OthersTest {

	public PageAPI pageAPI = new PageAPI();
	
	@BeforeClass(description = "Initialize driver with specified properties")
	public void init() throws IOException {
		pageAPI.setDriver(30, TimeUnit.SECONDS);
	}
	
	@Test(description = "Open main page of Selenium East")				
	public void openMainPage() {
		pageAPI.openMainPage();		
	}
	
	@Test(description = "Do an exercises from Drag and Drop Demo", dependsOnMethods = "openMainPage")				
	public void dragAndDrop() {	
		pageAPI.pickDemo("Others", "Drag and Drop");
		pageAPI.dragAndDrop();
	}
	
	@Test(description = "Do an exercises from Dynamic Data Loading Demo", dependsOnMethods = "dragAndDrop")				
	public void dynamicData() {	
		pageAPI.pickDemo("Others", "Dynamic Data Loading");
		pageAPI.dynamicData();
	}
	
	@AfterClass(description = "Close all browser windows and safely end the session")
	public void afterTest() {
		pageAPI.closeDriver();		
	}		

}
