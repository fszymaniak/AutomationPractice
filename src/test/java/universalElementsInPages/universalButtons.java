package universalElementsInPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class universalButtons {

	WebDriver driver;

	
	public WebElement getContinueOrProceedButton(String buttTitle, WebDriver driver) {
		//buttTitle: Continue shopping, Proceed to checkout
		return driver.findElement(
				By.xpath("//p[contains(@class, 'cart_navigation')]//a[contains(@title, '"+buttTitle+"')]"));
	}

	
	
	public universalButtons(WebDriver driver) {

		this.driver = driver;
	}

}