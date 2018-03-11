package stepDef;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CategoryPage;
import pages.ProductUniversalPage;
import pages.StoreMenu;
import support.World;

public class CategoryStep {

	WebDriver driver;
	World world = new World();
	CategoryPage CategoryPage;
	StoreMenu StoreMenu; 
	ProductUniversalPage ProductUniversalPage;

	String productName;

	@Before
	public void setup() {
		driver = world.driverSetUp();
		CategoryPage = PageFactory.initElements(driver, CategoryPage.class);
		StoreMenu = PageFactory.initElements(driver, StoreMenu.class);
		ProductUniversalPage = PageFactory.initElements(driver, ProductUniversalPage.class);
		
	}

	@After
	public void onAfter() throws InterruptedException {
		driver.quit();
	}

	@Given("^user is on Women category page \"([^\"]*)\"$")
	public void navigate(String url)  {
		world.navigateToPage(url, driver);
		world.slowDown(1000);
	}
	
	@When("^user click on button Add To Cart \"([^\"]*)\"$")
	public void clickOnAddToCartButton(String productName) {
		this.productName = productName;
		WebElement addToBasketButton = null;
		world.implicityWait(10, driver);
		ProductUniversalPage.mouseoverActionOnProduct(productName, driver);
		addToBasketButton = ProductUniversalPage.getButtonsFromProductInCategoryPage(productName, "Add to cart", driver);
		world.waitForElementToBeClickable(addToBasketButton, driver);
		if (addToBasketButton.isDisplayed() && addToBasketButton.isEnabled()) {
			world.clickOnElement(driver, addToBasketButton);
		}
		world.implicityWait(10, driver);
		
	}

	@Then("^product should be successfully added to shopping cart$")
	public void isProductSuccessfullyAdded() {
		world.slowDown(1000);
		boolean isAdded = false;
		world.implicityWait(10, driver);
		WebElement productTitle = ProductUniversalPage.getProductInfo("title", driver);
		String prodName = productTitle.getText();
		if(prodName.equals(productName)){
			isAdded = true; 
		}
		assertEquals(true, isAdded);
	}

	@And("^continue shopping")
	public void continueShopping() {
		world.implicityWait(10, driver);
		world.waitForElementToBeClickable(ProductUniversalPage.continueShoppingButtonXP, driver);
		ProductUniversalPage.continueShoppingButtonXP.click();
	}

	@And("^there should be (\\d+) products in basket$")
	public void checkNumberOfProductsInBasket(int prodInBasketNumer) {
		world.waitForElementToBeClickable(StoreMenu.quantityInBasketXP, driver);
		String numberOfProductsString = StoreMenu.quantityInBasketXP.getText();
		int numberOfProductsInt = Integer.parseInt(numberOfProductsString);
		assertEquals(true, prodInBasketNumer == numberOfProductsInt);
	}

}