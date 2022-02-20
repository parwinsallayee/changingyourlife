package day0;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirsTry {

	WebDriver driver;

	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
	}

	@Test
	public void Implicit_ExplicitWaitTask() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("baby");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Go']")).click();

//		WebDriverWait wait = new WebDriverWait(driver, 20);
//
//		wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@id=p_n_format_browse-bin/2650306011]/span/a/div/label/i")))
//				.click();
		Thread.sleep(1000);

		driver.findElement(By.className("a-section aok-relative s-image-square-aspect")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[1]"));
		Thread.sleep(1000);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("a-button-input")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("nav-cart-count"));
		driver.findElement(By.className("submit.delete.C1300ba6a-9902-4670-9cc9-e207d7771b06")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"p_n_specials_match/21213697011\"]/span/a/div/label/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div/div/div[1]/span/a/div/img")).click();
		
      
}
}