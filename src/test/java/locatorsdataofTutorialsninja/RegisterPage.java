package locatorsdataofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage
{

	public WebDriver driver;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstnameOption;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastnameOption;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailOption;
	
	@FindBy(xpath= "//input[@id='input-telephone']")
	private WebElement telephoneOption;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordOption;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmOption;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement newsletterOption;
	
	@FindBy(xpath="//input[@name='agree' and @ value='1']")
	private WebElement agreeOption;
	
	@FindBy(css= "input.btn.btn-primary")
	private WebElement btnOption;
	
	
	
	
	@FindBy(xpath= "//div[contains(@class ,'alert-danger')]")
	private WebElement negativealert;
	
	@FindBy(xpath="//div[text() = 'First Name must be between 1 and 32 characters!']")
	private WebElement firstnamealert;
	
	@FindBy(xpath="//div[text() = 'Last Name must be between 1 and 32 characters!']")
	private WebElement lastnamealert;
	
	@FindBy(xpath= "//div[text() = 'E-Mail Address does not appear to be valid!']")
	private WebElement emailalert;
	
	@FindBy(xpath="//div[text() = 'Telephone must be between 3 and 32 characters!']")
	private WebElement telephonealert;
	
	@FindBy(xpath="//div[text() = 'Password must be between 4 and 20 characters!']")
	private WebElement passwordalert;
	
	

	
	public RegisterPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public AccountSuccessCreationPage registerPageAllDetails(String firsttext, String lasttext, String emailtext,  String telephonetext, String passwordtext, String confirmtext) 
	{
		firstnameOption.sendKeys(firsttext);
		
		lastnameOption.sendKeys(lasttext);
		
		emailOption.sendKeys(emailtext);

		telephoneOption.sendKeys(telephonetext);

		passwordOption.sendKeys(passwordtext);

		confirmOption.sendKeys(confirmtext);

		newsletterOption.click();

		agreeOption.click();

		btnOption.click();	
		return new AccountSuccessCreationPage(driver);
		
	}
	
	public AccountSuccessCreationPage registerPageMandatoryDetails(String firsttext, String lasttext, String emailtext,  String telephonetext, String passwordtext, String confirmtext) 
	{
		firstnameOption.sendKeys(firsttext);
		
		lastnameOption.sendKeys(lasttext);
		
		emailOption.sendKeys(emailtext);

		telephoneOption.sendKeys(telephonetext);

		passwordOption.sendKeys(passwordtext);

		confirmOption.sendKeys(confirmtext);

		agreeOption.click();

		btnOption.click();	
		return new AccountSuccessCreationPage(driver);
		
	}
	

	
	public boolean registerPageNoDetails()
	{
		
	boolean res1 = negativealert.isDisplayed();

	boolean res2= firstnamealert.isDisplayed();
	
	boolean res3= lastnamealert.isDisplayed();
	
	boolean res4= emailalert.isDisplayed();
	
	boolean res5= telephonealert.isDisplayed();
	
	boolean res6= passwordalert.isDisplayed();
	
	return res1 && res2 && res3 && res4 && res5 && res6;
	
	}
	
	
	

	public void Bttn()
	{
		btnOption.click();
	}
	
	
	public boolean NegAlt()
	{
		boolean res= negativealert.isDisplayed();
		return res;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
