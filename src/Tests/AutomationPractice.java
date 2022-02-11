package Tests;

import org.testng.annotations.Test;

import Models.AutomationCheckOut;
import Models.AutomationHome;
import Models.AutomationLogin;
import Models.AutomationPersonalInformation;
import Models.AutomationWomenCloth;
import Utilidades.Utils;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

public class AutomationPractice extends Utils{
	
	@Test
	public void userRegistration() throws IOException {
		
		driver=initializeDriver();
		
		AutomationHome autoHome = new AutomationHome(driver);
		AutomationLogin autoLogin = new AutomationLogin(driver);
		AutomationPersonalInformation autoPerInfo = new AutomationPersonalInformation(driver);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		autoHome.clickSignInButton().click();
		autoLogin.enterCreateAccount().sendKeys("asd1234@hexa.com");
		autoLogin.clickCreateAccount().click();
		autoPerInfo.clickMsGender().click();
		autoPerInfo.enterFirstName().sendKeys("Fer");
		autoPerInfo.enterLastName().sendKeys("Vizu");
		autoPerInfo.enterPassword().sendKeys("Password");
		autoPerInfo.selectDayOfBirth();
		autoPerInfo.selectMonthOfBirth();
		autoPerInfo.selectYearOfBirth();
		autoPerInfo.enterAddress().sendKeys("Calle Insurgentes #1234");
		autoPerInfo.enterCity().sendKeys("Mexico City");
		autoPerInfo.selectState();
		autoPerInfo.enterZipCode().sendKeys("03020");
		autoPerInfo.enterMobilePhone().sendKeys("5520703031");
		autoPerInfo.enterAlias().clear();
		autoPerInfo.enterAlias().sendKeys("El canton");
		autoPerInfo.clickRegisterButton().click();
		Assert.assertTrue(autoHome.clickSignOut().isEnabled());
		
		//Release memory
		autoHome = null;
		autoLogin = null;
		autoPerInfo = null;
		
	}

	@Test
	public void invalidEmail() throws IOException {
		
		driver=initializeDriver();
		
		AutomationHome autoHome = new AutomationHome(driver);
		AutomationLogin autoLogin = new AutomationLogin(driver);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		autoHome.clickSignInButton().click();
		autoLogin.enterCreateAccount().sendKeys("asd1234");
		autoLogin.clickCreateAccount().click();
		Assert.assertEquals(autoLogin.getInvalidMailError().getText(), "Invalid email address.");
		
		//Release memory
		autoHome = null;
		autoLogin = null;
		
	}
	
	@Test
	public void mandatoryFieldsEmpty() throws IOException {
		
		//System.out.println("0");
		
		driver=initializeDriver();
		
		//System.out.println("1");
		
		AutomationHome autoHome = new AutomationHome(driver);
		//System.out.println("2");
		AutomationLogin autoLogin = new AutomationLogin(driver);
		//System.out.println("3");
		AutomationPersonalInformation autoPerInfo = new AutomationPersonalInformation(driver);
		
		//System.out.println("4");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("5");
		
		autoHome.clickSignInButton().click();
		autoLogin.enterCreateAccount().sendKeys("asd1235@hexa.com");
		autoLogin.clickCreateAccount().click();
		autoPerInfo.clickMsGender().click();
		autoPerInfo.enterFirstName().sendKeys("Fer");
		autoPerInfo.enterLastName().sendKeys("Vizu");
		autoPerInfo.enterPassword().sendKeys("Password");
		autoPerInfo.clickRegisterButton().click();
		Assert.assertTrue(autoPerInfo.getMandatoryFieldsError().isDisplayed());
	}
	
	@Test
	public void incorrectValuesInFields() throws IOException {
		
		driver=initializeDriver();
		
		AutomationHome autoHome = new AutomationHome(driver);
		AutomationLogin autoLogin = new AutomationLogin(driver);
		AutomationPersonalInformation autoPerInfo = new AutomationPersonalInformation(driver);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		autoHome.clickSignInButton().click();
		autoLogin.enterCreateAccount().sendKeys("asd12345@hexa.com");
		autoLogin.clickCreateAccount().click();
		autoPerInfo.clickMsGender().click();
		autoPerInfo.enterFirstName().sendKeys("Fer123");
		autoPerInfo.enterLastName().sendKeys("Vizu123");
		autoPerInfo.enterPassword().sendKeys("Password");
		autoPerInfo.selectDayOfBirth();
		autoPerInfo.selectMonthOfBirth();
		autoPerInfo.selectYearOfBirth();
		autoPerInfo.enterAddress().sendKeys("Calle Insurgentes #1234");
		autoPerInfo.enterCity().sendKeys("Mexico City");
		autoPerInfo.selectState();
		autoPerInfo.enterZipCode().sendKeys("03020abc");
		autoPerInfo.enterMobilePhone().sendKeys("5520703031abc");
		autoPerInfo.enterAlias().clear();
		autoPerInfo.enterAlias().sendKeys("El canton");
		autoPerInfo.clickRegisterButton().click();
		Assert.assertTrue(autoPerInfo.getInvalidFormatError().getText().contains(" is invalid."));
		
		//Release memory
		autoHome = null;
		autoLogin = null;
		autoPerInfo = null;
		
	}
	
	@Test
	public void searchProduct() throws IOException {
		
		driver=initializeDriver();
		
		AutomationHome autoHome = new AutomationHome(driver);
		AutomationWomenCloth autoWom = new AutomationWomenCloth(driver);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		autoHome.mouseOverWomenButton(driver);
		autoHome.clickWomenTshirts().click();
		String prodName = null;
		prodName = autoWom.getProductName().getText();
		System.out.println(prodName+" buscado");
		autoHome.enterSearch().sendKeys(prodName);
		autoHome.clickSearch().click();
		String prodFound = null;
		prodFound = autoWom.getFoundProductName().getText();
		System.out.println(prodFound+" encontrado");
		Assert.assertEquals(prodName, prodFound);
		
	}
	
	@Test
	public void buyProduct() throws IOException {
		
		driver=initializeDriver();
		
		//System.out.println(" 1");
		AutomationHome autoHome = new AutomationHome(driver);
		AutomationWomenCloth autoCloth = new AutomationWomenCloth(driver);
		AutomationCheckOut autoChOut = new AutomationCheckOut(driver);
		AutomationLogin autoLogin = new AutomationLogin(driver);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(" 4");
		autoHome.mouseOverWomenButton(driver);
		autoHome.clickWomenTshirts().click();
		autoCloth.mouseOverShirt(driver);
		autoCloth.clickMoreButton().click();
		autoCloth.enterIncreaseQuantity().clear();
		autoCloth.enterIncreaseQuantity().sendKeys("2");;
		autoCloth.selectSize("L");
		autoCloth.clickColor().click();
		autoCloth.clickAddToCart().click();
		autoCloth.clickproceedToCheckout().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		autoChOut.clickproceedToCheckoutSummary().click();
		autoLogin.enterEmail().sendKeys("asd1234@hexa.com");
		autoLogin.enterPassword().sendKeys("Password");
		autoLogin.clickSubmitLogin().click();
		autoChOut.clickproceedToCheckoutAddress().click();
		autoChOut.clickAgreeTerms().click();
		autoChOut.clickproceedToCheckoutShip().click();
		Assert.assertTrue(autoChOut.getQuantityOfProduct().isEnabled());
		
	}
	
	@Test
	public void addToWishlistError() throws IOException {
		
		driver=initializeDriver();
		
		AutomationHome autoHome = new AutomationHome(driver);
		AutomationWomenCloth autoCloth = new AutomationWomenCloth(driver);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		autoHome.mouseOverWomenButton(driver);
		autoHome.clickWomenTshirts().click();
		autoCloth.mouseOverShirt(driver);
		autoCloth.clickAddToWishlist().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(autoCloth.getManageWishlistError().isDisplayed());
		
	}
	
	@Test
	public void verifyTotalPriceChange() throws IOException {
		
		driver=initializeDriver();
		
		AutomationHome autoHome = new AutomationHome(driver);
		AutomationWomenCloth autoCloth = new AutomationWomenCloth(driver);
		AutomationCheckOut autoChOut = new AutomationCheckOut(driver);
		AutomationLogin autoLogin = new AutomationLogin(driver);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(" 4");
		autoHome.mouseOverWomenButton(driver);
		autoHome.clickWomenTshirts().click();
		autoCloth.mouseOverShirt(driver);
		autoCloth.clickMoreButton().click();
		autoCloth.enterIncreaseQuantity().clear();
		autoCloth.enterIncreaseQuantity().sendKeys("1");;
		autoCloth.selectSize("M");
		autoCloth.clickColor().click();
		autoCloth.clickAddToCart().click();
		autoCloth.clickproceedToCheckout().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterTest
	public void AfterTest() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//driver.close();
		//driver.quit();
		
	}
	
}
