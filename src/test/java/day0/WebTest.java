package day0;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class WebTest {
	

	 

	
		
		WebDriver driver;
		String firstName = "MyFirstName";
		String lastName = "MyLastName";
		String phoneNumber = "1231231234";
		String address = "123 Earth st, Germantown, MD 20874";
		String email = "abcd@gmail.com";
		String password = "12345678";
		//DOB
		String date = "28";
		String month = "December";
		String year = "1009";

		
		@Before
		public void beforeTest() {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://demo.automationtesting.in/Index.html");
			
			
		}
		
		
//		@After
//		public void afterTest() throws InterruptedException {
//			Thread.sleep(200);
//			driver.close();
//		}
		
		@Test
		public void inputEmailAddressAndFillTheForm() {
			//enter email and click submit on first page
			driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
			driver.findElement(By.id("enterimg")).click();
			//input first name, last name, address, phone number
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys(firstName);
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys(lastName);
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys(address);
			driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys(email);
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys(phoneNumber);
					//click to check hobbies; cricket and movie
			driver.findElement(By.id("checkbox1")).click();
			driver.findElement(By.id("checkbox2")).click();
			//click language and click to select English
			driver.findElement(By.id("msdd")).click();
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[37]/a")).click();

			//click to select gender
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")).click();

			//click and select skill
			driver.findElement(By.id("Skills")).click();
			driver.findElement(By.id("Skills")).sendKeys("Java");
			driver.findElement(By.id("Skills")).click();
			
			//click and select "select country"
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span")).click();
			driver.findElement(By.xpath("//*[@id=\"select2-country-results\"]/li[11]")).click();
			
			//fill in DOB
			driver.findElement(By.id("yearbox")).sendKeys(year);
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")).sendKeys(month);
			driver.findElement(By.id("daybox")).sendKeys(date);
			
			//create password and confirm password
			driver.findElement(By.id("firstpassword")).sendKeys(password);
			driver.findElement(By.id("secondpassword")).sendKeys(password);
			
			//click submit
			driver.findElement(By.id("submitbtn")).click();
			
		}
		

		

	}
	
	

