package day0;


	import java.util.List;
import java.util.concurrent.TimeUnit;

	import org.apache.hc.client5.http.nio.AsyncClientConnectionManager;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.github.bonigarcia.wdm.WebDriverManager;

	/*
	 *  1. go to http://automationpractice.com/index.php
	    2. click on DRESSES button
	    3. add items on sale to cart and checkout
	    4. continue to checkout until you see the 'authentication' page and verify it
	    */

	public class SecondTry {

		WebDriver driver;
		WebDriverWait wait;
		String email = "psas12@gmail.com";
		String firstName = "pay";
		String lastName = "Last";
		String password = "MXL233";
		String date = "9";
		String month = "5";
		String year = "2018";
		String company = "sixsigma llc";
		String addressStreet = "14085 Winding ridge ln";
		String city = "Centreville";
		String state = "Virginia";
		String zipCode = "20121";
		String mobilePhone = "371-000-1212";
		
		@Before
		public void beforeTest() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://automationpractice.com/index.php");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			
			
		}
		@Test
		public void Example() {
			
			driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();// click on dress 
			
			
			driver.findElement(By.xpath("//*[@id=\"special_block_right\"]/p/a")).click();
		
			
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
			
			
			driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
		
			driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")).click();//continue shopping
			
			driver.navigate().back();
			
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")).click();
			
			driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
			
			driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
			
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
	
		
		//cart
		
driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b")).click();
driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"))	.click();
driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys(email);

	driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
	
	//personal information
	driver.findElement(By.xpath("//*[@id=\"uniform-id_gender2\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys(firstName);
	driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys(lastName);
	
	driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password);
	//day(dropDown)
	WebElement dayDrop = driver.findElement(By.id("days"));
	Select dateSelect = new Select(dayDrop);
	dateSelect.selectByValue(date);
	//Month
	WebElement monthDrop = driver.findElement(By.id("months"));
	Select monthSelect = new Select(monthDrop);
	monthSelect.selectByValue(month);
	//Year
	WebElement yearDrop = driver.findElement(By.id("years"));
	Select yearSelect = new Select(yearDrop);
	yearSelect.selectByValue(year);
	//signup newsletter
	WebElement news = driver.findElement(By.id("newsletter"));
	if(news.isSelected()) {
		news.click();
	

	// special sign up
	WebElement specialSignUp = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[7]/label"));
	if(specialSignUp.isSelected()) {
		specialSignUp.click();
		//fill in first name
		driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys(firstName);
		//filll in last name
		driver.findElement(By.id("//*[@id=\"customer_firstname\"]")).sendKeys(lastName);
		//fill in company name
		driver.findElement(By.id("//input[@id=\'company\']")).sendKeys(company);
		//fill in street address
		driver.findElement(By.id("//*[@id=\'address1\']")).sendKeys(addressStreet);
		//fill in city
		driver.findElement(By.id("//*[@id=\'city\']")).sendKeys(city);
		//select state from dropdown
		WebElement dropdown = driver.findElement(By.id("id_state"));
		Select select = new Select(dropdown);
		select.selectByVisibleText(state);
		//fill in zip code
		driver.findElement(By.id("//*[@id=\'postcode\']")).sendKeys(zipCode);
		//fill in mobile phone number
		driver.findElement(By.id("//*[@id=\'phone\']")).sendKeys(mobilePhone);
		//fll in alias address
		driver.findElement(By.id("//*[@id=\'alias\']")).sendKeys(addressStreet);
		//click submit
		driver.findElement(By.id("submitAccount")).click();

	driver.findElement(By.xpath("//*[@id=\'submitAccount\']/span")).click();
	
		}	
}
}}