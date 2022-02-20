package day6;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assertionsTest {

	WebDriver driver;

	@Before
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void assertFalseTest() {

		// checkbox 1
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));

		Assert.assertFalse(checkbox1.isSelected());
		// Assert.assertFalse(false); -- Pass
		System.out.println("hello");

		// checkbox2

		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

		Assert.assertFalse(checkbox2.isSelected());
		// Assert.assertFalse(true); --> failed
		System.out.println("hello2");

	}

	@Test
	public void assertTrueTest() {

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).isDisplayed());
		System.out.println("code didn't throw an exception on assertTrueTest");
		// Assert.assertTrue(true);

	}

	@Test
	public void assertEqualsTest() {
		String actualTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();

		String expectedTitle = "Checkboxez";

		Assert.assertEquals(actualTitle, expectedTitle);

	}
}