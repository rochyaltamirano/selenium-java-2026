package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.ProductPage;

public class ProductTest {
	String url= "https://automationexercise.com/products";
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
	public void searchProduct() {
		ProductPage productos = new ProductPage(driver);
		productos.writeProduct("dress");
		productos.searchProduct();
		
		WebElement validateText = driver.findElement(By.cssSelector(".title.text-center"));
		Assert.assertEquals("SEARCHED PRODUCTS", validateText.getText());
	}
	
	
	@AfterSuite
	public void closePage() {
		driver.close();
	}

}
