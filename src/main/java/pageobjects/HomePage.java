package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent{

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="div[class='header-links'] a[href*='login']")
	WebElement headerLogin;
	
	@FindBy(css="div[class='header-links'] a[href*='register']")
	WebElement headerRegister;
	
	@FindBy(css="div[class='header-links'] a[href*='wishlist']")
	WebElement headerWishlist;
	
	@FindBy(css="div[class='header-links'] a[href*='cart']")
	WebElement headerCart;
	
	@FindBy(css="div[class='header-links'] a[href*='logout']")
	WebElement headerLogout;
	
	@FindBy(css="div[class='header-links'] a[href*='customer/info']")
	WebElement headerMyAccount;
	
	public LoginPage goToLoginpage()
	{
		if(headerLogin.isDisplayed())
		{
			headerLogin.click();
		}
		else
		{
			headerLogout.click();
			waitForElemetToAppear(headerLogin);
			headerLogin.click();
		}
		
		return new LoginPage(driver);
		
	}
	public void goTocartPage()
	{
		headerCart.click();
	}

	
}
