package Tests;

import org.testng.annotations.Test;

/**
 * Test class for Date Pickers scenario.
 * 
 * @author Alan Buda
 */
public class DatePickersTest extends BaseTest {
	
	@Test(description = "Do an exercises from Bootstrap Date Picker Demo")				
	public void bootstrapDateExercises() {	
		pageAPI.pickDemo("Date pickers", "Bootstrap Date Picker");
		pageAPI.bootstrapDateDemo();
	}
	
	@Test(description = "Do an exercises from JQuery Date Picker Demo", dependsOnMethods = "bootstrapDateExercises")				
	public void jqueryDateExercises() {
		pageAPI.pickDemo("Date pickers", "JQuery Date Picker");
		pageAPI.jqueryDateDemo("May");
	}	

}
