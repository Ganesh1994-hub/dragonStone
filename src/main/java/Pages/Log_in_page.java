package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseLayer.TestBase;

public class Log_in_page extends TestBase{
	
	//DriverConfiguration dc=new DriverConfiguration();
	WebDriver driver;
	@FindBy(xpath="//a[@id='nav-link-accountList']")
	WebElement LogInLink;
	
	//@FindBy(xpath="//h1[@class='a-spacing-small']")
	//WebElement signInText;
	
	@FindBy(name="email")
	WebElement emailTextBox;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement textBox;
	
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement password;
	
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement LogInButton;
	
	
	@FindBy(xpath="//span[text()='Hello, Ganesh']")
	WebElement username;
	
	public Log_in_page()// Initialiing the Page factory using constructor.
	{
		PageFactory.initElements(d, this);
	}
	
	
	public boolean LoginPageVerification()
	{
		boolean b=LogInLink.isDisplayed();
		return false;
	}
		
	public Homepage loggingIn(String emilorPhone,  String pass)
	{
		LogInLink.click();
		emailTextBox.sendKeys(emilorPhone);
		continueButton.click();
		password.sendKeys(pass);
		LogInButton.click();
		Assert.assertTrue(username.isDisplayed());
		System.out.println(username.getText());
		return new Homepage();
	}
	
	

	
}
