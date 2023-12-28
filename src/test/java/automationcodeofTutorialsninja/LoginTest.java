package automationcodeofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import commoncodeofTutorialsninja.Commondata;
import incorrectdataofTutorialsninja.Details;
import locatorsdataofTutorialsninja.AccountPage;
import locatorsdataofTutorialsninja.LandingPage;
import locatorsdataofTutorialsninja.LoginPage;
import testcasedataofTutorialsninja.DatProvForLoginTutorialsninja;

public class LoginTest extends Commondata
 {
	
	public WebDriver driver;
	public SoftAssert Soft;
    public LandingPage lan;
    public LoginPage log;
    public AccountPage account;
    
    
    
	
 public LoginTest() throws Exception
 {
		super();
 }


@BeforeMethod
public void Setup()
{
	driver= OpenApplication();
	lan = new LandingPage(driver);
	log=lan.NavigateToLoginPage();
	
}


@Test(priority=1,dataProvider="TN",dataProviderClass= DatProvForLoginTutorialsninja.class)
public void VerifyLoginWithValidCredentials(String ExcelEmail, String ExcelPassword) 
{
	//account =log.NavigateToAccountPage(Pr.getProperty("CorrectEmail"), Pr.getProperty("CorrectPassword"));
	account= log.NavigateToAccountPage(ExcelEmail, ExcelPassword);
	Soft = new SoftAssert();
    Soft.assertTrue(account.ConfirmationLnk());
    Soft.assertAll();
    
  }

@Test(priority=2)
public void VerifyLoginWithValidEmailInvalidPassword()
{
	log.NavigateToAccountPage(Pr.getProperty("CorrectEmail"), Pr2.getProperty("IncorrectPassword"));
	Soft = new SoftAssert();
	Soft.assertTrue(log.AlertPopup());
	Soft.assertAll();
	
}


@Test(priority=3)
public void VerifyLoginWithInvalidEmailValidPassword()
{
    	
    log.NavigateToAccountPage(Details.GenerateEmailWithDateTimeStamp(), Pr.getProperty("CorrectPassword"));
	Soft = new SoftAssert();
	Soft.assertTrue(log.AlertPopup());
    Soft.assertAll();
    
}


@Test(priority=4)
public void VerifyLoginWithInvalidCredentials()
{
	log.NavigateToAccountPage(Details.GenerateEmailWithDateTimeStamp(), Pr2.getProperty("IncorrectPassword"));
	Soft = new SoftAssert();
	Soft.assertTrue(log.AlertPopup());
    Soft.assertAll();
    
}


@Test(priority=5)
public void VerifyLoginWithNoCredentials()

{	
	log.Btn();
	Soft = new SoftAssert();
	Soft.assertFalse(log.AlertPopup());
	Soft.assertAll();
	
}

@AfterMethod
public void close()
{
	driver.quit();
}


}
