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
	
	@FindBy(css="input[data-qa='login-email']")
	WebElement txtTooltipCompletar;
	
	@FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']")
	WebElement txtIncorrectAccount;
	
	@FindBy(css="li:nth-child(10) a:nth-child(1)")
	WebElement txtLogged;
		
	
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
	
	public String getToolTipComplete() {		
		return txtTooltipCompletar.getAttribute("validationMessage");
	}
	
	public String getIncorrectAccount() {
		return txtIncorrectAccount.getText();
	}
	
	public boolean getLoggedUser() {
		return txtLogged.getText().contains("Logged in as");	
	}


}
