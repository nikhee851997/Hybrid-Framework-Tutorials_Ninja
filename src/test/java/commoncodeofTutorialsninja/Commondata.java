package commoncodeofTutorialsninja;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import incorrectdataofTutorialsninja.Details;

public class Commondata 
{
	 public  ChromeOptions opt;
     public  WebDriver driver;
	 public  Properties Pr;
	 public  FileReader FR;
	 public  BufferedReader BR;
	 public  Properties Pr2;
	 public  FileReader FR2;
	 public  BufferedReader BR2;
	 
	 
     public Commondata() throws Exception
     {
       Pr = new Properties();
       
// Here the file that i provided has text base data that is why iam using Reader rather than InputStream, If it is byte data. then i use InputStream.
       FR = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\configdataofTutorialsninja\\Config.Properties");
       
       BR = new BufferedReader(FR);
       
       Pr.load(BR);
        
       Pr2= new Properties();
       
       FR2= new FileReader(System.getProperty("user.dir")+"\\src\\test\\java\\systemdataofTutorialsninja\\System.Properties");
        
       BR2 = new BufferedReader(FR2);
       
       Pr2.load(FR2);
       
     }
     
     
public WebDriver OpenApplication()
	{
	    opt = new ChromeOptions();
	    
		opt.addArguments("incognito");
		opt.addArguments("start-maximized");
		opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		opt.setExperimentalOption("excludeSwitches" , Arrays.asList("enable-automation" , "disable-infobars"));
		
		driver = new ChromeDriver(opt);
		driver.get(Pr.getProperty("URL"));
		
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Details.IMPLICIT_WAIT));
	    
        return driver;
        
   
	}
	
	
	
	
	
	
	
}
