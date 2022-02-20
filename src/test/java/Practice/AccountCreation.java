package Practice;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertiesReader;

public class AccountCreation {

	WebDriver driver;

	private String url2 = PropertiesReader.getProperty("url2");

	@Before
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url2);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test1() {

		String FirstName = "Parwin";
		String LastName = "Sallayee";
		String Phone = "7222223333";
		String Email = "psallayee@gmail.com";
		String Address = "122 dee";
		String City = "fairfax";
		String State = "VA";
		String PostalCode = "20121";
		String Country = "Kurdistan";
		String Password = "Fair1234!";
		String ConfirmPassword = "Fair1234!";

		driver.findElement(By.cssSelector("//input[@name='firstName']")).sendKeys(FirstName);
		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(LastName);
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys(Phone);
		driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys(Email);
		driver.findElement(By.cssSelector("input[name='address1']")).sendKeys(Address);
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys(City);
		driver.findElement(By.xpath("input[name='state']")).sendKeys(State);
		driver.findElement(By.xpath("input[name='postalCode']")).sendKeys(PostalCode);

		WebElement Element = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(Element);
        select.selectByValue("QATAR");

		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(ConfirmPassword);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.xpath("//select[@name='country']"));
        
	}
}
