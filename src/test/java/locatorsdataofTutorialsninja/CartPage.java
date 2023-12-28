package locatorsdataofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage
{
	
  public WebDriver driver;
  

  @FindBy(xpath="//input[contains(@name, 'option')]") // Not using
  private WebElement Date;
  
  @FindBy(xpath="//input[@name='quantity']")          // Not using
  private WebElement number;
  
  @FindBy(xpath="//p[@class='text-right']/a")
  private WebElement theCart;
  
  @FindBy(css="a.btn.btn-primary")
  private WebElement chek;
  

public CartPage(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver, this);
}


public CheckoutPage navigateToCheckOutPage()
{
	
	theCart.click();
	chek.click();
	return new CheckoutPage(driver);
}









}
