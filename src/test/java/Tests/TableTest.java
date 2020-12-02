package Tests;

import org.testng.annotations.Test;

/**
 * Test class for Table scenario.
 * 
 * @author Alan Buda
 */
public class TableTest extends BaseTest {
	
	@Test(description = "Do an exercises from Table Pagination Demo")				
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

}
