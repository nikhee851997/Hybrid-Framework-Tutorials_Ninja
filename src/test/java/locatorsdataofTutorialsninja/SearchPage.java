package locatorsdataofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage 
{
  public WebDriver driver;

@FindBy(linkText="HP LP3065")
private WebElement availa;

@FindBy(xpath= "//p[text()= 'There is no product that matches the search criteria.']")
private WebElement notavaila;

@FindBy(xpath="//div[@class='caption']/following::span")
private WebElement itemToCart;


		
  public SearchPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public boolean availableProduct() 
	{
		boolean res8= availa.isDisplayed();
		return res8;
		
	}
	
	public boolean notAvailableProduct() 
	{
		boolean res9= notavaila.isDisplayed();
		return res9;
		
	}
	
	public ItemDescPage navigateToItemDescPage()
	{
		itemToCart.click();
		return new ItemDescPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
