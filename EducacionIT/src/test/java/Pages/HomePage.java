package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Elemento/s a usar
	@FindBy(css="a[href='/login']")
	private WebElement lnkSigIn;
	
	@FindBy(css="a[href='/products']")
	private WebElement lnkProducts;
	
	@FindBy(xpath="//a[normalize-space()='Cart']")
	private WebElement lnkCart;
	
	
	//Definir el constructor de la página
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
	
	public void clicEnCarrito() {
		lnkCart.click();
	}
}
