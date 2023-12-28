package reportmanager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager 
{
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	

	public static  ExtentReports generateReport()
	{
		if(extent==null)
		{
		/*This is a class that is responsible for creating a testreport,
		  ExtentReports takes the data provided by ExtentSparkReporter and generates the HTML report.
		  This report typically includes information like test case status, execution times, log messages, screenshots, and 
		  other details you choose to include.*/
				
		extent = new ExtentReports();
		
	     // This is a class that observes all testcases results

        spark = new ExtentSparkReporter(System.getProperty("user.dir")+"\\ExtentReportSample\\");
	    spark.config().setTheme(Theme.DARK);
	    spark.config().setReportName("Tutorialsninja_Report");
	    spark.config().setDocumentTitle("ProjectN_ JIRAstory_QA/ExtentReports");
	    spark.config().setTimeStampFormat("MM/dd/yyyy HH:mm:ss");
	    
	    
		//It(ExtentSparkReporter) feeds that information to ExtentReports
	    

	    extent.attachReporter(spark);
		}
	    return extent;
		
	}
	
}
