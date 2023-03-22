package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent{

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(id="RememberMe")
	WebElement rememberMe;
	
	@FindBy(xpath ="//button[text()='Log in']")
	WebElement loginBtn;
	
	public void loginApplication()
	{
		waitForElemetToAppear(email);
		email.sendKeys("ratest1@gmail.com");
		password.sendKeys("Test@1234");
		loginBtn.click();
	}

}
