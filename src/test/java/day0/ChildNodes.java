package day0;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChildNodes {

	WebDriver driver; 

	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/about/about_careers.htm");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
	}

	@Test
	public void Implicit_ExplicitWaitTask() {

		// driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
		// identify element
		WebElement t = driver.findElement(By.xpath("//ul[@class='toc chapters']"));
		// identify child nodes with ./child::* expression in xpath
		List<WebElement> c = t.findElements(By.xpath("./child::*"));
		// iterate child nodes
		for (WebElement i : c) {
			// getText() to get text for child nodes
			System.out.println(i.getText());
		}
		// driver.close();
	}
}
