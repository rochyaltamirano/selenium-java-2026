package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import Pages.LoginSignupPage;

public class LoginSignupTest {

	String url= "https://automationexercise.com/login";
	String driverPath = "../EducacionIT/Drivers/chromedriver";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginOK() {
		LoginSignupPage login = new LoginSignupPage(driver);
		login.completarEmail("juanita@yopmail.com");
		login.completarPassword("1q2w3e4r5t");
		
		login.clicEnLogin();
	
		Assert.assertTrue(login.getLoggedUser());
	}
	
	@Test
	public void loginInvalid() {
		LoginSignupPage login = new LoginSignupPage(driver);
		login.completarEmail("juanita123@yopmail.com");
		login.completarPassword("123");
		login.clicEnLogin();
			
		Assert.assertEquals("Your email or password is incorrect!", login.getIncorrectAccount());
	}
	
	@Test
	public void loginEmptyFields() {
		LoginSignupPage login = new LoginSignupPage (driver);
		login.clicEnLogin();

		Assert.assertEquals("Completa este campo", login.getToolTipComplete());
	}
	
	@AfterSuite
	public void closePage() {
		driver.close();
	}
}
