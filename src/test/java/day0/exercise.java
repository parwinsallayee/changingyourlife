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

public class exercise {

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
	public void Implicit_ExplicitWaitTask() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("toy");
		driver.findElement(By.xpath("//input[@value='Go']")).click(); 

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=p_n_format_browse-bin/2650306011]/span/a/div/label/i")))
				.click();

	
}

@Test
   public void staticDropdowTest2() {
      driver.get("https://www.amazon.com/");
      WebElement allDropdown = driver.findElement(
         By.xpath("//select[@id='searchDropdownBox']"));
      Select select = new Select(allDropdown);
      select.selectByIndex(5); // index start from 0
   }}


