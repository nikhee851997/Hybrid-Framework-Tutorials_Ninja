package locatorsdataofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage 

{
	
  public  WebDriver driver;
  
  
  // Defining Objects 
  @FindBy(xpath = "//a[text()= 'Modify your wish list']")
	private WebElement modificationlink;
  
  @FindBy(xpath = "//input[@name = 'search']")
	 private WebElement searchbar;

  @FindBy(xpath = "//button[contains(@class, 'btn-default')]")
	 private WebElement searchbutton;

  @FindBy(xpath = "//div[@class='list-group']/a[text()='Logout']")
  private WebElement outbtn;
  
  
 //Intializing Objects by using Constructor
 public AccountPage(WebDriver driver)
   {
	 
	this.driver= driver;
	PageFactory.initElements(driver,this);
   }
 
 
   //  Actions on those Objects by using Methods
 
 public boolean ConfirmationLnk()
   {
         boolean Status = modificationlink.isDisplayed();
         return Status;
   }
 
 public SearchPage navigateToSearchPage(String text)
 {
	 searchbar.sendKeys(text);
	 searchbutton.click();
	 return new SearchPage(driver);
 }
 
 
 public SearchPage SearchBN() 
 {
 	 searchbutton.click();
 	 return new SearchPage(driver);
 }

 public LogoutPage navigateToLogoutPage()
 {
	 outbtn.click();
	 return new LogoutPage(driver);
 }

}

