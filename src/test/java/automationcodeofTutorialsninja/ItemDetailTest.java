package automationcodeofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commoncodeofTutorialsninja.Commondata;
import locatorsdataofTutorialsninja.AccountPage;
import locatorsdataofTutorialsninja.CartPage;
import locatorsdataofTutorialsninja.ItemDescPage;
import locatorsdataofTutorialsninja.LandingPage;
import locatorsdataofTutorialsninja.LoginPage;
import locatorsdataofTutorialsninja.SearchPage;

public class ItemDetailTest extends Commondata
{

	public WebDriver driver;
	public LandingPage lan;
	public LoginPage log;
	public AccountPage act;
	public SearchPage ser;
	public ItemDescPage ds;
	public CartPage car;
	public SoftAssert soft;
	
	
	

	
	public ItemDetailTest() throws Exception
	{
		super();
	}
	

@BeforeMethod
public void setup()
{
	driver=OpenApplication();
	lan=new LandingPage(driver);
}

@Test
public void detailsOfTheProudct()
{
	log=lan.NavigateToLoginPage();
	act=log.NavigateToAccountPage(Pr.getProperty("CorrectEmail"),Pr.getProperty("CorrectPassword"));
	ser=act.navigateToSearchPage(Pr2.getProperty("Existingitem"));
	ds=ser.navigateToItemDescPage();
	soft= new SoftAssert();
	soft.assertTrue(ds.item());
	ds.itemDet();
	soft.assertTrue(ds.displayPdctInfo());
	car=ds.navigateToCartPage();
	soft.assertAll();
}

@AfterMethod
public void close()
{
	driver.quit();
}

}
