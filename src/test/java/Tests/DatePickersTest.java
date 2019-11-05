package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.PageAPI;

/**
 * Test class for Date Pickers scenario.
 * 
 * @author Alan Buda
 */
public class DatePickersTest {

	public PageAPI pageAPI = new PageAPI();
	
	@BeforeClass(description = "Initialize driver with specified properties")
	public void init() throws IOException {
		pageAPI.setDriver(10, TimeUnit.SECONDS);
	}
	
	@Test(description = "Open main page of Selenium East")				
	public void openMainPage() {
		pageAPI.openMainPage();		
	}
	
	@Test(description = "Do an exercises from Bootstrap Date Picker Demo", dependsOnMethods = "openMainPage")				
	public void bootstrapDateExercises() {	
		pageAPI.pickDemo("Date pickers", "Bootstrap Date Picker");
		pageAPI.bootstrapDateDemo();
	}
	
	@Test(description = "Do an exercises from JQuery Date Picker Demo", dependsOnMethods = "bootstrapDateExercises")				
	public void jqueryDateExercises() {
		pageAPI.pickDemo("Date pickers", "JQuery Date Picker");
		pageAPI.jqueryDateDemo("May");
	}
	
	@AfterClass(description = "Close all browser windows and safely end the session")
	public void afterTest() {
		pageAPI.closeDriver();		
	}		

}
