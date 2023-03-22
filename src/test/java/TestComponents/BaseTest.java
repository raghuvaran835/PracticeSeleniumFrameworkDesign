package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;

public class BaseTest {

	public static Properties prop=new Properties();
	WebDriver driver;
	protected HomePage homePage;
	public WebDriver initializeDriver() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\resources\\Globaldata.properties";
		FileInputStream fis=new FileInputStream(new File(path));
		prop.load(fis);
		
		String browsername=System.getProperty("browser") !=null ? System.getProperty("browser"):prop.getProperty("browser");
		
		if(browsername.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			
			if(browsername.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			
		}
		else if(browsername.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public void launchApplication() throws IOException
	{
		driver=initializeDriver();
		driver.get("https://demo.nopcommerce.com/");
		homePage=new HomePage(driver);
		
	}
	
	@AfterMethod
	public void closeApplication() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}
