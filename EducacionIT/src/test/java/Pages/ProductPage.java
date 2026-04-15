package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	@FindBy(id="search_product")
	WebElement txtBuscador;
	
	@FindBy(css=".fa.fa-search")
	WebElement btnSearch;
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void writeProduct(String product) {
		txtBuscador.sendKeys(product);
	}
	
	public void searchProduct() {
		btnSearch.click();
	}


}
