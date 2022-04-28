package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.TestBase;

public class OrdersPage extends TestBase {
	
	
	
	@FindBy(xpath="//span[@class='a-color-secondary value']//following::bdi[text()='404-8045328-5684365']")
	WebElement getorderNum;
	
	
	
	@FindBy(xpath="//span[@id='a-autoid-0']")
	WebElement orderButtoun;
	
	
	@FindBy(id="searchOrdersInput")
	WebElement orderSearchField;
	
	public OrdersPage()
	{
		PageFactory.initElements(d, this);
	}
	
	public void searchaOrder()
	{
		//String ordernum=getorderNum.getText();
		orderSearchField.sendKeys("Ganesh");
		orderButtoun.click();
	}

}
