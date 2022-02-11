package Models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationHome {
	
	WebDriver driver;
	
	public AutomationHome(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='header_user_info']/a")
	WebElement signInButton;
	
	public WebElement clickSignInButton()
	{
		return signInButton;
	}
	
	@FindBy(className = "logout")
	WebElement signOutButton;
	
	public WebElement clickSignOut()
	{
		return signOutButton;
	}
	
	@FindBy(className = "sf-with-ul")
	WebElement womenButton;
	
	public void mouseOverWomenButton(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(womenButton).build().perform();
		action = null;
	}
	
	@FindBy(css = "a[title='T-shirts']")
	WebElement womenTshirtsButton;
	
	public WebElement clickWomenTshirts()
	{
		return womenTshirtsButton;
	}
	
	@FindBy(id = "search_query_top")
	WebElement serchTextBox;
	
	public WebElement enterSearch()
	{
		return serchTextBox;
	}
	
	@FindBy(css = "button[name='submit_search']")
	WebElement serchButton;
	
	public WebElement clickSearch()
	{
		return serchButton;
	}
	
}
