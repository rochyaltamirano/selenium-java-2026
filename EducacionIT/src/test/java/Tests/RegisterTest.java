package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginSignupPage;
import Pages.RegisterPage;

public class RegisterTest {
	
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
	
	@BeforeTest
	public void createPage() {
		LoginSignupPage signUp = new LoginSignupPage(driver);
		signUp.completarName("Juanita");
		signUp.completarEmailAddress("juanita"+ Math.random() +"@yopmail.com");
		signUp.clicEnSignUp();
	}
	
	@Test
	public void EmptyPassword() {
		RegisterPage register = new RegisterPage(driver);	
		register.sendPassword("");
		register.clickCreateAccount();

		Assert.assertEquals("Completa este campo", register.getCompletePassword());
	}
	
	@Test
	public void EmptyFirstName() {
		RegisterPage register = new RegisterPage(driver);	
		register.sendPassword("123");
		register.clickCreateAccount();

		Assert.assertEquals("Completa este campo", register.getCompleteFirstName());
	}
	
	@Test
	public void EmptyLastName() {
		RegisterPage register = new RegisterPage(driver);	
		register.sendPassword("123");
		register.sendFirstName("Juana");
		register.clickCreateAccount();

		Assert.assertEquals("Completa este campo", register.getCompleteLastName());
	}
	
	@Test
	public void EmptyAddress1() {
		RegisterPage register = new RegisterPage(driver);	
		register.sendPassword("123");
		register.sendFirstName("Juana");
		register.sendLastName("Perez");
		register.clickCreateAccount();

		Assert.assertEquals("Completa este campo", register.getCompleteAddress1());
	}
	
	@Test
	public void EmptyState() {
		RegisterPage register = new RegisterPage(driver);	
		register.sendPassword("123");
		register.sendFirstName("Juana");
		register.sendLastName("Perez");
		register.sendAddresses("Av. Siempreviva 742", "Calle Falsa 123");
		register.clickCreateAccount();

		Assert.assertEquals("Completa este campo", register.getCompleteState());
	}	
	
	@Test
	public void EmptyCity() {
		RegisterPage register = new RegisterPage(driver);	
		register.sendPassword("123");
		register.sendFirstName("Juana");
		register.sendLastName("Perez");
		register.sendAddresses("Av. Siempreviva 742", "Calle Falsa 123");
		register.sendState("Estado del Testing");
		register.clickCreateAccount();

		Assert.assertEquals("Completa este campo", register.getCompleteCity());
	}
	
	@Test
	public void EmptyZipCode() {
		RegisterPage register = new RegisterPage(driver);	
		register.sendPassword("123");
		register.sendFirstName("Juana");
		register.sendLastName("Perez");
		register.sendAddresses("Av. Siempreviva 742", "Calle Falsa 123");
		register.sendState("Estado del Testing");
		register.sendCity("CABA");
		register.clickCreateAccount();

		Assert.assertEquals("Completa este campo", register.getCompleteZipCode());
	}
	
	@Test
	public void EmptyMobileNumber() {
		RegisterPage register = new RegisterPage(driver);	
		register.sendPassword("123");
		register.sendFirstName("Juana");
		register.sendLastName("Perez");
		register.sendAddresses("Av. Siempreviva 742", "Calle Falsa 123");
		register.sendState("Estado del Testing");
		register.sendCity("CABA");
		register.sendZipCode("BA1230");
		register.clickCreateAccount();

		Assert.assertEquals("Completa este campo", register.getCompleteMobileNumber());
	}
	
	@Test
	public void newUserSignUp() {			
		RegisterPage register = new RegisterPage(driver);
		register.selectTitle();
		register.sendPassword("");
		register.completeBirth("18", "January", "1990");
		register.selectCheckNewsletter();
		register.selectSpecialOffers();
		
		register.sendFirstName("Juana");
		register.sendLastName("Perez");
		register.sendCompany("Compania S.A.");
		register.sendAddresses("Av. Siempreviva 742", "Calle Falsa 123");
		register.selectCountry(2);
		register.sendState("Estado del Testing");
		register.sendCity("CABA");
		register.sendZipCode("BA1230");
		register.sendMobileNumber("0303456");
		
		register.clickCreateAccount();
		
		Assert.assertEquals("ACCOUNT CREATED!", register.getAccountCreated());
		
	}
		
	@AfterSuite
	public void closePage() {
		driver.close();
	}

}
