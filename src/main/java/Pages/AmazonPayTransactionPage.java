package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.TestBase;

public class AmazonPayTransactionPage extends TestBase {

	int count=0;
	@FindBy(xpath = "//div[@id='all-tab-desktop']//span//span")
	WebElement AllTransactions;

	@FindBys({
		
			@FindBy(xpath = "//a[@href='javascript:void(0)' and @role='button' and not(@id='apb-heading-desktop')]")
			
	})
	List<WebElement> pastTransactions;
	
	

	@FindBy(xpath = "//div[@class='a-column a-span4 a-text-right a-span-last']//span[@class='a-size-small a-color-attainable']")
	WebElement PayBalance;
	
	

	@FindBy(xpath = "//span[text()='Your Transactions']")
	WebElement yourtansactionButton;
	
	public AmazonPayTransactionPage() {
		PageFactory.initElements(d, this);
	}
	
	
	public void pastTransactionsList() throws InterruptedException
	{
		yourtansactionButton.click();
		AllTransactions.click();
		for(int i=0;i<pastTransactions.size();i++)
		{
			count++;
			String s=pastTransactions.get(i).getText();
			
			System.out.println("Text of "+count+" Transaction is "+s);
			//WebDriverWait wait=new WebDriverWait(d, Duration.ofSeconds(5));
			//Thread.sleep(5);
			//pastTransactions.get(i).click();
		}
		
		
	}
	
	
	
}
