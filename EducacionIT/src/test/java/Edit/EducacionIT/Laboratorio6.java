package Edit.EducacionIT;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Laboratorio6 {
	String url = "https://automationexercise.com" ;
	String chromeDriverPath = "../EducacionIT/Drivers/chromedriver";
	String firefoxDriverPath = "../EducacionIT/Drivers/geckodriver";
	WebDriver driver;
	
	@BeforeTest
	@Parameters("navegador")
	public void setUp(String navegador) {
		
		if (navegador.equalsIgnoreCase("Chrome")) {
			//Acciones propias para Chrome
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			
		} 
		else if (navegador.equalsIgnoreCase("Firefox")) {
			//Acciones propias para Firefox
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();
			
		}
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void goToContactUs() {		
		driver.findElement(By.linkText("Contact us")).click();
		
		driver.findElement(By.name("name")).sendKeys("Romina Perez");
		driver.findElement(By.name("email")).sendKeys("rperez@yopmail.com");
		driver.findElement(By.name("subject")).sendKeys("Consulta");	
		driver.findElement(By.id("message")).sendKeys("aqui va la consultita...");
		driver.findElement(By.name("upload_file")).sendKeys("/Users/rocioaltamirano/empleados.txt");
		driver.findElement(By.name("submit")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

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
