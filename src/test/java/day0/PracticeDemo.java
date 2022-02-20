package day0;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeDemo {

	
	WebDriver driver;

	@Before
	public void beforeMethod() {

		
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in/test-cases/");
		driver.manage().window().maximize();

	}
	@Test
	
	public void task()throws InterruptedException { {
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Shop]")).click();
		Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Home]")).click();
		
	
	//driver.findElement(By.xpath("//"))
	
	
		
	} 


	
	
	}
}
	

