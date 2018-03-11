package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {

	WebDriver driver;

	@FindBy(xpath = "//select[@id='selectProductSort']")
	public WebElement sortBySelectorXP;

	public WebElement getViewButton(String viewType, WebDriver driver) {
		return driver.findElement(By.xpath("//li[@id='" + viewType + "']//a//i"));
	}
	
	public WebElement getTopOrBottomCompareButton(String buttonLocalization, WebDriver driver) {
		//Localization: top, bottom
		return driver.findElement(
				By.xpath("//div[contains(@class,'"+buttonLocalization+"-pagination-content')]//button[contains(@class,'compare')]"));
	}
	
	public WebElement getSubcategory(String subcategoryName, WebDriver driver) {
		return driver.findElement(
				By.xpath("//div[@id='subcategories']//a[contains(text(), '"+subcategoryName+"')]"));
	}
	
	
	

	public CategoryPage(WebDriver driver) {

		this.driver = driver;
	}

}