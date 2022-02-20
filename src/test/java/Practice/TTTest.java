package Practice;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertiesReader;

public class TTTest {
	@Before
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url2);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	WebDriver driver;
	private String url2 = PropertiesReader.getProperty("url2");



	 @Test
	    public void test() throws InterruptedException {
	        // First Name
	        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Henry");

	        // First Name
	        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Leu");
	        
	        // Phone
	        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("987654321");

	        // Email
	        driver.findElement(By.id("userName")).sendKeys("disneyland@gmail.com");
	        
	        // Address
	        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("1234 Continental Ave");
	        
	        // City
	        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Flushing");
	        
	        // State
	        driver.findElement(By.xpath("//input[@name='state']")).sendKeys("New York");
	        
	        // Postal code
	        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("11354");
	        
	        //Solution #1
	        driver.findElement(By.xpath("//select[@name='country']"));
	        element = driver.findElement(By.xpath("//select[@name='country']"));
	        Select select = new Select(element);
	        select.selectByValue("TAIWAN");
	        
	        
	        /*
	        // Solution #2
	        List<WebElement> countries = driver.findElements(By.xpath("//select[@name='country']/option"));
	        int size = countries.size();
	        for(int i=0; i<size; i++) {
	            element = driver.findElement(By.xpath("//select[@name='country']/option[" + (i+1) + "]"));

	            if(element.getText().contains("TAIWAN")) 
	                element.click();
	        }*/    
	        
	        // User Name
	        driver.findElement(By.id("email")).sendKeys("cooljetdi");
	        
	        // Password
	        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mypassword");

	        // Confirm password
	        driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("mypassword");
	        
	        // Submit
	        driver.findElement(By.xpath("//input[@type='submit']")).click();
	    }
}
