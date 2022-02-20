package day0;



import java.util.concurrent.TimeUnit;

/* 1. go to http://automationpractice.com/index.php
    2. click on DRESSES button
    3. add items on sale to cart and checkout
    4. continue to checkout until you see the 'authentication' page and verify it*/	
	


		import java.util.concurrent.TimeUnit;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.interactions.Actions;

		import io.github.bonigarcia.wdm.WebDriverManager;
		public class NewTask {
		
		 
		 public static void main(String[] args) throws InterruptedException{

		  WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  String URL="http://automationpractice.com/index.php";

		  driver.get(URL);
		  driver.manage().window().maximize();
		  
		  // Initialise Actions class object
		  Actions actions=new Actions(driver);
		  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		  WebElement womenTab=driver.findElement(By.linkText("WOMEN"));
		  WebElement TshirtTab=driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul//a[@title='T-shirts']"));
		  actions.moveToElement(womenTab).moveToElement(TshirtTab).click().perform();
		  Thread.sleep(2000);
		  
		  // Get Product Name
		  String ProductName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();
		  System.out.println(ProductName);
		  driver.findElement(By.id("search_query_top")).sendKeys(ProductName);
		  driver.findElement(By.name("submit_search")).click();
		  
		  // Get Name of Searched Product
		  String SearchResultProductname=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();

		  // Verify that correct Product is displaying after search
		  if(ProductName.equalsIgnoreCase(SearchResultProductname)) {
		   System.out.println("Results Matched;Test Case Passed");
		  }else{
		   System.out.println("Results NotMatched;Test Case Failed");
		  }
		  
		  // Close the browser
		  driver.close();
		 }

		}
