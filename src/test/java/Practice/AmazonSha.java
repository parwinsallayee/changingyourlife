package Practice;



	
	import java.util.ArrayList;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class AmazonSha {
//		4. continue to checkout until you see the 'authentication' page and verify it
		WebDriver driver;
		private String url = "http://automationpractice.com/index.php";

		@Before
		public void beforeMethod() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			1. go to http://automationpractice.com/index.php
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		@Test
		public void test1() {
//			2. click on DRESSES button
			driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();

			String listOfDresses = "//*[@id='center_column']/ul/li";
			List<WebElement> list = driver.findElements(By.xpath(listOfDresses));

			for (int i = 1; i <= list.size(); i++) {
				Actions action = new Actions(driver);
				// handover each of the item
				WebElement selectItem = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + i + "]"));
				action.moveToElement(selectItem).build().perform();

				// On sale dresses
				String onSaleItem = "//*[@id=\"center_column\"]/ul/li[" + i + "]/div/div[2]/div[1]/span[3]";

				if (driver.findElements(By.xpath(onSaleItem)).size() > 0) {

//					3. add items on sale to cart and checkout
					driver.findElement(By.xpath("//*[@id='center_column']/ul/li[" + i + "]/div/div[2]/div[2]/a[1]/span"))
							.click();
					System.out.println(i + " ON SALE");
					driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]")).click();
					driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")).click();

				}

			}
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();

//			4. continue to checkout until you see the 'authentication' page and verify it
			String authenticationCheck = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
			String expectted = "AUTHENTICATION";

			System.out.println("Checkout until you see the " + authenticationCheck);

			if (authenticationCheck.equalsIgnoreCase(expectted)) {
				System.out.println("Passed");
			} else {
				System.out.println("Failed");
			}

		}

	}
	
	
	
	
	

