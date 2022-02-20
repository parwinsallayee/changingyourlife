package day2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openAndVerifyTitle {

	WebDriver driver;

	@Before
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
	}
@After
public void afterTest() {
	driver.close();
	
}
	@Test
	public void verifyTitle() {
		

		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "YouTube";

		if (expectedPageTitle.equalsIgnoreCase(actualPageTitle)) {
			System.out.println("Title matched and Passed");
		} else {
			System.out.println("Failed");
			System.out.println("Expected to see --> " + expectedPageTitle);
			System.out.println("The driver got  --> " + actualPageTitle);
		}

	}

	@Test
	public void verifyUrl() {

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.youtube.com/";

		if (expectedUrl.equalsIgnoreCase(actualUrl)) {
			System.out.println("Title matched and Passed");
		} else {
			System.out.println("Failed");
			System.out.println("Expected to see --> " + expectedUrl);
			System.out.println("The driver got  --> " + actualUrl);
		}

	}
	@Test
public void pageSourcePrint() {
	
String PageSource = driver.getPageSource();

System.out.println(PageSource);

driver.navigate().to("https://www.techcircleschoo.com");

driver.navigate().back();// navigate back to YouTube

}
}