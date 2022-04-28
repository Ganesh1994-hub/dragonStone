package TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayer.TestBase;
import Pages.Homepage;
import Pages.Log_in_page;
import Pages.OrdersPage;

public class orderpageTestCase extends TestBase {
	
	Homepage hp;
	Log_in_page lp;
	OrdersPage op;
	
	public orderpageTestCase()
	{
		super();
	}
	
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) throws IOException, InterruptedException
	{
		browserLaunching(browser);
		lp=new Log_in_page();
	}
	
	@Test
	public void clickOnOrderLink()
	{
		hp=lp.loggingIn("8390731054", "Amazon1.");
		op=hp.orderSection();
		op.searchaOrder();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
}
