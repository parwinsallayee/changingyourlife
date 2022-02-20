package day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EtsyTestingDemo {

	
	WebDriver driver;

	@Before
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.etsy.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
		
			
		}
	
	@Test
	
	public void Test1() throws InterruptedException {
		
	driver.findElement(By.id("global-enhancements-search-query")).sendKeys("light");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@type='submit']"))	.click();
	
	
	
	
		
	}
	
	
}
