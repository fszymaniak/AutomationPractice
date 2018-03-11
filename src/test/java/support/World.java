package support;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class World {
	
//	WebDriver driver; 

	public WebDriver driverSetUp() {

		try {
			System.setProperty("webdriver.chrome.driver",
					new File("./src/test/resources/drivers/chromedriver.exe").getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ChromeDriver();
	}


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


	public void implicityWait(int time, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}
	
	public void waitForElementToBeClickable(WebElement element, WebDriver driver) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public void clickOnElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}
	
//	public World(WebDriver driver) {
//
//		this.driver = driver;
//	}

}