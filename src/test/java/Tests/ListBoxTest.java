package Tests;

import org.testng.annotations.Test;

/**
 * Test class for List Box scenario.
 * 
 * @author Alan Buda
 */
public class ListBoxTest extends BaseTest {
	
	@Test(description = "Do an exercises from Bootstrap List Box Demo")				
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

}
