package Models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AutomationPersonalInformation {
	
	WebDriver driver;
	
	public AutomationPersonalInformation(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "id_gender1")
	WebElement msGenderButton;
	
	public WebElement clickMsGender()
	{
		return msGenderButton;
	}
	
	@FindBy(id = "customer_firstname")
	WebElement firstNameTextBox;
	
	public WebElement enterFirstName()
	{
		return firstNameTextBox;
	}
	
	@FindBy(id = "customer_lastname")
	WebElement lastNameTextBox;
	
	public WebElement enterLastName()
	{
		return lastNameTextBox;
	}
	
	@FindBy(id = "passwd")
	WebElement passwordTextBox;
	
	public WebElement enterPassword()
	{
		return passwordTextBox;
	}
	
	@FindBy(id = "days")
	WebElement dropdownDayOfBirth;
	
	public void selectDayOfBirth()
	{
		Select dropdown = new Select(dropdownDayOfBirth);
		dropdown.selectByValue("12");
	}
	
	@FindBy(id = "months")
	WebElement dropdownMonthOfBirth;
	
	public void selectMonthOfBirth()
	{
		Select dropdown = new Select(dropdownMonthOfBirth);
		dropdown.selectByVisibleText("January ");
	}
	
	@FindBy(id = "years")
	WebElement dropdownYearOfBirth;
	
	public void selectYearOfBirth()
	{
		Select dropdown = new Select(dropdownYearOfBirth);
		dropdown.selectByValue("1995");
	}
	
	@FindBy(id = "address1")
	WebElement addressTextBox;
	
	public WebElement enterAddress()
	{
		return addressTextBox;
	}
	
	@FindBy(id = "city")
	WebElement cityTextBox;
	
	public WebElement enterCity()
	{
		return cityTextBox;
	}
	
	@FindBy(id = "id_state")
	WebElement dropdownState;
	
	public void selectState()
	{
		Select dropdown = new Select(dropdownState);
		dropdown.selectByVisibleText("Alaska");
	}
	
	@FindBy(id = "postcode")
	WebElement zipCodeTextBox;
	
	public WebElement enterZipCode()
	{
		return zipCodeTextBox;
	}
	
	@FindBy(id = "phone_mobile")
	WebElement mobilePhoneTextBox;
	
	public WebElement enterMobilePhone()
	{
		return mobilePhoneTextBox;
	}
	
	@FindBy(id = "alias")
	WebElement aliasTextBox;
	
	public WebElement enterAlias()
	{
		return aliasTextBox;
	}
	
	@FindBy(id = "submitAccount")
	WebElement registerButton;
	
	public WebElement clickRegisterButton()
	{
		return registerButton;
	}
	
	@FindBy(css = "div[class='alert alert-danger']")
	WebElement mandatoryFieldsError;
	
	public WebElement getMandatoryFieldsError()
	{
		return mandatoryFieldsError;
	}
	
	@FindBy(xpath = "//*[@class='alert alert-danger']/ol/li")
	WebElement invalidFormatError;
	
	public WebElement getInvalidFormatError()
	{
		return invalidFormatError;
	}
	
}
