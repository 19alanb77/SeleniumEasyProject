package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.PageAPI;

/**
 * Test class for InputForms scenario.
 * 
 * @author Alan Buda
 */
public class InputFormsTest {

	public PageAPI pageAPI = new PageAPI();
	
	@BeforeClass(description = "Initialize driver with specified properties")
	public void init() throws IOException {
		pageAPI.setDriver(10, TimeUnit.SECONDS);
	}
	
	@Test(description = "Open main page of Selenium East")				
	public void openMainPage() {
		pageAPI.openMainPage();		
	}
	
	@Test(description = "Do an exercises from Simple Form Demo", dependsOnMethods = "openMainPage")				
	public void simpleFormDemoExercises() {	
//		pageAPI.pickDemo("Input Forms", "Simple Form Demo");
//		pageAPI.simpleFormDemo("Test Message","3","5");
	}
	
	@Test(description = "Do an exercises from Checkbox Demo", dependsOnMethods = "simpleFormDemoExercises")				
	public void checkboxDemoExercises() {
//		pageAPI.pickDemo("Input Forms", "Checkbox Demo");
//		pageAPI.checkboxDemo();
	}
	
	@Test(description = "Do an exercises from Radio Buttons Demo", dependsOnMethods = "checkboxDemoExercises")				
	public void radioButtonsDemoExercises() {
//		pageAPI.pickDemo("Input Forms", "Radio Buttons Demo");
//		pageAPI.radioButtonsDemo("Male","Female","5 to 15");
	}
	
	@Test(description = "Do an exercises from Select Dropdown List", dependsOnMethods = "radioButtonsDemoExercises")				
	public void selectDropdownListExercises() {
//		pageAPI.pickDemo("Input Forms", "Select Dropdown List");
//		pageAPI.selectDropdownList("Monday","New York","Ohio","Texas");
	}
	
	@Test(description = "Do an exercises from Input Form Submit", dependsOnMethods = "selectDropdownListExercises")				
	public void inputFormSubmitExercises() {
//		pageAPI.pickDemo("Input Forms", "Input Form Submit");
//		pageAPI.fillInputForm("Alan","Buda","alan@alan.com","345346343","Address 201", "Warsaw","Kansas","93-003","test@test.com","No","Description");
	}
	
	@Test(description = "Do an exercises from Ajax Form Submit", dependsOnMethods = "inputFormSubmitExercises")				
	public void ajaxFormSubmitExercises() {
//		pageAPI.pickDemo("Input Forms", "Ajax Form Submit");
//		pageAPI.sendAjaxForm("Alan","test comment");
	}
	
	@Test(description = "Do an exercises from JQuery Select dropdown", dependsOnMethods = "ajaxFormSubmitExercises")				
	public void jquerySelectDropdownExercises() {
		pageAPI.pickDemo("Input Forms", "JQuery Select dropdown");
		pageAPI.pickOptionFromDropdownList("Japan","Kentucky","Puerto Rico","Java");
	}
	
	@AfterClass(description = "Close all browser windows and safely end the session")
	public void afterTest() {
		pageAPI.closeDriver();		
	}		

}
