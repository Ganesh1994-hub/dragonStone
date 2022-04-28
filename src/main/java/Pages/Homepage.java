package Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseLayer.TestBase;

public class Homepage extends TestBase{

 Log_in_page lp=new Log_in_page();
 Actions act=new Actions(d);
 
	@FindBy(xpath="//a[@id='nav-orders']")
	WebElement returnAndOrder;
	
	@FindBy(xpath="//a[@id=\"nav-cart\"]")
	WebElement cart;
	
	@FindBy(xpath="//a[@data-csa-c-slot-id=\"nav_cs_0\"]")
	WebElement AmazonPay;
	
	@FindBy(xpath="//a[@data-csa-c-slot-id=\"nav_cs_4\"]")
	WebElement CustomerService;
	//
	
	@FindBy(xpath="/html/body/div[1]/header/div/div[3]/div[3]/div[2]/div/div[1]/div[3]/div/a[1]/span")
	WebElement createWishList;
	
	
	@FindBy(xpath="//input[@name='list-name']")
	WebElement wishListNameTextBox;
	
	@FindBy(xpath="//*[@id=\"wl-redesigned-create-list\"]/span")
	WebElement creatWishListbutton;
	
	@FindBy(xpath="//*[@id=\"a-popover-1\"]/div")
	WebElement form1;
	
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement magnifyGlassButton;
	
	/*@FindBys({
			@FindBy(xpath="//div[@id='nav-al-wishlist']//a")
					
	})
	public List<WebElement> List;*/
	
	
	@FindBy(xpath="//h1")
	WebElement yourOrderText;
	public Homepage()
	{
		PageFactory.initElements(d, this);
	}
	
	public void createWishList(String wishlistname) throws InterruptedException
	{
		
		
		act.moveToElement(lp.LogInLink).build().perform();
		Thread.sleep(4);
		createWishList.click();
		form1.click();
		WebDriverWait wait1=new WebDriverWait(d,Duration.ofSeconds(10));
		wishListNameTextBox.clear();
		wishListNameTextBox.sendKeys(wishlistname);
		WebDriverWait wait11=new WebDriverWait(d,Duration.ofSeconds(3));
		wait11.until(ExpectedConditions.visibilityOf(creatWishListbutton));
		creatWishListbutton.click();
		
		
		
	}
	public OrdersPage orderSection()
	{
		returnAndOrder.click();
		System.out.println(yourOrderText.getText());
		Assert.assertTrue(yourOrderText.isDisplayed());
		System.out.println("User lanaded on Order page");
		return new OrdersPage();
		
	}
	
		
	public AmazonPayTransactionPage amazonPaySection()
	{
		AmazonPay.click();
		return new AmazonPayTransactionPage();
		
	}
	
	public void searchAnItam(String itemName) {
		
		searchBox.clear();
		searchBox.sendKeys(itemName);
		magnifyGlassButton.click();
	}
	
	

}

