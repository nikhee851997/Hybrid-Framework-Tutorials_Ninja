package automationcodeofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import commoncodeofTutorialsninja.Commondata;
import locatorsdataofTutorialsninja.AccountPage;
import locatorsdataofTutorialsninja.AccountSuccessCreationPage;
import locatorsdataofTutorialsninja.LandingPage;
import locatorsdataofTutorialsninja.LoginPage;
import locatorsdataofTutorialsninja.LogoutPage;
import testcasedataofTutorialsninja.DatProvForLoginTutorialsninja;

public class LogoutTest extends Commondata
{
	
public WebDriver driver;
public LandingPage lan;
public LoginPage log;
public AccountPage ac;
public AccountSuccessCreationPage acs;
public LogoutPage lg;
public SoftAssert soft;



public LogoutTest()throws Exception
{
	super();
	
}

@BeforeMethod
public void setup()
{
	driver=OpenApplication();
	lan= new LandingPage(driver);
	log=lan.NavigateToLoginPage();
	
}
	
	
@Test(dataProvider="TN", dataProviderClass=DatProvForLoginTutorialsninja.class)
public void Lout(String ExcelEmail, String ExcelPassword)
{
	ac=log.NavigateToAccountPage(ExcelEmail, ExcelPassword);
	soft= new SoftAssert();
	soft.assertTrue(ac.ConfirmationLnk());
	lg=ac.navigateToLogoutPage();
	soft.assertTrue(lg.displaymg());
	lg.fshBatn();
	soft.assertAll();
		
}
	
	
@AfterMethod
public void close()
{
	driver.quit();
}
		
	
}
