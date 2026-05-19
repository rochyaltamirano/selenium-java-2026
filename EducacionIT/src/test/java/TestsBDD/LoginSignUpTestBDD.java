package TestsBDD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.LoginSignupPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSignUpTestBDD {
	String url= "https://automationexercise.com/login";
	String driverPath = "../EducacionIT/Drivers/chromedriver";
	WebDriver driver;
	LoginSignupPage login;
	
	@Given ("El usuario se encuentra en la pantalla de Login")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		login = new LoginSignupPage(driver);
	}
	
	@When("ingresa un usuario y contraseña válidos")
	public void ingresarCredenciales() {
		login.completarEmail("juanita@yopmail.com");
		login.completarPassword("1q2w3e4r5t");
	}
	
	@When ("hace clic en el botón de Login")
	public void loginOK() {
		login.clicEnLogin();
	}
	
	@Then ("El usuario se encuentra logueado OK")
	public void loggedUserOk() {
		Assert.assertTrue(login.getLoggedUser());
		
		driver.close();
	}
	
	@When ("ingresa un usuario o contraseña inválidos")
	public void ingresarCredencialesIncorrectas() {
		login.completarEmail("juanita123@yopmail.com");
		login.completarPassword("123");
		
	}
	
	@Then ("El usuario no se encuentra logueado")
	public void loginInvalid() {
		Assert.assertEquals("Your email or password is incorrect!", login.getIncorrectAccount());
		
		driver.close();
	}
	
	@Then ("se visualiza el pop up de Completa este campo")
	public void loginEmptyFields() {
		Assert.assertEquals("Completa este campo", login.getToolTipComplete());
		driver.close();
	}

}
