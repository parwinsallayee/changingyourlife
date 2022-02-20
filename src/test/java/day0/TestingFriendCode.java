package day0;

import java.util.List;//nice job
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 *  1. go to http://automationpractice.com/index.php
    2. click on DRESSES button
    3. add items on sale to cart and checkout
    4. continue to checkout until you see the 'authentication' page and verify it
    */
public class TestingFriendCode {

	public static char randomChar() {
		int i = (int) (Math.random() * (97 - 122) + 97);
		char result = (char) i;
		return result;
	}

	WebDriver driver;
	WebDriverWait wait;
	String email = randomChar() + randomChar() + randomChar() + "47689@gmail.com";
	String firstName = "First";
	String lastName = "Last";
	String password = "12345";
	String date = "12";
	String month = "1";
	String year = "2015";
	String company = "Kinsen llc";
	String addressStreet = "12345 Perfect St.";
	String city = "Germantown";
	String state = "Maryland";
	String zipCode = "12345";
	String mobilePhone = "123-456-7865";
	By dressesButton = By.xpath("//*[@id='block_top_menu']/ul/li[2]/a");
	By continueShopping = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span");

	@Before
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test1() {
		Actions action = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
		
		// click on DRESSES button
		driver.findElement(dressesButton).click();
		
		// add all items into List
		List<WebElement> allItems = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));
		
		// Get size of the list
		int numItems = allItems.size();
		
		// Loop thru each item
		for (int i = 1; i <= numItems; i++) {
		
			// Store each item as a WebElement
			WebElement item = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[" + i + "]"));
			WebElement addToCartButton = driver
					.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + i + "]/div/div[2]/div[2]/a[1]/span"));
			WebElement continueShoppingButton = driver.findElement(continueShopping);
			String itemText = item.getText();
			if (itemText.contains("%")) {
				action.moveToElement(item).build().perform();
				wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
				addToCartButton.click();
				wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
				continueShoppingButton.click();
			}

		}
	}
}
