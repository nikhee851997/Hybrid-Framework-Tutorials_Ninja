package testcasedataofTutorialsninja;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class DatProvForLoginTutorialsninja
{
	public static FileInputStream F;
	

    @DataProvider(name="TN")
	public static  Object[][] readDataFromExcel() throws Exception 
	{
		F = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\testcasedataofTutorialsninja\\ExcelData.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook(F);
		
		XSSFSheet  sheet = book.getSheet("LoginTN");
		
		int rows = sheet.getLastRowNum();
		int coloumns = sheet.getRow(0).getLastCellNum();
		
		Object[][] excelData = new Object[rows][coloumns];
		
		for(int i=0; i<rows; i++) // this will correspond to 1strow (which is header row) in excel sheet.
		{
			XSSFRow row= sheet.getRow(i+1);
		   
			for(int j=0; j<coloumns; j++)
			{
				XSSFCell cell = row.getCell(j);
			
		     CellType type = cell.getCellType();
				switch(type)
				{
				
				case STRING:  excelData[i][j]= cell.getStringCellValue();
				break;
				case NUMERIC: excelData[i][j]= Integer.toString((int)cell.getNumericCellValue());
				break;
				case BOOLEAN: excelData[i][j]= cell.getBooleanCellValue();
				break;
				default:
					break;
				}
			}
		}
		book.close();
		return excelData;
		
				
}
	
}

	
	
	
	
	
	
	
	
	
	
