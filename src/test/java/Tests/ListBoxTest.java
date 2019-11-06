package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.PageAPI;

/**
 * Test class for List Box scenario.
 * 
 * @author Alan Buda
 */
public class ListBoxTest {

	public PageAPI pageAPI = new PageAPI();
	
	@BeforeClass(description = "Initialize driver with specified properties")
	public void init() throws IOException {
		pageAPI.setDriver(30, TimeUnit.SECONDS);
	}
	
	@Test(description = "Open main page of Selenium East")				
	public void openMainPage() {
		pageAPI.openMainPage();		
	}
	
	@Test(description = "Do an exercises from Bootstrap List Box Demo", dependsOnMethods = "openMainPage")				
	public void bootstrapListBox() {	
		pageAPI.pickDemo("List Box", "Bootstrap List Box");
		pageAPI.bootstrapListBox("bootstrap-duallist","Cras justo odio");
	}
	
	@Test(description = "Do an exercises from JQuery List Box Demo", dependsOnMethods = "bootstrapListBox")				
	public void jqueryListBox() {	
		pageAPI.pickDemo("List Box", "JQuery List Box");
		pageAPI.jqueryListBox("Laura","Luiza","Helena");
	}
	
	@Test(description = "Do an exercises from Data List Filter Demo", dependsOnMethods = "jqueryListBox")				
	public void dataListFilter() {	
		pageAPI.pickDemo("List Box", "Data List Filter");
		pageAPI.listFilter("Brian");
	}

	@AfterClass(description = "Close all browser windows and safely end the session")
	public void afterTest() {
		pageAPI.closeDriver();		
	}		

}
