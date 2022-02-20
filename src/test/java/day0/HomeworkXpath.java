package day0;






import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeworkXpath {

	WebDriver driver;
	 
	@Before
	
	public void OpenBrowers() {
		
	WebDriverManager.chromedriver().setup();
	
	driver = new ChromeDriver();
	
	driver.get("https://www.amazon.com/");
		
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
		
	}
	
	@Test
	
	public void allXPath() {
		
		//Absolute XPath Search Button
		
	driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div/span/input"));	
		
		//Basic XPath  Search Box
		
		
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	
	   //Contains()  Submit Button
	
	driver.findElement(By.xpath("//input[contains(@id,'submit-button')]"));
	
	  //Using OR & AND  Submit Button
		
	driver.findElement(By.xpath("//input[@id='nav-search-submit-button' and @type='submit']"));
	
	driver.findElement(By.xpath("//input[@id='nav-search-submit-button' or @class='nav-input nav-progressive-attribute']"));
	
	  //Starts-With Submit Button
	
	driver.findElement(By.xpath("//input[starts-with(@id,'nav')]"));
	
	  //Text() - XPath Best Sellers Tap
	
	driver.findElement(By.xpath("//a[text()='Best Sellers']"));
	
	  //Using Index
	
	driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]/option[3]"));
	
	
}
	
	}




