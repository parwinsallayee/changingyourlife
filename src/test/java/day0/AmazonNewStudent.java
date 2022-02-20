package day0;



	import org.junit.Before;
	import org.junit.Ignore;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Wait;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class AmazonNewStudent {

		WebDriver driver;

		@Before

		public void beforeMethod() {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.amazon.com/");
			driver.manage().window().maximize();

		}

		@Test
		public void searchAmazon() {

			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("charger");

			driver.findElement(By.id("nav-search-bar-form")).submit();

			driver.findElement(By.xpath(
					"//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"))
					.click();

			driver.findElement(By.id("add-to-cart-button")).submit();

			driver.findElement(By.id("nav-cart-text-container")).click();

			driver.findElement(By.id("nav-cart-count")).click();

			driver.findElement(By.id("nav-cart-count")).click();

			WebElement e = driver.findElement(By.xpath("//input[@value='Delete']"));
			e.click();

			driver.get("https://www.youtube.com");
			String actualPageTitle = driver.getTitle();
			String expectedPagetitle = "YouTube";

			if (expectedPagetitle.equalsIgnoreCase(actualPageTitle)) {
				System.out.println("Pass! YouTube title matched.");
			} else {
				System.out.println("Failed! YouTube title does not matched.");

			}

			driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("TechCircle School");

			driver.findElement(By.id("search-icon-legacy")).click();
			
			driver.get("https://www.youtube.com/watch?v=e5YoNE0TJNc"); 

			WebElement video = driver.findElement(By.id("player-container-inner")); 
			
			driver.findElement(By.xpath("//img[@src='https://i.ytimg.com/vi/rFTMGZNbZjg/hqdefault.jpg?sqp=-oaymwEcCOADEI4CSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAzSrqFIJsOrxEMNEtr5uoBLhYjPQ']")).click();

			

	  	 
	      
		}

	}
