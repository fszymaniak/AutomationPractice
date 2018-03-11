package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoreMenu {

	WebDriver driver;


	@FindBy(xpath = "//div[@class='container']//input[@id='search_query_top']")
	public WebElement searchInputOnTopXP;
	
	@FindBy(xpath = "//form[@id='searchbox']//button[contains(@name, 'submit_search')]")
	public WebElement submitSearchButtonXP;
	
	@FindBy(xpath = "//div[@class='shopping_cart']//a[contains(@title,'View my shopping cart')]")
	public WebElement shoppingCartButtonXP;
	
	@FindBy(xpath = "//a[@id='button_order_cart']")
	public WebElement checkoutButtonXP;
	
	@FindBy(xpath = "//div[@class='shopping_cart']//a[contains(@title,'View my shopping cart')]//span[contains(@class,'quantity')]")
	public WebElement quantityInBasketXP;
	
	
	public WebElement getNavigationElementFromTopNav(String navElementName, WebDriver driver) {
		//Contact us, Sign in
		return driver.findElement(By.xpath("//div[@class='nav']//div//a[contains(text(), '"+navElementName+"')]")); 
	}
	
	public WebElement getCategoryNavigatation(String navigationTitle, WebDriver driver) {
		
		return driver.findElement(By.xpath("//div[@class='breadcrumb clearfix']//a[contains(@title, '"+navigationTitle+"')]")); 
	}
	
	public WebElement getImageFromMenu(String imageName, WebDriver driver) {
		
		return driver.findElement(By.xpath("//div[@class='container']//img[contains(@class, '"+imageName+"')]")); 
	}
	
	public WebElement getCategoryFromMenu(String categoryName, WebDriver driver) {
		//categoryName: Women, Dresses, T-Shirts
			return driver.findElement(By.xpath("//div[@id='block_top_menu']//ul[contains(@class, 'sf-menu')]/li/a[contains(text(), '"+categoryName+"')]"));
	}
	
	public void removeFromBasket(String productName, WebDriver driver, WebDriverWait webDriverWait) {
		
		WebElement removeButton = driver.findElement(By.xpath("//div[contains(@class, 'block_content')][.//a[@title='"+productName+"']]//span[contains(@class,'remove')]//a"));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(removeButton));
		removeButton.click();
	}
	
	
	public void chooseSubCategoryInMenu(WebElement category, WebElement subcategory, WebDriver driver) {
		 Actions builder = new Actions(driver);
		 builder.moveToElement(category).build().perform();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 subcategory.click();
	}
	
	public void mouseActionOnBasket() {
		Actions builder = new Actions(driver);
		builder.moveToElement(this.shoppingCartButtonXP).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	

	public StoreMenu(WebDriver driver) {

		this.driver = driver;
	}

}