package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pages.PageAPI;

/**
 * Base class to manage driver, page objects and to open main page.
 * 
 * @author Alan Buda
 */
public abstract class BaseTest {
	
	public PageAPI pageAPI = new PageAPI();

	@BeforeClass(description = "Initialize driver with properties and open main page")
	public void init() throws IOException {
		pageAPI.setDriver(30, TimeUnit.SECONDS);
		pageAPI.openMainPage();
	}
	
	@AfterClass(description = "Close all browser windows and safely end the session")
	public void afterTest() {
		pageAPI.closeDriver();		
	}	
	
}
