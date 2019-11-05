package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.PageAPI;

/**
 * Test class for Table scenario.
 * 
 * @author Alan Buda
 */
public class TableTest {

	public PageAPI pageAPI = new PageAPI();
	
	@BeforeClass(description = "Initialize driver with specified properties")
	public void init() throws IOException {
		pageAPI.setDriver(10, TimeUnit.SECONDS);
	}
	
	@Test(description = "Open main page of Selenium East")				
	public void openMainPage() {
		pageAPI.openMainPage();		
	}
	
	@Test(description = "Do an exercises from Table Pagination Demo", dependsOnMethods = "openMainPage")				
	public void tablePaginationExercises() {	
		pageAPI.pickDemo("Table", "Table Pagination");
		pageAPI.tablePagination();
	}
	
	@Test(description = "Do an exercises from Table Data Search Demo", dependsOnMethods = "tablePaginationExercises")				
	public void tableDataSearchExercises() {	
		pageAPI.pickDemo("Table", "Table Data Search");
		pageAPI.tableDataSearch("Bootstrap 3","markino","4");
	}
	
	@Test(description = "Do an exercises from Table Filter Demo", dependsOnMethods = "tableDataSearchExercises")				
	public void tableFilterExercises() {	
		pageAPI.pickDemo("Table", "Table Filter ");
		pageAPI.tableFilter();
	}
	
	@Test(description = "Do an exercises from Table Sort & Search Demo", dependsOnMethods = "tableFilterExercises")				
	public void tableSortExercises() {	
		pageAPI.pickDemo("Table", "Table Sort & Search");
		pageAPI.sortTable("50","Age","Tokyo");
	}
	
	@AfterClass(description = "Close all browser windows and safely end the session")
	public void afterTest() {
		pageAPI.closeDriver();		
	}		

}
