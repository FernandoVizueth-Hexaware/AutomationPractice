package Utilidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Utils {
	
	public WebDriver driver;

	public ArrayList<String> getExcelData(String sheetName, String testCaseName) throws IOException 
	{

		ArrayList<String> a = new ArrayList<String>();
		// fileInpoutStreamArgument
		FileInputStream fis = new FileInputStream(
				"C:/Users/vizu7/eclipse-workspace/AutomationPractice/AutomationPracticeDB.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		
		for (int i = 0; i < sheets; i++) 
		{
			System.out.println("Excel sheet: " + workbook.getSheetName(i));
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) //Sheet name
			{	
				//desired sheet - Collections of rows
				System.out.println("Encuentra la hoja");
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next(); 								//First row - Collection of cells
				Iterator<Cell> ce = firstrow.cellIterator();
				int k=0;
				int colun=0;
				while(ce.hasNext())
				{
					Cell value = ce.next();
					if( value.getStringCellValue().equalsIgnoreCase("TESTCASES") )  //Column name
					{	 	//ColumnName
						//desired column value
						colun=k;
						System.out.println("Columna: " + colun);
					}
					k++;
				}
				while(rows.hasNext()) 
				{
					Row r = rows.next();
					if( r.getCell(colun).getStringCellValue().equalsIgnoreCase(testCaseName) )  //Row name
					{
						Iterator<Cell> cv =  r.cellIterator();
						while(cv.hasNext())
						{
							Cell c = cv.next();
							if(c.getCellType()==CellType.STRING)
							{
								a.add(c.getStringCellValue());
							}
							else
							{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							i = sheets;
						}
					}
				}
			}
		}
		workbook.close();
		fis.close();
		return a;
	}
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\vizu7\\eclipse-workspace\\AutomationPractice\\src\\Utilidades\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		String strUrl = prop.getProperty("url");
		
		switch (browserName) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\vizu7\\eclipse-workspace\\AutomationPractice\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			break;
			
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\vizu7\\eclipse-workspace\\AutomationPractice\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			break;
			
			case "edge":
			break;
			
			case "InternetExplorer":
				System.setProperty("webdriver.ie.driver", "C:\\Users\\vizu7\\eclipse-workspace\\AutomationPractice\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			break;

		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(strUrl);
		return driver;
	}

}
