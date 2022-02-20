package homework_batch9;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContainsThreeSlides {
	WebDriver driver;

	@Before
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in/");

	}

	@After
	public void afterTest() {
		driver.close();
	}

	@Test
	public void PageWithThreeSlides() throws InterruptedException {

		// click on the shop button
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("li[id='menu-item-40'] a")).click();

		// click on the home button
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("nav[class='woocommerce-breadcrumb'] a")).click();

		// does the homepage has three slides

		List<WebElement> ele = driver
				.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div"));
		int numOfSlides = ele.size();
		System.out.println(numOfSlides);

		if (numOfSlides == 3) {
			System.out.println("The webpage containes three slides");

		} else {
			System.out.println("Wrong number");
		}

	}

}
