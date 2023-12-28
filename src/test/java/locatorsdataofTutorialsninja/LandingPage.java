package locatorsdataofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage

{
public WebDriver driver;



//Defining Objects

@FindBy(linkText="My Account")
private WebElement MyAccountDropDown;

@FindBy(linkText="Login")
private  WebElement LoginOption;

@FindBy(linkText= "Register")
private WebElement RegisterOption;


// Intializing Objects by using constructor

public LandingPage(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver,this);
}

// Actions on those Objects by using Methods


public LoginPage NavigateToLoginPage()
{
	MyAccountDropDown.click();
	LoginOption.click();
	return new LoginPage(driver);
}


public RegisterPage NavigateToRegisterPage()
{
	MyAccountDropDown.click();
	RegisterOption.click();
	return new RegisterPage(driver);
}












}
