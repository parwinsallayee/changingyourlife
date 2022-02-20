package day2;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jUnitTestingExample {

	public void drive() {
		WebDriver driver;
		WebDriverManager.chromedriver();
		driver = new ChromeDriver();
		driver.get("https:techcircleschool.com");

		System.out.println("Opening Brouser");

	}

	@After
	public void tearDown() {

	}

	@Test
	public void test() {

		System.out.println("Test1");

	}

	@Test
	public void test2() {

		System.out.println("Test2");

	}


}
