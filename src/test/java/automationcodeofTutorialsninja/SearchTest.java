package automationcodeofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commoncodeofTutorialsninja.Commondata;
import locatorsdataofTutorialsninja.AccountPage;
import locatorsdataofTutorialsninja.ItemDescPage;
import locatorsdataofTutorialsninja.LandingPage;
import locatorsdataofTutorialsninja.LoginPage;
import locatorsdataofTutorialsninja.SearchPage;

public class SearchTest extends Commondata
{
	public  WebDriver driver;
	public  SoftAssert Soft;
	public  LandingPage lan;
	public  LoginPage log;
	public  AccountPage act;
	public  SearchPage ser;
	public  ItemDescPage ds;	


public SearchTest() throws Exception 
{
		super();
}

@BeforeMethod
public void Setup()
{
	driver= OpenApplication();
	lan = new LandingPage(driver);
	
}
	
@Test(priority=1)
public void SearchWithValidProduct()
{
	log=lan.NavigateToLoginPage();
	act=log.NavigateToAccountPage(Pr.getProperty("CorrectEmail"),Pr.getProperty("CorrectPassword"));
	ser=act.navigateToSearchPage(Pr2.getProperty("Existingitem"));
	Soft = new SoftAssert();
    Soft.assertTrue(ser.availableProduct());
    ds=ser.navigateToItemDescPage();
	Soft.assertAll();
	
	
}
	
@Test(priority=2)
public void SearchWithInvalidProduct()
{
	log=lan.NavigateToLoginPage();
	act=log.NavigateToAccountPage(Pr.getProperty("CorrectEmail"),Pr.getProperty("CorrectPassword"));
	ser=act.navigateToSearchPage(Pr2.getProperty("NotExistingitem"));
	Soft = new SoftAssert();
    Soft.assertTrue(ser.notAvailableProduct());
	Soft.assertAll();
	
}

@Test(priority=3)
public void SearchWithNoProduct()
{
	
	log=lan.NavigateToLoginPage();
	act=log.NavigateToAccountPage(Pr.getProperty("CorrectEmail"),Pr.getProperty("CorrectPassword"));
	ser=act.SearchBN();
	Soft = new SoftAssert();	
	Soft.assertTrue(ser.notAvailableProduct());
	Soft.assertAll();
	
}
	
@AfterMethod
public void close() 
{
	driver.quit();
	
}
	
		
}
