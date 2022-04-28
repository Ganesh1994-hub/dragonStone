package BaseLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {

	public static WebDriver d;
	 Properties prop;
	 public static ExtentReports extent;// reference variable of the extent report
	 public static ExtentTest logger;// Logger is used to receice status of extent report and we can print customized messages with help of it. 
	 ExtentSparkReporter spark;
	 @BeforeSuite
	 public void setUpSuit() // in before suite we have written the code we found on the extent reporting website.
	 {
		 
		  extent = new ExtentReports();// creating an object of extent report. Going forward extent can be used to perform various operations.
	      spark = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/Amazon.html"));
	      extent.attachReporter(spark);

	 }
	
	public TestBase() // constructor to initialize the property file
	{
		FileInputStream fis;
		try {
			prop=new Properties();
			fis = new FileInputStream("E:\\workspace_working\\Amazon_1\\src\\main\\java\\resources\\Property.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
	/*public void browserLaunching() throws IOException {
				
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver_win32\\chromedriver.exe");
			d = new ChromeDriver();
		}
		else {
			
			System.out.println("You have forgot to give browser name");
		}
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.get(prop.getProperty("url"));
	}*/
	
	public void browserLaunching(String browser) throws IOException, InterruptedException {
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();// This is webdriver manager foir this we have added BoniGracia dependancy in the POM file
												//By set up method we need not to set path for the drive as we used to do before also even if there 
												// there is upgrade in webdriver we need not to worry about it.
			d=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			d= new FirefoxDriver();
			
		}
		else {
			
			System.out.println("You have forgot to give browser name");
		}
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.get(prop.getProperty("url"));
		//Thread.sleep(10);
		
	}
	@AfterSuite
	public void afterSuit()
	{
		extent.flush();
		
	}
		
	}
	


