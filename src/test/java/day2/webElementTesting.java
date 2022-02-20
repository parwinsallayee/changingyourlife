package day2;

	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class webElementTesting {
		WebDriver driver;

		@Before
		public void beforeMethod() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://demo.automationtesting.in/Index.html");
		}
		@Test
		public void inputEmail() {
			driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
			driver.findElement(By.id("enterimg")).click();
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("parwin");
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("sallayee");
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("14085 winding ridge ln");
			driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("Psallayee@gmail.com");
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("7034739521");
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input")).click();
			driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"msdd\"]")).click();
			driver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(7) > div > multi-select > div:nth-child(2) > ul > li:nth-child(1) > a")).click();
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]")).click();
			driver.findElement(By.cssSelector("#Skills")).click();
			driver.findElement(By.id("Skills")).click();
			driver.findElement(By.id("Skills")).sendKeys("Analytics");
			driver.findElement(By.id("Skills")).click();
			driver.findElement(By.cssSelector("#countries")).click();
			driver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(10) > div > span > span.selection > span > span.select2-selection__arrow")).click();
			driver.findElement(By.xpath("//*[@id=\"select2-country-results\"]/li[11]")).click();
			driver.findElement(By.id("yearbox")).sendKeys("1916");// year
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")).click();
			driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")).sendKeys("March");// month
			driver.findElement(By.id("daybox")).sendKeys("1");// day
			driver.findElement(By.cssSelector("#firstpassword")).sendKeys("fairfax123");//password
			driver.findElement(By.cssSelector("#secondpassword")).sendKeys("fairfax123");//confirm password
			driver.findElement(By.xpath("//*[@id=\"submitbtn\"]")).click();// submit click
		}}



	
	
	
	
	
	
	
	
	

