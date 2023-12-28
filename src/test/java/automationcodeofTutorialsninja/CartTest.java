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

public class CartTest extends Commondata
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




public CartTest() throws Exception
{
	super();
}

@BeforeMethod
public void setup()
{
	driver=OpenApplication();
	
}

@Test
public void addItemsToCart()
{
	
	lan = new LandingPage(driver);
    log = lan.NavigateToLoginPage();
    act = log.NavigateToAccountPage(Pr.getProperty("CorrectEmail"), Pr.getProperty("CorrectPassword"));
    ser = act.navigateToSearchPage(Pr2.getProperty("Existingitem"));
    soft= new SoftAssert();
    soft.assertTrue(ser.availableProduct());
    ds=ser.navigateToItemDescPage();
    car=ds.navigateToCartPage();
    chk= car.navigateToCheckOutPage();
    soft.assertAll();

} 
     


@AfterMethod
public void close()
{
driver.quit();
}



}
