package day0;



	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class AmazonStudent {
		/*
		 * Go to Amazon.com
		 * send "any key"
		 * click search
		 * select one of the item
		 * add it to cart
		 * validate the item in the cart
		 * remove the item
		 * validate the cart is empty
		 * navigate to Youtube
		 * validate the title is youtube
		 * search video
		 * play the video
		 * */
		
		WebDriver driver;
		
		String item = "(4 Pack) AR-PRO 10\" Heavy-Duty Replacement Tire and Wheel - 4.10/3.50-4\" with 10\" Inner Tube, 5/8\" Axle Bore Hole, 1 3/4\" Offset Hub and Double Sealed Bearings for Hand Trucks and Gorilla Cart";
		
		@Before
		public void beforeTest() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.amazon.com");
			driver.manage().window().maximize();
		}
		
		@After
		public void afterTest() {
			//driver.close();
		}
		
		@Test
		public void amazonAndYoutube() throws InterruptedException {
			//search for item
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(item);  
			driver.findElement(By.id("nav-search-submit-button")).click();     
			Thread.sleep(2000);
			//add select item
			driver.findElement(By.linkText(item)).click();  
			//select one time purchase
			
			driver.findElement(By.id("add-to-cart-button")).click(); 
			//go to cart
			driver.findElement(By.id("nav-cart-count")).click(); 
			//validate item in cart
			chekItemInCart();                                   
			//remove item from cart
			driver.findElement(By.xpath("//input[@value='Delete']")).click(); 
			//validate the empty cart
			Thread.sleep(3000);
			chekItemInCart();
			
			//navigate to Youtube.com
			driver.navigate().to("https://www.youtube.com");
			
			//validate the title
			String expectedTitle = "Youtube";
			String actualTitle = driver.getTitle();
			if(expectedTitle.equalsIgnoreCase(actualTitle)) {
				System.out.println("Title matched");
			}else {
				System.out.println("Title not matched");
			}
			
			
			
			//search video
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("The lion king");
			driver.findElement(By.id("search-icon-legacy")).click();
			
			//play video
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();
			Thread.sleep(2000);
			
		}   

		public void chekItemInCart() {
			//verify there is item in a cart
			String cartText = driver.findElement(By.id("sc-subtotal-label-activecart")).getText();
			//System.out.println(cartText);
			int itemInCart;
			int digitIndexFirst = 0;
			int digitIndexLast = 0;
			for(int i = 0 ; i < cartText.length() ; i++) {
				if (cartText.charAt(i)>=48 && cartText.charAt(i)<=57) {
					digitIndexFirst = (int)i;
					break;
				}
			}
			for(int i = cartText.length()-1 ; i >= 0 ; i--) {
				if (cartText.charAt(i)>=48 && cartText.charAt(i)<=57) {
					digitIndexLast = (int)i;
					break;
				}
			}
			itemInCart = Integer.parseInt(cartText.substring(digitIndexFirst,digitIndexLast+1));
			System.out.println("Total item in the cart is: "+ String.valueOf(itemInCart));
			if(itemInCart>0) {
				System.out.println("Cart is not empty");
			}else {
				System.out.println("Cart is empty");
			}
		}

	}
