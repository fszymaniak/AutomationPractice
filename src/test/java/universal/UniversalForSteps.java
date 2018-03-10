package universal;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UniversalForSteps {

	public void navigateToPage(String url, WebDriver driver) {
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String urlCheck = driver.getCurrentUrl();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals(url, urlCheck);
	}

	public void slowDown(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public WebElement getConcreteProductName(String productName, WebDriver driver, WebDriverWait webDriverWait) {
		return driver.findElement(
				By.xpath("//div[contains(@class, 'product-layout')]//h4//a[contains(text(), '" + productName + "')]"));
	}

}