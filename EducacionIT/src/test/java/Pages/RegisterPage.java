package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	
	@FindBy(id="id_gender2")
	WebElement rdbtnMrs;
	
	@FindBy(id="name")
	WebElement txtName;
	
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="days")
	WebElement days;
	
	@FindBy(id="months")
	WebElement months;
	
	@FindBy (id="years")
	WebElement years;
	
	@FindBy(id="newsletter")
	WebElement newsletter;
	
	@FindBy(id="optin")
	WebElement specialOffers;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="last_name")
	WebElement lastName;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="address1")
	WebElement address1;

	@FindBy(id="address2")
	WebElement address2;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="zipcode")
	WebElement zipcode;
	
	@FindBy(name="mobile_number")
	WebElement mobile_number;
	
	@FindBy(css="button[data-qa='create-account']")
	WebElement btnCreateAccount;
	
	@FindBy(xpath="//b[normalize-space()='Account Created!']")
	WebElement txtAccountCreated;
	
	
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selectTitle() {
		rdbtnMrs.click();
	}
	
	public void sendName(String name) {
		this.txtName.sendKeys(name);
	}
	
	public void sendEmail(String email) {
		this.txtEmail.sendKeys(email);
	}
	
	public void sendPassword(String pass) {
		this.txtPassword.sendKeys(pass);
	}
	
	public void completeBirth(String day, String month, String year ) {
	    new Select(days).selectByValue(day);
        new Select(months).selectByVisibleText(month);
        new Select(years).selectByVisibleText(year);
	
	}
	
	public void selectCheckNewsletter() {
		this.newsletter.click();
	}
	
	public void selectSpecialOffers() {
		this.specialOffers.click();
	}
	
	public void sendFirstName(String n) {
		this.firstName.sendKeys(n);
	}
	
	public void sendLastName(String n) {
		this.lastName.sendKeys(n);
	}
	
	public void sendCompany(String company) {
		this.company.sendKeys(company);
	}
	
	public void sendAddresses(String dir1, String dir2) {
		this.address1.sendKeys(dir1);
		this.address2.sendKeys(dir2);
	}
	
	public void selectCountry(int pais) {
		new Select(this.country).selectByIndex(pais);
	}
	
	public void sendState (String state) {
		this.state.sendKeys(state);
	}
	
	public void sendCity(String city) {
		this.city.sendKeys(city);
	}
	
	public void sendZipCode(String zc) {
		this.zipcode.sendKeys(zc);
	}
	
	public void sendMobileNumber(String number) {
		this.mobile_number.sendKeys(number);
	}
	
	public void clickCreateAccount() {
		this.btnCreateAccount.click();
	}

	public String getAccountCreated() {
		return txtAccountCreated.getText();
	}
	
	public String getCompletePassword() {		
		return txtPassword.getAttribute("validationMessage");
	}
	
	public String getCompleteFirstName() {		
		return firstName.getAttribute("validationMessage");
	}
	
	public String getCompleteLastName() {		
		return lastName.getAttribute("validationMessage");
	}
	
	public String getCompleteAddress1() {		
		return address1.getAttribute("validationMessage");
	}
	
	public String getCompleteState() {		
		return state.getAttribute("validationMessage");
	}
	
	public String getCompleteCity() {		
		return city.getAttribute("validationMessage");
	}
	
	public String getCompleteZipCode() {		
		return zipcode.getAttribute("validationMessage");
	}
	
	public String getCompleteMobileNumber() {		
		return mobile_number.getAttribute("validationMessage");
	}
	
}
