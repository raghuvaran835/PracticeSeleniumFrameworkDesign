package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	WebDriverWait wait;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	
	@FindBy(css="div[class='header-links'] a[href*='wishlist']")
	WebElement headerWishlist;
	
	@FindBy(css="div[class='header-links'] a[href*='cart']")
	WebElement headerCart;
	
	@FindBy(css="div[class='header-links'] a[href*='logout']")
	WebElement headerLogout;
	
	public void goTocartPage()
	{
		headerCart.click();
	}
	
	public void waitForElemetToAppear(By locator)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void waitForElemetToAppear(WebElement ele)
	{
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitForElemetToDisAppear(By locator)
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public void waitForElemetToDisAppear(WebElement ele)
	{
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
