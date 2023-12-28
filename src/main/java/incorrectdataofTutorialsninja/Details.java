package incorrectdataofTutorialsninja;

import java.util.Date;

public class Details 
{
	
	public static String GenerateEmailWithDateTimeStamp()
	{
		Date date = new Date();
		String Timestamp= date.toString().replace(" ", "_").replace(":", "_");
		
		return "nikhee" + Timestamp + "@gmail.com";
			
	}
	
	
	//public static final int EXPLICIT_WAIT =10;
	public static final int IMPLICIT_WAIT=10;
	
	
	
}
