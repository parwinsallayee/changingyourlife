package ReviewSessions;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReviewWait {

	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void test1() {

		driver.findElement(By.name("q")).sendKeys("TechCircle School", Keys.ENTER);
		wait = new WebDriverWait(driver, 30);
		WebElement resultText = driver.findElement(By.id("result-stats"));
		wait.until(ExpectedConditions.visibilityOf(resultText));

		System.out.println(resultText.getText());

	}
	

}
