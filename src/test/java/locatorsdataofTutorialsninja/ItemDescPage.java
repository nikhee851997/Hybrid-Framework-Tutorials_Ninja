package locatorsdataofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDescPage 
{
	
public WebDriver driver;
	
@FindBy(linkText="HP LP3065")
private WebElement prdct;

@FindBy(xpath="//a[text()='Specification']")
private WebElement speovw;

@FindBy(xpath="//div[@id='tab-specification']")
private WebElement spedet;

@FindBy(xpath="//button[@id='button-cart']")
private WebElement cartProcessing;

@FindBy(xpath="//span[@id='cart-total']")
private WebElement cartProcessed;


	public ItemDescPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	public boolean item()
	{
	  boolean rest=prdct.isDisplayed();
	  return rest;
	}
	
	
	public void itemDet()
	{
		speovw.click();
	}
	
	public boolean displayPdctInfo()
	{
		boolean reu= spedet.isDisplayed();
		return reu;

	}
	public CartPage navigateToCartPage()
	{
		cartProcessing.click();
		cartProcessed.click();
		return new CartPage(driver);
	}
	
	
	
}
