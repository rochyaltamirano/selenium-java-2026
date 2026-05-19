package TestsBDD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeTestBDD {
	
	String url= "https://automationexercise.com";
	String driverPath = "../EducacionIT/Drivers/chromedriver";
	WebDriver driver;
	
	@Given ("El usuario se encuentra en la pantalla Home")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("Hace clic en Login")
	public void goToLogin() {
		HomePage home = new HomePage(driver);
		home.clicEnLogin();
	}
	
	@Then("Se redirige a la pantalla de Login")
	public void onLoginPage() {
		Assert.assertEquals("https://automationexercise.com/login", driver.getCurrentUrl());
		driver.close();
	}
	
	@When("Hace clic en Products")
	public void goToProducts() {
		HomePage home = new HomePage(driver);
		home.clicEnProducts();
	}
	
	@Then("Se redirige a la pantalla de Products")
	public void onProductPge() {
		Assert.assertEquals("https://automationexercise.com/products", driver.getCurrentUrl());
		driver.close();
	}
	
	@When ("Hace clic en Carts")
	public void goToCart() {
		HomePage home = new HomePage(driver);
		home.clicEnCarrito();

	}
	
	@Then("Se redirige a la pantalla de Carts")
	public void onCartsPage() {
		WebElement validateText = driver.findElement(By.cssSelector(".active"));
		Assert.assertEquals("Shopping Cart",validateText.getText());
		
		Assert.assertEquals("Automation Exercise - Checkout", driver.getTitle());
		driver.close();
	}
	

}
