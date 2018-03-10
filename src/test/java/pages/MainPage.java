package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

	WebDriver driver;

	@FindBy(xpath = "//ul[@id='home-page-tabs']//a[contains(text(), 'Best Sellers')]")
	public WebElement generalCategoryOnMainPageXP;

	public WebElement getGeneralCategoryOnMainPage(String categoryName, WebDriver driver) {

		return driver.findElement(By.xpath("//ul[@id='home-page-tabs']//a[contains(text(), '" + categoryName + "')]"));
	}

	//div[@id='center_column']//h5//a[@title='Faded Short Sleeve T-shirts']

	public MainPage(WebDriver driver) {

		this.driver = driver;
	}

}