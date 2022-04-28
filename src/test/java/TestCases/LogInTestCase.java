package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import BaseLayer.TestBase;
import Pages.Homepage;
import Pages.Log_in_page;
import Utilities.ExcelSheetDataReader;
import Utilities.SnapShot;

public class LogInTestCase extends TestBase {
	
	Homepage hp;
	Log_in_page lp;
	ExcelSheetDataReader er;
	SnapShot sp=new SnapShot();
	
	public LogInTestCase()
	{
		super();
	}
	
		
	@BeforeMethod
	@Parameters("browser")
	public void browserSetup(String browser) throws IOException, InterruptedException
	{
		browserLaunching(browser);
		//lp=PageFactory.initElements(d, Log_in_page.class);// Intialization of page Factory
		lp=new Log_in_page();
		hp=new Homepage();
		er=new ExcelSheetDataReader();
	}
	
	
	@Test(priority=1)
	public void verificationOfLoginPage() throws InterruptedException
	{
		
		
			logger=extent.createTest("Going to Loggin page");// Creation of test case 
			logger.info("Staring browser and verifying log in link");// putting some info about the test case
			Assert.assertTrue(lp.LoginPageVerification());// Actaul test validation point
			logger.fail("Verification failed");// Logger is to put logs in the extent report, declaration of it can be found in the test base class.
			
				
	}
	
	//@DataProvider
	public Object[][] fetchData() throws IOException
	{
		Object[][] data=er.dataReader("sheet1");
		
		return data;
	}
	
	//@Test(priority=2, dataProvider="fetchData")
	public void signIn(String userName, String Password)
	{
		hp= lp.loggingIn(userName,Password);
		
	}
	
	@Test(priority=3)
	public void createWishList() throws InterruptedException
	{
		logger=extent.createTest("Creating Wish List Test");
		logger.info("Creating wish list");
		hp= lp.loggingIn("8390731054", "Amazon1.");
		//hp.createWishList("Ganesh's Shopping List2");
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(sp.captureScreenPrint()).build());
			//createScreenCaptureFromPath this method copy the screen print from the path and put it into the report.
			//so the captureScreenPrint() that we have written in the utilities package should return the path from where screen print has to be picked up.
			
			
		}
		d.quit();
	}
	
	

}
