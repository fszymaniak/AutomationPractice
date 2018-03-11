package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import support.World;

public class ShoppingCartPage {

	WebDriver driver;

	World UniversalForSteps;

	
	//buttons: increase or decrease quantity, remove
	public WebElement getButtonFromShoppingCart(String productName, String buttonClass, WebDriver driver) {
		//buttonClass: minus, plus, trash 
		return driver.findElement(
				By.xpath("//tr[.//a[contains(text(),'"+productName+"')]]//i[contains(@class,'"+buttonClass+"')]"));
	}
	
	public WebElement getQuantityInput(String productName, WebDriver driver) {
		return driver.findElement(
				By.xpath("//tr[.//a[contains(text(),'"+productName+"')]]//input[contains(@class, 'cart_quantity_input')]"));
	}
	
	public WebElement getAvailabilityInfoFromShoppingCart(String productName, WebDriver driver) {
		return driver.findElement(
				By.xpath("//tr[.//a[contains(text(),'"+productName+"')]]//span[contains(@class, 'label-success')]"));
	}
	
	public WebElement getUnitOrTotalPriceOfProductInShoppingCart(String productName,String priceID, WebDriver driver) {
		//priceID: product_price, total_product_price
		return driver.findElement(
				By.xpath("//tr[.//a[contains(text(),'"+productName+"')]]//span[starts-with(@id, '"+priceID+"')]"));
	}
	
	public WebElement getTotalPricesInShoppingCart(String productName,String totalPricesID, WebDriver driver) {
		//totalCategoryID: total_product, total_shipping, total_price_without_tax, total_price
		return driver.findElement(
				By.xpath("//td[@id='"+totalPricesID+"']"));
	}
	
	

	public ShoppingCartPage(WebDriver driver) {

		this.driver = driver;
	}

}