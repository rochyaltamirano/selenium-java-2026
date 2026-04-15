package Edit.EducacionIT;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;


public class Laboratorio6b {

	String url = "https://automationexercise.com/products" ;
	String driverPath = "../EducacionIT/Drivers/chromedriver";
	String dirEvidencias = "../EducacionIT/Evidencias/";
	String nombreDocumento = "Archivo_evidencias.docx";
	WebDriver driver;
	File pantalla;
	
	@BeforeSuite 
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void searchProductWithImages() throws IOException {
		//capturar pantalla
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "01_pantalla_inicial.jpg"));
				
		WebElement txtBuscador = driver.findElement(By.id("search_product"));
		txtBuscador.sendKeys("dress");

		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "02_producto_a_buscar.jpg"));

		driver.findElement(By.cssSelector(".fa.fa-search")).click();
		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "03_resultados_busqueda.jpg"));


		//Validación de resultado esperado
		String urlEsperada = "https://automationexercise.com/products?search=dress";
		String tituloEsperado = "Automation Exercise - All Products";
		
		Assert.assertEquals(urlEsperada, driver.getCurrentUrl());
		Assert.assertEquals(tituloEsperado, driver.getTitle());
		
	}

	
	@Test
	public void searchProductWithEvidenceDocument() throws IOException, InvalidFormatException, InterruptedException { //armado de documento con los prints
		CapturaEvidencia.escribirTituloEnDocumento(dirEvidencias + nombreDocumento, "Archivo de evidencias de Automation Exercise", 14);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img1.jpg",dirEvidencias + nombreDocumento, "Paso 1 - Pantalla Inicial");
		
		WebElement txtBuscador = driver.findElement(By.id("search_product"));
		txtBuscador.sendKeys("dress");
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img2.jpg", dirEvidencias + nombreDocumento, "Paso 2 - Producto a buscar");

		driver.findElement(By.cssSelector(".fa.fa-search")).click();
	
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img3.jpg", dirEvidencias + nombreDocumento, "Resultado obtenido");

				
		//Validación de resultado esperado
		String urlEsperada = "https://automationexercise.com/products?search=dress";
		String tituloEsperado = "Automation Exercise - All Products";
		
		Assert.assertEquals(urlEsperada, driver.getCurrentUrl());
		Assert.assertEquals(tituloEsperado, driver.getTitle());
		
	}
	

	@AfterSuite
	public void closePage() {
		driver.close();
	}
}
