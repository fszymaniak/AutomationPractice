//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class SearchPage{
//	
//	WebDriver driver;
//	CategoryPage CategoryPage;
//	
//	@FindBy(xpath = "//div[contains(@class, 'row')]//input[contains(@id,'input-search')]")
//	public WebElement searchCriteriaInput;
//	
//	@FindBy(xpath = "//div[contains(@class, 'row')]//select[contains(@name,'category_id')]")
//	public WebElement categorySelect;
//	
//	@FindBy(xpath = "//label[contains(@class, 'checkbox-inline')]//input[contains(@name,'sub_category')]")
//	public WebElement searchInSubcategoriesCheckbox;
//	
//	@FindBy(xpath = "//label[contains(@class, 'checkbox-inline')]//input[contains(@id,'description')]")
//	public WebElement searchInProductDescriptionCheckbox;
//	
//	@FindBy(xpath = "//input[@id = 'button-search']")
//	public WebElement searchButon;
//	
//	public WebElement getGridViewButton() {
//		return CategoryPage.gridViewButton;
//	}
//	
//	public WebElement getListViewButton() {
//		return CategoryPage.listViewButton;
//	}
//	
//	public WebElement getSortBySelect() {
//		return CategoryPage.sortBySelect;
//	}
//	
//	public WebElement getShowNumberOfProductsSelect() {
//		return CategoryPage.showNumberOfProductsSelect;
//	}
//	public void searchInSearchCriteria(String productName, WebDriverWait webDriverWait) {
//		this.searchCriteriaInput.clear();
//		this.searchCriteriaInput.sendKeys(productName);
//		webDriverWait.until(ExpectedConditions.elementToBeClickable(this.searchButon));
//		this.searchButon.click();
//	}
//	
//	
//	public SearchPage(WebDriver driver) {
//
//		this.driver = driver;
//	}
//	
//	
//}