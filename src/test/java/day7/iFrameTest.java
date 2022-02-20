package day7;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iFrameTest {

	WebDriver driver;
	private String url = "https://jqueryui.com/droppable/";

	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void dragAndDropTest() {
		Actions action = new Actions(driver);
//	        List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
//	        
//	         // print your number of frames
//	         System.out.println(iframes.size());
//	        
//	        
		// System.out.println(driver.findElement(By.xpath("//iframe")).getSize());

		driver.switchTo().frame(0);

		WebElement draggble = driver.findElement(By.id("draggable")); 
		WebElement droppable = driver.findElement(By.id("droppable")); 
		action.dragAndDrop(draggble, droppable).build().perform();

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[3]/a")).click();

	}

}
