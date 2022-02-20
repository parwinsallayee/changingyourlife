package day0;

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

public class DropDwonDemo {

	WebDriver driver;
	   @Before
	   public void initDriver() {
	      WebDriverManager.chromedriver().setup();
	      driver = new ChromeDriver();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   }

	   @Test 
	   public void staticDropdownTest() {
	      driver.get("https://www.spicejet.com/");
	      driver.findElement(By.xpath(
	         "//div[@data-testid='to-testID-origin']//input[@type='text']")).click();
	      driver.findElement(By.xpath(
	         "//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'][normalize-space()='International']")).click();
	      driver.findElement(By.xpath(
	         "//div[@data-testid='to-testID-origin']//div[3]")).click();

	   }
	   @Ignore
	   @Test 
	   public void selectClass() {
	      driver.get("https://www.amazon.com/");
	      WebElement allDropdown = driver.findElement(
	         By.xpath("//select[@id='searchDropdownBox']"));
	      Select select = new Select(allDropdown);
	      select.selectByIndex(5); // index start from 0
	      select.selectByValue("search-alias=mobile-apps");
	      select.selectByVisibleText("Baby");
	   }
	   @Ignore
	   @Test
	   public void dynamicSelect() {
	      driver.get("https://www.makemytrip.com/");
	      By fromCity = By.xpath("//input[@data-cy='fromCity']");
	      By inputFormCity = By.xpath("//input[@placeholder='From']");
	      String cityName = "indonesia";
	      By airport = By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']//div[@class='makeFlex hrtlCenter']");
	      driver.findElement(fromCity).click();
	      driver.findElement(inputFormCity).sendKeys(cityName);
	      driver.findElement(airport).click();
	   }


	
	
}
	

