package locatorsdataofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage 
{
public WebDriver driver;

@FindBy(xpath="//div[@id='content']/p[1]")
private WebElement message;


@FindBy(xpath="//a[text()='Continue']")
private WebElement batan;
	
	
	
public LogoutPage(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver, this);
}
	
	
	
public boolean displaymg()
{
		boolean res = message.isDisplayed();
		return res;
}
	
	
public void fshBatn()
{
		batan.click();
}
	
	
}