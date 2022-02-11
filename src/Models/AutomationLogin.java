package Models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationLogin {
	
	WebDriver driver;
	
	public AutomationLogin(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "email_create")
	WebElement createAccountTextBox;
	
	public WebElement enterCreateAccount()
	{
		return createAccountTextBox;
	}
	
	@FindBy(id= "SubmitCreate")
	WebElement createAccountButton;
	
	public WebElement clickCreateAccount()
	{
		return createAccountButton;
	}
	
	@FindBy(id = "create_account_error")
	WebElement invalidMailError;
	
	public WebElement getInvalidMailError()
	{
		return invalidMailError;
	}
	
	@FindBy(id = "email")
	WebElement emailTextBox;
	
	public WebElement enterEmail()
	{
		return emailTextBox;
	}
	
	@FindBy(id = "passwd")
	WebElement passwordTextBox;
	
	public WebElement enterPassword()
	{
		return passwordTextBox;
	}
	
	@FindBy(id = "SubmitLogin")
	WebElement submitLoginButton;
	
	public WebElement clickSubmitLogin()
	{
		return submitLoginButton;
	}
	
}
