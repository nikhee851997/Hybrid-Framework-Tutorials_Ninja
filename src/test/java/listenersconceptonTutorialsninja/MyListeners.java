package listenersconceptonTutorialsninja;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import reportmanager.ExtentReportsManager;

public class MyListeners implements ITestListener
{

	public WebDriver driver;
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	
	

	@Test(priority=1)
	public void onStart(ITestContext context) 
	// ITestcontext is an Interface that shares data between testcases in same class.
	{
	
		String TestCase= context.getName();
		extent= ExtentReportsManager.generateReport();
		test= extent.createTest(TestCase);
		test.log(Status.INFO,  TestCase+ "  -------> Started Executing");
	}
	
	
	@Test(priority=2)
	public void onTestStart(ITestResult result)
	//ITestResult is an interface that provides result of test case execution
	{
	 	
	  String TestCases= result.getName();
	  test= extent.createTest(TestCases);
	  test.log(Status.INFO, TestCases+ "-----------> Executing is going on");
	 
			
	}
	
	
	@Test(priority=3)
	public void onTestSuccess(ITestResult result) 
	{
		String TestCaseexe= result.getName();
		 test.log(Status.PASS, TestCaseexe+ "--------> Passed Successfully");
		
	}
	
	
	@Test(priority=4)
	public void onTestFailure(ITestResult result) 
	{
		String TestCasefal = result.getName();
	    driver= null;
		
		try
		{
			//method chaining
		  driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) 
		{
			e.printStackTrace();
		}
		
		
		// TakesScreenshot is an interface that enables  driver to capture screenshot  
		// getScreenshotAs method captures screenshot and stores it in specified location.

		
		File Srce = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String Dest = System.getProperty("user.dir")+"\\test-output\\Screenshots\\" + TestCasefal+ ".png";
	    
		try 
		{
			FileHandler.copy(Srce, new File(Dest));
	    } 
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(Dest);
		System.out.println("Screenshot is captured for failed testcases in your folder!");
		System.out.println(result.getThrowable());
		test.log(Status.FAIL, TestCasefal+ "-----------> Failed");
	}

	@Test(priority=5)
	public void onTestSkipped(ITestResult result) 
	{
		String TestCaseikp = result.getName();
		test.log(Status.SKIP, TestCaseikp+ "---------->Skipped");
		
	}

	@Test(priority=6)
	public void onFinish(ITestContext context)
	{
		String TestCaselu = context.getName();
     	test = extent.createTest(TestCaselu);
		test.log(Status.INFO,TestCaselu+  "-------> Finished Executing");
		extent.flush();
		
		String PathOfExtentReport = System.getProperty("user.dir")+"\\ExtentReportSample\\Index.html";
		
		File ExtentReportPath = new File(PathOfExtentReport);
		try 
		{
		    Desktop.getDesktop().browse( ExtentReportPath.toURI()); // uri means Uniform Resource Identifier
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	

}
