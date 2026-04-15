package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Elemento/s a usar
	@FindBy(css="a[href='/login']")
	WebElement lnkSigIn;
	
	@FindBy(css="a[href='/products']")
	WebElement lnkProducts;
	
	
	//Definir el constructor de la pçagina
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
		
	//Acciones sobre los elementos
	public void clicEnLogin() {
		lnkSigIn.click();
	}
	
	public void clicEnProducts() {
		lnkProducts.click();
	}
}
