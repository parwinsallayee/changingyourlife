package homework_batch9;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAndYoutube {

	WebDriver driver;

	String item = "GT Performance 35-5457 Mustang Wood Steering Wheel";
	
	@Before
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
	}

	@After
	public void afterTest() {
		//driver.close();
	}

	@Test
	public void amazonAndYoutube() throws InterruptedException {
		// search for item
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(item);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

		// Add select item
		driver.findElement(By.linkText(item)).click();

		// Add to cart
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();

		// delete item
		driver.findElement(By.xpath("//input[@value='Delete']")).click();

	}
@Ignore 
	@Test
	public void verifyTitle() throws InterruptedException {

		driver.get("https://www.youtube.com");

		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "YouTube";
		// validate the title
		if (expectedPageTitle.equalsIgnoreCase(actualPageTitle)) {
			System.out.println("Title matched and Passed");
		} else {
			System.out.println("Failed");

		}
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("nature sounds");
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']//yt-icon[@class='style-scope ytd-searchbox']"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();
	}
}
