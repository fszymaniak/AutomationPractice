package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftMenu {

	WebDriver driver;

	@FindBy(xpath = "//div[@class='container']//input[@id='search_query_top']")
	public WebElement searchInputOnTop;

	@FindBy(xpath = "//span[@id='layered_price_range']")
	public WebElement priceScalerRange;

	@FindBy(xpath = "//div[@id='special_block_right']//img")
	public WebElement specialsImage;

	@FindBy(xpath = "//div[@id='special_block_right']//a[@title='All specials']")
	public WebElement allSpecialsButton;

	public WebElement getCheckboxElementFromCatalogMenu(String checkboxName, WebDriver driver) {

		return driver.findElement(
				By.xpath("//div[contains(@class, 'layered_filter')]//label//a[(text() = '" + checkboxName + "')]"));
	}

	public WebElement getPriceScaler(String scalePercent, WebDriver driver) {

		return driver
				.findElement(By.xpath("//div[@id='layered_price_slider']//a[@style='left: " + scalePercent + "%;']"));
	}

	public WebElement getCategoryFromLeftMenu(String categoryName, WebDriver driver) {

		return driver.findElement(By.xpath("//div[@id='categories_block_left']//li[.//span[contains(@class, 'grower CLOSE')]]/a[contains(text(), '"+categoryName+"')]"));
	}
	
	public WebElement getSubcategoryFromLeftMenu(String subcategoryName, String nodeNumber, WebDriver driver) {

		return driver.findElement(By.xpath("//div[@id='categories_block_left']//li//a[contains(text(), '"+subcategoryName+"')]"));
	}

	public WebElement getInformationElementFromLeftMenu(String informationTitle, WebDriver driver) {

		return driver.findElement(By
				.xpath("//section[@id='informations_block_left_1']//a[contains(text(), '" + informationTitle + "')]"));
	}
	

	public void removeFilter(String filterName, WebDriver driver) {

		WebElement removeElement = driver
				.findElement(By.xpath("///div[@id='enabled_filters']//li[contains(. , '" + filterName + "')]//a"));
		removeElement.click();
	}

	public void setPriceScalerValue(WebElement slider, int sliderValue, WebDriver driver) {

		Actions move = new Actions(driver);
		Action action = move.dragAndDropBy(slider, sliderValue, 0).build();
		action.perform();
	}

	public void goToSubCategory(WebElement category, WebElement subcategory, WebDriver driver) {
		category.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		subcategory.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public LeftMenu(WebDriver driver) {

		this.driver = driver;
	}

}