package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gargoylesoftware.htmlunit.javascript.host.payment.PaymentAddress;

import support.World;

public class CheckoutPage {

	WebDriver driver;
	World UniversalForSteps;

	// Sign in

	@FindBy(xpath = "//button[@id='submitAccount']")
	public WebElement registerButton;

	public WebElement getRadioButtonInTitle(String title, WebDriver driver) {
		// title: Mr. , Mrs.
		return driver.findElement(By.xpath("//div[@class='radio-inline']//label[contains(.,'" + title + "')]"));
	}

	public WebElement getInputFromSignIn(String inputID, WebDriver driver) {
		// inputID: customer_firstname, customer_lastname, email, passwd, firstname,
		// lastname,
		// company, address1, address2, city, postcode, other, phone, phone_mobile,
		// alias
		return driver.findElement(By.xpath("//input[@id='" + inputID + "']"));
	}

	public WebElement getSelectorFromSignIn(String selectorID, WebDriver driver) {
		// selectorID: days, months, years, id_state, id_country
		return driver.findElement(By.xpath("//input[@id='" + selectorID + "']"));
	}

	public WebElement getOptionToSelect(String optionID, WebDriver driver) {
		// optionID: newsletter, optin
		return driver.findElement(By.xpath("//input[@id='" + optionID + "']"));
	}

	public void fillPersonalInformation(String title, String firstName, String lastName, String email, String password,
			String birthDay, String birthMonth, String birthYear, boolean newsletterChecked,
			boolean offersReceiveChecked, WebDriver driver) {

		WebElement titleRadioButton = this.getRadioButtonInTitle(title, driver);
		WebElement firstNameInput = this.getInputFromSignIn("customer_firstname", driver);
		WebElement lastNameInput = this.getInputFromSignIn("customer_lastname", driver);
//		WebElement emailInput = this.getInputFromSignIn("email", driver);
		WebElement customerPasswordInput = this.getInputFromSignIn("passwd", driver);
		WebElement birthDaySelector = this.getSelectorFromSignIn("days", driver);
		WebElement birthMonthSelector = this.getSelectorFromSignIn("months", driver);
		WebElement birthYearSelector = this.getSelectorFromSignIn("years", driver);
		WebElement newsletterOption = this.getOptionToSelect("newsletter", driver);
		WebElement specialOffersOption = this.getOptionToSelect("optin", driver);

		titleRadioButton.click();
		firstNameInput.clear();
		firstNameInput.sendKeys(firstName);
		lastNameInput.clear();
		lastNameInput.sendKeys(lastName);
//		emailInput.clear();
//		emailInput.sendKeys(email);
		customerPasswordInput.clear();
		customerPasswordInput.sendKeys(password);

		birthDaySelector.click();
		birthDaySelector.sendKeys(birthDay);
		birthMonthSelector.click();
		birthMonthSelector.sendKeys(birthMonth);
		birthYearSelector.click();
		birthYearSelector.sendKeys(birthYear);

		if (!newsletterOption.isSelected()) {
			if (newsletterChecked == true) {
				newsletterOption.click();
			}
		} else {
			if (newsletterChecked == false) {
				newsletterOption.click();
			}
		}

		if (!specialOffersOption.isSelected()) {
			if (offersReceiveChecked == true) {
				specialOffersOption.click();
			}
		} else {
			if (offersReceiveChecked == false) {
				specialOffersOption.click();
			}
		}

	}

	public void fillAddress(String company, String address1, String address2,
			String city, String state, String postCode, String country, String additionalInfo, String homePhone,
			String mobilePhone, String alias, WebDriver driver) {

//		WebElement firstNameInput = this.getInputFromSignIn("firstname", driver);
//		WebElement lastNameInput = this.getInputFromSignIn("lastname", driver);
		WebElement companyInput = this.getInputFromSignIn("company", driver);
		WebElement address1Input = this.getInputFromSignIn("address1", driver);
		WebElement address2Input = this.getSelectorFromSignIn("address2", driver);
		WebElement cityInput = this.getSelectorFromSignIn("city", driver);
		WebElement stateSelector = this.getSelectorFromSignIn("id_state", driver);
		WebElement postCodeInput = this.getOptionToSelect("postcode", driver);
		WebElement countrySelector = this.getSelectorFromSignIn("id_country", driver);
		WebElement additionalInfoInput = this.getOptionToSelect("other", driver);
		WebElement homePhoneInput = this.getOptionToSelect("phone", driver);
		WebElement mobilePhoneInput = this.getOptionToSelect("mobile_phone", driver);
		WebElement aliasInput = this.getOptionToSelect("alias", driver);

//		firstNameInput.clear();
//		firstNameInput.sendKeys(firstName);
//		lastNameInput.clear();
//		lastNameInput.sendKeys(lastName);
		companyInput.clear();
		companyInput.sendKeys(company);
		address1Input.clear();
		address1Input.sendKeys(address1);
		address2Input.clear();
		address2Input.sendKeys(address2);
		cityInput.clear();
		cityInput.sendKeys(city);
		stateSelector.click();
		stateSelector.sendKeys(state);
		postCodeInput.clear();
		postCodeInput.sendKeys(postCode);
		countrySelector.click();
		countrySelector.sendKeys(country);
		additionalInfoInput.clear();
		additionalInfoInput.sendKeys(additionalInfo);
		homePhoneInput.clear();
		homePhoneInput.sendKeys(homePhone);
		mobilePhoneInput.clear();
		mobilePhoneInput.sendKeys(mobilePhone);
		aliasInput.clear();
		aliasInput.sendKeys(alias);

	}

	public void register() {
		this.registerButton.click();
	}
	
	//Address
	
	@FindBy(xpath = "//select[@id='id_address_delivery']")
	public WebElement chooseDeliverAddressSelector;
	
	@FindBy(xpath = "//div[@id='ordermsg']//textarea")
	public WebElement commnetaryArea;
	
	@FindBy(xpath = "//div[@id='ordermsg']//textarea")
	public WebElement addNewAddress;
	
	
	
	public WebElement getUpdateButtonFromAddress(String addressID, WebDriver driver) {
		// addressID: address_delivery, address_invoice
		return driver.findElement(By.xpath("//ul[@id='"+addressID+"']//a[@title='Update']"));
	}
	
	//New Address
	
	@FindBy(xpath = "//button[@id='submitAddress']")
	public WebElement saveButton;
	
	@FindBy(xpath = "//ul[contains(@class,'footer_links')]//span[contains(text(), 'Back to your addresses')]")
	public WebElement backToYourAddressesButton;
	
	//Shipping
	
	@FindBy(xpath = "//p[@class='checkbox']//label[contains(., 'I agree to the terms of service and will adhere to them unconditionally.')]")
	public WebElement termsOfServiceCheckbox;
	
	@FindBy(xpath = "//p[@class='checkbox']//a[contains(., '(Read the Terms of Service)')]")
	public WebElement termsOfServiceDocumentNavigation;
	
	@FindBy(xpath = "//div[@class='fancybox-skin']//a[@title='Close']")
	public WebElement closeTermsOfServiceButton;
	
	public void checkTermsOfServices() {
		if (!this.termsOfServiceCheckbox.isSelected()) {
			this.termsOfServiceCheckbox.click();
		}
	}
	
	public void navigateToTermsOfServices() {
		this.termsOfServiceDocumentNavigation.click();
	}
	
	public void closeTermsOfServices() {
		this.closeTermsOfServiceButton.click();
	}
	
	//Payment
	
	public WebElement getPaymentOption(String paymentOption, WebDriver driver) {
		// paymentOption: Pay by bank wire, Pay by check
		return driver.findElement(By.xpath("//p[@class='payment_module']//a[contains(text(),'"+paymentOption+"')]"));
	}
	
	@FindBy(xpath = "//p[contains(@class, 'cart_navigation')]//a[contains(., 'Other payment')]")
	public WebElement otherPaymentMethButton;
	
	@FindBy(xpath = "//button[@type='submit']//span[contains(., 'confirm')]")
	public WebElement confirmOrderButton;

	@FindBy(xpath = "//p//strong[contains(text(), 'complete')]")
	public WebElement orderConfirmation;
	
	@FindBy(xpath = "//p[contains(@class, 'cart_navigation')]//a[contains(., 'Back to orders')]")
	public WebElement backToOrdersButton;
	
	public CheckoutPage(WebDriver driver) {

		this.driver = driver;
	}

}