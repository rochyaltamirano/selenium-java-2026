package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSignupPage {
	
	@FindBy(css="input[data-qa='login-email']")
	WebElement txtEmail;

	@FindBy(name="password")
	WebElement txtPassword;

	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btnLogin;
	
	@FindBy(css="input[placeholder='Name']")
	WebElement txtName;
	
	@FindBy(css="input[data-qa='signup-email']")
	WebElement txtemailAddress;
	
	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement btnSignUp;
	
	
	public LoginSignupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void completarEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void completarPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	
	public void clicEnLogin() {
		btnLogin.click();
	}
	
	public void completarName(String name) {
		txtName.sendKeys(name);
	}
	
	public void completarEmailAddress(String email) {
		txtemailAddress.sendKeys(email);
	}
	
	public void clicEnSignUp() {
		btnSignUp.click();
	}

}
