package Models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationCheckOut {
	
	WebDriver driver;
	
	public AutomationCheckOut(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='cart_navigation clearfix']/a")
	WebElement proceedToCheckoutButtonSummary;
	
	public WebElement clickproceedToCheckoutSummary()
	{
		return proceedToCheckoutButtonSummary;
	}
	
	@FindBy(css = "button[name='processAddress']")
	WebElement proceedToCheckoutButtonAddress;
	
	public WebElement clickproceedToCheckoutAddress()
	{
		return proceedToCheckoutButtonAddress;
	}
	
	@FindBy(id = "cgv")
	WebElement agreeTermsButton;
	
	public WebElement clickAgreeTerms()
	{
		return agreeTermsButton;
	}
	
	@FindBy(css = "button[name='processCarrier']")
	WebElement proceedToCheckoutButtonShip;
	
	public WebElement clickproceedToCheckoutShip()
	{
		return proceedToCheckoutButtonShip;
	}
	
	@FindBy(xpath = "//*[@class='cart_quantity text-center']/span")
	WebElement quantityOfProduct;
	
	public WebElement getQuantityOfProduct()
	{
		return quantityOfProduct;
	}
	
}
