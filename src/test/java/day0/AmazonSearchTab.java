package day0;



	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class AmazonSearchTab { 

		WebDriver driver;

		@Before
		public void openBrowser() {

			// 1. go to https://phptravels.com/demo
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.amazon.com/");
			driver.manage().window().maximize();

		}

		@Test
		public void searchBox() {

			// 1. relative xpath
			driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("TV");
			// 2. contains xpath
			driver.findElement(By.xpath("//*[contains(@id,'twotabsearchtextbox')]")).sendKeys("TV");
			// 3. 'and/or' xpath
			driver.findElement(By.xpath("//*[@id='twotabsearchtextbox' or @class='nav-input nav-progressive-attribute']"))
					.sendKeys("TV");
			driver.findElement(By.xpath("//*[starts-with(@id, 'twotab') and @class='nav-input nav-progressive-attribute']"))
					.sendKeys("TV");
			// 4. 'starts-with' xpath
			driver.findElement(By.xpath("//*[starts-with(@id, 'twotab')]")).sendKeys("TV");
			// 5. text xpath - there was no visible text
			// 6. using index - wasn't able to locate shared attribute to give index
			// 7. absolute xpath
			driver.findElement(By
					.xpath("//html/body/div/header/div/div[1]/div[2]/div/form/div[2]/div/input[@id='twotabsearchtextbox']"))
					.sendKeys("TV");

		}

	}
	
	
	

