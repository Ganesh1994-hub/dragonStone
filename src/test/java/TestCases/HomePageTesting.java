package TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayer.TestBase;
import Pages.Homepage;
import Pages.Log_in_page;

public class HomePageTesting extends TestBase{

	Log_in_page lp;
	Homepage hp;
	
	public HomePageTesting()
	{
		super();
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) throws IOException, InterruptedException
	{
		browserLaunching(browser);
		lp=new Log_in_page();
		//hp=new Homepage();
	}
	
	@Test
	public void searchAnItem()
	{
		logger=extent.createTest("Searching an Item");
		logger.info("This is to validate search functionality after logging");
		hp=lp.loggingIn("8390731054", "Amazon1.");
		hp.searchAnItam("The Alchemist");
		logger.pass("User was able to search the Alchemist book");
		
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
	
}
