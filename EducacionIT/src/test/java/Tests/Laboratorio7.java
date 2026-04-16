package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.HomePage;

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
	public void goToLogin() {
		HomePage home = new HomePage(driver);
		home.clicEnLogin();
		
		Assert.assertEquals("https://automationexercise.com/login", driver.getCurrentUrl());	
	}
	
	
	@Test
	public void goToProducts() {
		HomePage home = new HomePage(driver);
		home.clicEnProducts();
		
		Assert.assertEquals("https://automationexercise.com/products", driver.getCurrentUrl());
	}
	
	@Test
	public void goToCart() {
		HomePage home = new HomePage(driver);
		home.clicEnCarrito();
		
		WebElement validateText = driver.findElement(By.cssSelector(".active"));
		Assert.assertEquals("Shopping Cart",validateText.getText());
		
		Assert.assertEquals("Automation Exercise - Checkout", driver.getTitle() );
	}
	

	@AfterSuite
	public void closePage() {
		driver.close();
	}
}
