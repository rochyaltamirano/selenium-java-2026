package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginSignupPage;
import Pages.ProductPage;
import Pages.RegisterPage;

public class Laboratorio7 {
	
	String url= "https://automationexercise.com";
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
	public void login() {
		//Paso 1: Clic en SigIn
		HomePage home = new HomePage(driver);
		home.clicEnLogin();
		
		//Paso 2: Ingresar credenciales
		LoginSignupPage login = new LoginSignupPage(driver);
		login.completarEmail("correo1@yopmail.com");
		login.completarPassword("1q2w3e4r5t");
		
		//Paso 3: Clic en el botón
		login.clicEnLogin();
	}

	@Test
	public void searchProduct() {
		HomePage home = new HomePage(driver);
		home.clicEnProducts();
		
		ProductPage productos = new ProductPage(driver);
		productos.writeProduct("dress");
		productos.searchProduct();
		
	}
	
	@Test
	public void newUserSignUp() {
		HomePage home = new HomePage(driver);
		home.clicEnLogin();
		
		LoginSignupPage signUp = new LoginSignupPage(driver);
		signUp.completarName("Juanita");
		signUp.completarEmailAddress("juanita123@yopmail.com");
		signUp.clicEnSignUp();
		
		RegisterPage register = new RegisterPage(driver);
		register.selectTitle();
		register.sendPassword("1q2w3e4r5t");
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
		
	}

}
