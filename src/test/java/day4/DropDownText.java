package day4;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownText {

	WebDriver driver;

	@Before
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 driver.get("https://the-internet.herokuapp.com/dropdown");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	//@Ignore
	@Test
	public void staticDropDown() throws InterruptedException {
		//driver.get("https://www.makemytrip.com/");
		WebElement staticDropdown = driver.findElement(By.id("dropdown"));
		Select select = new Select(staticDropdown);
		Thread.sleep(2000);
		select.selectByIndex(1);// option1
		Thread.sleep(3000);
		select.selectByValue("2");// option2
		Thread.sleep(3000);
		select.selectByVisibleText("Option 1");// option1

	}
@Ignore
	@Test
	public void test1() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.id("root")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div/div[1]/label/input")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"))
				.sendKeys("nyc");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/div[1]/p[1]")).click();

	}

}
