package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCommonPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@id='quantity_wanted']")
	public WebElement quantityInputXP;

	@FindBy(xpath = "//div[@class='box-info-product']//select[@id='group_1']")
	public WebElement sizeSelectorXP;

	@FindBy(xpath = "//div[@class='box-info-product']//button[@name='Submit']")
	public WebElement addToCartsButtonXP;

	@FindBy(xpath = "//div[@class='box-info-product']//a[@id='wishlist_button']")
	public WebElement addToWishListButtonXP;
	
	@FindBy(xpath = "//a[@id='send_friend_button']")
	public WebElement sendToFriendButtonXP;
	
	@FindBy(xpath = "//li[@class='print']//a[contains(text(),'Print')]")
	public WebElement printButtonXP;
	
	@FindBy(xpath = "//span[@id='view_full_size']//span[contains(text(), 'View larger')]")
	public WebElement viewLargerXP;
	
	@FindBy(xpath = "//div//a[contains(@title, 'Close')]")
	public WebElement closeBigImageButtonXP;
	
	@FindBy(xpath = "//div[contains(@class,'top-pagination-content')]//button[contains(@class,'compare')]")
	public WebElement compareButtonOnTopXP;
	
	
	
	public WebElement getQuantityButton(String buttonType, WebDriver driver) {

		return driver.findElement(
				By.xpath("//div[@class='box-info-product']//a[contains(@class, 'button-" + buttonType + "')]"));
	}
	
	public WebElement getColorSelector(String color, WebDriver driver) {

		return driver.findElement(
				By.xpath("//div[@class='box-info-product']//a[@name='"+color+"']"));
	}
	
	public WebElement getSocialButton(String socialName, WebDriver driver) {

		return driver.findElement(
				By.xpath("//p[contains(@class,'socialsharing_product')]//button[contains(@class,'"+socialName+"')]"));
	}
	
	public WebElement selectSmallImage(String imageID, WebDriver driver) {

		return driver.findElement(
				By.xpath("//img[@id='"+imageID+"']"));
	}


	public ProductCommonPage(WebDriver driver) {

		this.driver = driver;
	}

}