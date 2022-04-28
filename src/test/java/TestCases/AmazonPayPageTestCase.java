package TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayer.TestBase;
import Pages.AmazonPayTransactionPage;
import Pages.Homepage;
import Pages.Log_in_page;

public class AmazonPayPageTestCase extends TestBase {

	Log_in_page lp;
	Homepage hp;
	AmazonPayTransactionPage ap;
	
	public AmazonPayPageTestCase()
	{
		super();
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) throws IOException, InterruptedException
	{
		browserLaunching(browser);
		lp=new Log_in_page();
		hp=new Homepage();
	}
	
	@Test
	public void allPreviousTransactions() throws InterruptedException
	{
		lp.loggingIn("8390731054", "Amazon1.");
		ap=hp.amazonPaySection();
		ap.pastTransactionsList();
	}
	
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
	
}
