package Edit.EducacionIT;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Laboratorio5 {

	String url = "https://automationexercise.com" ;
	String driverPath = "../EducacionIT/Drivers/chromedriver";
	WebDriver driver;
	
	@BeforeSuite 
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void searchProduct() {
		
		driver.findElement(By.xpath("//a[@href='/products']")).click();
		
		WebElement txtBuscador = driver.findElement(By.id("search_product"));
		txtBuscador.sendKeys("dress");
		txtBuscador.sendKeys(Keys.ENTER);
		
		//Validación de resultado esperado
		String urlEsperada = "https://automationexercise.com/products";
		String tituloEsperado = "Automation Exercise - All Products";
		
		Assert.assertEquals(urlEsperada, driver.getCurrentUrl());
		Assert.assertEquals(tituloEsperado, driver.getTitle());
		
	}
	
	@Test
	public void goToContactUs() {		
		driver.findElement(By.linkText("Contact us")).click();
		
		driver.findElement(By.name("name")).sendKeys("Romina Perez");
		driver.findElement(By.name("email")).sendKeys("rperez@yopmail.com");
		driver.findElement(By.name("subject")).sendKeys("Consulta");	
		driver.findElement(By.id("message")).sendKeys("aqui va la consultita...");
		
		//subir un archivo adjunto
		driver.findElement(By.name("upload_file")).sendKeys("/Users/rocioaltamirano/empleados.txt");
	
		driver.findElement(By.name("submit")).click();
		
		// Esperar el alert
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

		// Interactuar
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		String msjEsperado = "Success! Your details have been submitted successfully.";
		WebElement msjObtenido = driver.findElement(By.cssSelector(".status.alert.alert-success"));
		
		Assert.assertEquals(msjEsperado, msjObtenido.getText());
	}
	
	@AfterSuite
	public void closePage() {
		driver.close();
	}
}
