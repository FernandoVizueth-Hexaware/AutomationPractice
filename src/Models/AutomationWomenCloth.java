package Models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AutomationWomenCloth {
	
	WebDriver driver;
	
	public AutomationWomenCloth(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[contains(text(),'Faded Short Sleeve T-shirts')]")
	WebElement productName;
	
	public WebElement getProductName()
	{
		return productName;
	}
	
	@FindBy(xpath = "//*[@class='product-container']/div[2]/h5/a")
	WebElement foundProductName;
	
	public WebElement getFoundProductName()
	{
		return foundProductName;
	}
	
	@FindBy(className = "product-container")
	WebElement productWindow;
	
	public void mouseOverShirt(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(productWindow).build().perform();
		action = null;
	}
	
	@FindBy(xpath = "//*[@class='button lnk_view btn btn-default']")
	WebElement moreButton;
	
	public WebElement clickMoreButton()
	{
		return moreButton;
	}
	
	@FindBy(id = "quantity_wanted")
	WebElement increaseQuantity;
	
	public WebElement enterIncreaseQuantity()
	{
		return increaseQuantity;
	}
	
	@FindBy(id = "group_1")
	WebElement dropdownSize;
	
	public void selectSize(String size)
	{
		Select dropdown = new Select(dropdownSize);
		dropdown.selectByVisibleText(size);
	}
	
	@FindBy(id = "color_14")
	WebElement colorButton;
	
	public WebElement clickColor()
	{
		return colorButton;
	}
	
	@FindBy(xpath = "//*[@id='add_to_cart']/button")
	WebElement addToCartButton;
	
	public WebElement clickAddToCart()
	{
		return addToCartButton;
	}
	
	@FindBy(xpath = "//*[@title='Proceed to checkout']")
	WebElement proceedToCheckoutButton;
	
	public WebElement clickproceedToCheckout()
	{
		return proceedToCheckoutButton;
	}
	
	@FindBy(xpath = "//*[@class='addToWishlist wishlistProd_1']")
	WebElement addToWishlistButton;
	
	public WebElement clickAddToWishlist()
	{
		return addToWishlistButton;
	}
	
	@FindBy(className = "fancybox-error")
	WebElement manageWishlistError;
	
	public WebElement getManageWishlistError()
	{
		return manageWishlistError;
	}
	
}
