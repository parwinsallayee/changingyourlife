package day0;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class ClsNameStrategy {

	WebDriver driver; 

	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// URL launch
		driver.get("https://www.linkedin.com/");
		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@Test
	public void testDemo() {
		// identify element class name
		WebElement elm = driver.findElement(By.className("input__input"));
		elm.sendKeys("abc@gmail.com");
		// identify with cssSelector
		WebElement c = driver.findElement(By.cssSelector("input[class='input__input']"));
		String str = c.getAttribute("value");
		System.out.println("Value entered is : " + str);
		// identify with xpath
		WebElement x = driver.findElement(By.xpath("//input[@class='input__input']"));

		x.clear();
		driver.close();
	}
}