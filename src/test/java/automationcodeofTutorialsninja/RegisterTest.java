package automationcodeofTutorialsninja;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commoncodeofTutorialsninja.Commondata;
import incorrectdataofTutorialsninja.Details;
import locatorsdataofTutorialsninja.AccountSuccessCreationPage;
import locatorsdataofTutorialsninja.LandingPage;
import locatorsdataofTutorialsninja.RegisterPage;

public class RegisterTest extends Commondata
{
	
	public  WebDriver driver;
	public  SoftAssert soft;
	public  LandingPage lan;
	public  RegisterPage reg;
	public  AccountSuccessCreationPage acs;
	
	
	

public RegisterTest() throws Exception 
{
		super();
}


@BeforeMethod
public void Setup()
{
	driver= OpenApplication();
	lan = new LandingPage(driver);
	reg= lan.NavigateToRegisterPage();
		
}

@Test(priority=1)
public void VerifyingRegisterWithAllDetails()
{
	
    acs =reg.registerPageAllDetails(Pr2.getProperty("Firstname"), Pr2.getProperty("Lastname"), 
		     Details.GenerateEmailWithDateTimeStamp(), Pr2.getProperty("Phonenumber"), Pr.getProperty("CorrectPassword"),
		     Pr.getProperty("CorrectPassword"));
    soft = new SoftAssert();
    soft.assertTrue(acs.notificationMessage());
    soft.assertAll();        
}

@Test(priority=2)
public void verifyingRegisterWithOnlyMandatoryDetails()
{
	
    acs =reg.registerPageMandatoryDetails(Pr2.getProperty("Firstname"), Pr2.getProperty("Lastname"), 
		     Details.GenerateEmailWithDateTimeStamp(), Pr2.getProperty("Phonenumber"), Pr.getProperty("CorrectPassword"),
		     Pr.getProperty("CorrectPassword"));
    soft = new SoftAssert();
    soft.assertTrue(acs.notificationMessage());
    soft.assertAll();
     
}

@Test(priority=3)
public void verifyingRegisterWithNoDetails()
{
	reg.Bttn();
    
    soft = new SoftAssert();
    soft.assertTrue(reg.registerPageNoDetails());
    soft.assertAll();  
   
}

@Test(priority=4)
public void VerifyRegisterWithDuplicateEmail()
{
	
	reg.registerPageAllDetails(Pr2.getProperty("Firstname"), Pr2.getProperty("Lastname"),
	  Pr.getProperty("CorrectEmail"),Pr2.getProperty("Phonenumber"),
	     Pr.getProperty("CorrectPassword"),Pr.getProperty("CorrectPassword"));
	
	
    soft = new SoftAssert();
    soft.assertTrue(reg.NegAlt());
    soft.assertAll();	
}

@AfterMethod

public void close()
{
	driver.quit();
	
}



}
