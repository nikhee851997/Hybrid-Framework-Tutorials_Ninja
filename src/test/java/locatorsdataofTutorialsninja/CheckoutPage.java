package locatorsdataofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage 
{

public WebDriver driver;
public Select s;

@FindBy(xpath="//div[@id='payment-new']/preceding::input[1]")
private WebElement newe;

@FindBy(xpath="//input[@id='input-payment-firstname']")
private WebElement fname;

@FindBy(xpath="//input[@id='input-payment-lastname']")
private WebElement lname;

@FindBy(xpath="//input[@id='input-payment-address-1']")
private WebElement add;

@FindBy(xpath="//input[@id='input-payment-city']")
private WebElement city;

@FindBy(xpath="//input[@id='input-payment-postcode']")
private WebElement post;

@FindBy(xpath="//select[@name='country_id'or @value='223']")
private WebElement contry;

@FindBy(xpath="//select[@name='zone_id' or @value='3673']")
private WebElement sate;

@FindBy(xpath="//div[@id='accordion']/descendant::input[10]")
private WebElement fisco;

@FindBy(xpath="//div[@id='shipping-existing']/following::input[@id='button-shipping-address']")
private WebElement secco;


@FindBy(xpath="//textarea[@name='comment']")
private WebElement commt;

@FindBy(xpath="//div[@class='buttons']/child::div/input")
private WebElement thirco;

@FindBy(xpath= "//input[@name='agree' and @value='1']")
private WebElement box;

@FindBy(xpath="//input[@name='agree']/following::input")
private WebElement fourco;

@FindBy(xpath="//input[@id='button-confirm']")
private WebElement fifco;

@FindBy(xpath= "//div[@id='content']/h1")
private WebElement notified;

public CheckoutPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


public void placementProcessInitial(String txt1,String txt2,String txt3,String txt4,String txt5)
{
	newe.click();
	fname.sendKeys(txt1);
	lname.sendKeys(txt2);
	add.sendKeys(txt3);
	city.sendKeys(txt4);
	post.sendKeys(txt5);
	s = new Select(contry);
	s.selectByVisibleText("United States");
    s= new Select(sate);
    s.selectByVisibleText("Virginia");
	fisco.click();
	
}

public void placementProcess(String txt6)
{
	secco.click();
	commt.sendKeys(txt6);
	thirco.click();
}

public void reachingToPlacement()
{
	box.click();
	fourco.click();
	fifco.click();
}

public boolean placement()
{
	boolean rest= notified.isDisplayed();
	return rest;
	
}




}