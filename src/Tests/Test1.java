package Tests;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utilidades.Utils;

public class Test1 {

	Utils util = new Utils();
	
	@Test
	public void TestCase1() throws IOException {
		
		//Invoke Browser
		//Chrome browser - ChromeDriver -> Methods
		//Firefox - FirefoxDriver -> Methods
		//Safari - SafariBrowser -> Methods
		
		//chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vizu7\\eclipse-workspace\\AutomationPractice\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.twitch.com");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.findElement(null).click();
		
		ArrayList <String> data = util.getExcelData("TESTDATA","userRegistration");  //(Sheet, TestName)
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		System.out.println(data.get(4));
		

	}

} 
