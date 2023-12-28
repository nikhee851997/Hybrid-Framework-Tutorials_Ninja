package automationcodeofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commoncodeofTutorialsninja.Commondata;
import locatorsdataofTutorialsninja.AccountPage;
import locatorsdataofTutorialsninja.CartPage;
import locatorsdataofTutorialsninja.CheckoutPage;
import locatorsdataofTutorialsninja.ItemDescPage;
import locatorsdataofTutorialsninja.LandingPage;
import locatorsdataofTutorialsninja.LoginPage;
import locatorsdataofTutorialsninja.SearchPage;

public class CheckoutTest extends Commondata
{
	
public WebDriver driver;
public LandingPage lan;
public LoginPage log;
public AccountPage act;
public SearchPage ser;
public ItemDescPage ds;
public CartPage car;
public CheckoutPage chk;
public SoftAssert soft;


public CheckoutTest() throws Exception
{
	super();
	
}

@BeforeMethod()
public void setup()
{
  driver= OpenApplication();
	
}
	
@Test
public void Finishh() throws Exception
{

	lan = new LandingPage(driver);
	log = lan.NavigateToLoginPage();
    act = log.NavigateToAccountPage(Pr.getProperty("CorrectEmail"),Pr.getProperty("CorrectPassword"));	
    ser = act.navigateToSearchPage(Pr2.getProperty("Existingitem"));
    soft= new SoftAssert();
    soft.assertTrue(ser.availableProduct());
    ds = ser.navigateToItemDescPage();
    car= ds.navigateToCartPage();
    chk=car.navigateToCheckOutPage();
    chk.placementProcessInitial(Pr2.getProperty("Firstname"), Pr2.getProperty("Lastname"), Pr2.getProperty("Adres"), Pr2.getProperty("Cty"), Pr2.getProperty("Pst"));
    Thread.sleep(2000);
    chk.placementProcess(Pr2.getProperty("Comnt"));
    Thread.sleep(2000);
    chk.reachingToPlacement();
    soft.assertTrue(chk.placement());
    soft.assertAll();
    
    
    
}
	

@AfterMethod
public void close()
{
	driver.quit();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
