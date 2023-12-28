package locatorsdataofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{


public  WebDriver driver;

// Defining Objects

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailaddressfield;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordaddressfield;
	
	@FindBy(css ="input.btn.btn-primary")
	private WebElement loginbutton;
	
	@FindBy (xpath= "//div[contains(@class, 'alert')]")
	private WebElement alert;
	

	
	
// Intializing Objects by using Constructor
	
	public  LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this );
	}
	
// Actions on those Objects by using Methods
	
		
	public AccountPage NavigateToAccountPage(String emailtext, String passwordtext)
	{
		 emailaddressfield.sendKeys(emailtext);
		 passwordaddressfield.sendKeys(passwordtext);
		 loginbutton.click();
		 return new AccountPage(driver);	 
	}
	
	public void Btn()
	{
		loginbutton.click();
	}
	
	public boolean AlertPopup()
	{
		boolean POP = alert.isDisplayed();
		return POP;
	}
	
	
	
	
	
	
	
	
	
}
