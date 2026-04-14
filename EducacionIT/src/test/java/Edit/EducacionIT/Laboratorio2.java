package Edit.EducacionIT;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio2 {
	String url = "https://automationteststore.com/" ;
	String chromeDriverPath = "../EducacionIT/Drivers/chromedriver";
	String firefoxDriverPath = "../EducacionIT/Drivers/geckodriver";

	
	@Test
	public void hacerBusquedaEnChrome() {
		//1)Indicar dónde está el driver a utilizar
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		//2) Acceder a la página que vamos a probar
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//Maximizar la pantalla
		driver.manage().window().maximize();
		
		//3) Escribir la palabra a buscar
		WebElement txtBuscador = driver.findElement(By.id("filter_keyword"));
		txtBuscador.sendKeys("bronzer");
		
		//4) Hacer la búsqueda
		txtBuscador.sendKeys(Keys.ENTER);
		
		System.out.println("getTitle(): " + driver.getTitle());

		System.out.println("getCurrentUrl(): " + driver.getCurrentUrl());
	}
	
	@Test
	public void hacerBusquedaEnFirefox() {
		//1)Indicar dónde está el driver a utilizar
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		
		//2) Acceder a la página que vamos a probar
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		//3) Escribir la palabra a buscar
		WebElement txtBuscador = driver.findElement(By.id("filter_keyword"));
		txtBuscador.sendKeys("bronzer");
		
		//4) Hacer la búsqueda
				txtBuscador.sendKeys(Keys.ENTER);
	}
}
