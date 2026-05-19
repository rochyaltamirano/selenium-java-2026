package Edit.EducacionIT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginSignupPage;
import Utilidades.DatosExcel;

public class Laboratorio8 {

	String url = "https://automationexercise.com/login";
	String driverPath = "../EducacionIT/Drivers/chromedriver";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos del Excel para login")
	public void login(String email, String password) {
		LoginSignupPage login = new LoginSignupPage(driver);
		
		//Ingresar credenciales
		login.completarEmail(email);
		login.completarPassword(password);
		
		login.clicEnLogin();
		
	
		try {
			//Comprobación de si el usuario uso iniciar sesión
			Assert.assertTrue(login.getLoggedUser());
			
			login.clicEnlogOut();
		}
		catch(Exception ex) {
			Assert.assertEquals("Your email or password is incorrect!", login.getIncorrectAccount());
			
		}
	}
	
	@DataProvider(name="Datos del login")
	public Object [][] obtenerDatos(){
		Object [][] datos = new Object [3][2];
		
		//Completar las combinaciones de datos para probar el login
		datos [0][0] = "abc@correo.com";
		datos [0][1] = "1234";
		
		datos [1][0] = "def@correo.com";
		datos [1][1] = "1q2w3e4r5t";
		
		datos [2][0] = "ghio@correo.com";
		datos [2][1] = "saaasa";
		
		return datos;
	}
	
	//imoortar datos del login desde un archivo excel
	@DataProvider(name="Datos del Excel para login")
	public Object [][] obtenerDatosExcel() throws Exception{
		return DatosExcel.leerExcel("../EducacionIT/Datos/DatosLogin.xlsx", "Hoja1");
	}
	
	@AfterSuite
	public void closePage() {
		driver.close();
	}
	
}
