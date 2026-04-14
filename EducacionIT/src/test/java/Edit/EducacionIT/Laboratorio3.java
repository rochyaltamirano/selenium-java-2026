package Edit.EducacionIT;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio3 {
	String url = "https://automationexercise.com/login" ;
	String chromeDriverPath = "../EducacionIT/Drivers/chromedriver";

	@Test
	public void registrarUsuario() {
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		WebDriver driver = new ChromeDriver(options);
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		//Completar datos y clic en el botón
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Usuario1 A");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("usuario1a" + Math.random() +"@yopamil.com");

		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
		
		//Espera - cambio de página
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("uniform-id_gender1")));
		
		//Completar el formulario
		driver.findElement(By.id("uniform-id_gender1")).click(); //radioButton
		driver.findElement(By.id("password")).sendKeys("Password123");
		
		Select days = new Select(driver.findElement(By.id("days"))); //list
		days.selectByValue("18");
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByVisibleText("January");
		Select year = new Select (driver.findElement(By.name("years")));
		year.selectByIndex(12);
		
		driver.findElement(By.name("newsletter")).click(); //checkbox
		driver.findElement(By.name("optin")).click(); //checkbox
		
		driver.findElement(By.id("first_name")).sendKeys("Carlos");
		driver.findElement(By.id("last_name")).sendKeys("Lopez");
		driver.findElement(By.id("company")).sendKeys("Empresa SA");
		driver.findElement(By.name("address1")).sendKeys("Calle Falsa 123");
		
		
		Select country = new Select (driver.findElement(By.id("country")));
		country.selectByValue("Canada");
		driver.findElement(By.id("state")).sendKeys("Estado de Canada");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Otawa");
		driver.findElement(By.cssSelector("#zipcode")).sendKeys("B12300");
		driver.findElement(By.name("mobile_number")).sendKeys("0303456");
		
		driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();	
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-primary")));
		
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();

	}
}
