package universalElementsInPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productSuccessfullyAddedPage {

	WebDriver driver;

	
	public WebElement getProductInfo(String productElementID, WebDriver driver) {
		//id: info, title, attributes, quantity, price
		return driver.findElement(By.xpath("//div[contains(@class,'layer_cart_product')]//span[contains(@id,'"+productElementID+"')]"));
	}
	
	
	public WebElement getInfoAboutProductsInCart(String cartInfoCLASS, WebDriver driver) {
		//class: products_total, shipping_cost, cart_total
		return driver.findElement(By.xpath("//div[contains(@class,'layer_cart_cart')]//span[contains(@class,'"+cartInfoCLASS+"')]"));
	}

	@FindBy(xpath = "//div[@class='button-container']//span//span[contains(.,'Continue')]")
	public WebElement continueShoppingButtonXP;
	
	@FindBy(xpath = "//div[@class='button-container']//span[contains(.,'Proceed')]")
	public WebElement proceedToCheckoutButtonXP;

	@FindBy(xpath = "//div[@id='layer_cart']//span[@title='Close window']")
	public WebElement closeWindowButtonXP;

	public productSuccessfullyAddedPage(WebDriver driver) {

		this.driver = driver;
	}

}