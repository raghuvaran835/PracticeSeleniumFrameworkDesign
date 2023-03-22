package rahulshettyacademy.PracticeSeleniumgrameworkdesign;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class StandAloneTest extends BaseTest{

	
	@Test
	public void e2etest() throws IOException
	{
		
		LoginPage loginPage=homePage.goToLoginpage();
		loginPage.loginApplication();
		
	}
}
