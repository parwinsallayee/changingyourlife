package day3;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationSlidersTestCases {

	
	
	WebDriver driver;

	@Before
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in/test-cases/");
		driver.manage().window().maximize();
	}	
	@Test
	public void testCase1(){
		driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();
		driver.findElement(By.xpath("//div[@id='content']/nav/a")).click();
		
		
		
		
		
		
	}

	
	
	
}
