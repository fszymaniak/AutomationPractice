package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import support.World;

public class ProductUniversalPage {

	WebDriver driver;
	World world = new World();

	// Product Successfully Added

	public WebElement getProductInfo(String productElementID, WebDriver driver) {
		// id: info, title, attributes, quantity, price
		return driver.findElement(By
				.xpath("//div[contains(@class,'layer_cart_product')]//span[contains(@id,'" + productElementID + "')]"));
	}

	public WebElement getInfoAboutProductsInCart(String cartInfoCLASS, WebDriver driver) {
		// class: products_total, shipping_cost, cart_total
		return driver.findElement(
				By.xpath("//div[contains(@class,'layer_cart_cart')]//span[contains(@class,'" + cartInfoCLASS + "')]"));
	}

	@FindBy(xpath = "//h2[contains(., 'Product successfully added to your shopping cart')]")
	public WebElement successInfoHeaderXP;

	@FindBy(xpath = "//div[@class='button-container']//span[.//span[contains(.,'Continue')]]//i")
	public WebElement continueShoppingButtonXP;

	@FindBy(xpath = "//div[@class='button-container']//span[contains(.,'Proceed')]")
	public WebElement proceedToCheckoutButtonXP;

	@FindBy(xpath = "//div[@id='layer_cart']//span[@title='Close window']")
	public WebElement closeWindowButtonXP;

	// Universal buttons/elements

	public WebElement getContinueOrProceedButton(String buttonTitle, WebDriver driver) {
		// buttonTitle: Continue shopping, Proceed to checkout
		return driver.findElement(
				By.xpath("//p[contains(@class, 'cart_navigation')]//a[contains(@title, '" + buttonTitle + "')]"));
	}

	public WebElement getButtonsFromProductInMainPage(String productCategory, String productName, String buttonTitle,
			WebDriver driver) {

		// productCategory: homefeatured, blockbestsellers
		// buttonTitle: Add to card, More
		return driver.findElement(By.xpath("//ul[@id='" + productCategory
				+ "']//div[@class='product-container'][.//a[contains(@title, '" + productName
				+ "')]]//div[@class='button-container']//a[contains(@title, '" + buttonTitle + "')]"));
	}
	
	public WebElement getButtonsFromProductInCategoryPage(String productName, String buttonTitle,
			WebDriver driver) {
		// buttonTitle: Add to card, More
		return driver.findElement(By.xpath("//div[@class='product-container'][.//a[contains(@title, '" + productName
				+ "')]]//div[@class='button-container']//a[contains(@title, '" + buttonTitle + "')]"));
	}

	public WebElement getProductName(String productCategory, String productName, String buttonTitle, WebDriver driver) {

		// productCategory:homefeatured, blockbestsellers
		return driver.findElement(By.xpath(
				"//div[@class='tab-content']/ul[@id='"+productCategory+"']//div[@class='product-container']//a[contains(@title, '"+productName+"') and contains(@class, 'product-name')]"));
	}

	// operations

	public void mouseoverActionOnProduct(String productName, WebDriver driver) {
		Actions builder = new Actions(driver);
		WebElement product = driver
				.findElement(By.xpath("//div[@id='center_column']//h5//a[@title='" + productName + "']"));
		builder.moveToElement(product).build().perform();
		world.implicityWait(10, driver);
	}

	public ProductUniversalPage(WebDriver driver) {

		this.driver = driver;
	}

}