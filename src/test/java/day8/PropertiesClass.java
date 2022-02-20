package day8;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertiesReader;

public class PropertiesClass {

	WebDriver driver;
	private String url = PropertiesReader.getProperty("url");

	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void Test1() {

	}

}
