package day0;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTry {
WebDriver driver;
WebElement element;
	
	@Before
	public void beforeTest() {
		
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.get("http://automationpractice.com/index.php");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		
	By dressBtn = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
	
	//click on dress button
	driver.findElement(dressBtn).click();
	
	int totalProduct = driver.findElements(By.xpath("//ul[contains(@class, 'product')]/li")).size();
	
	
	//if no product for sale, fail the test
	
	Assert.assertFalse(totalProduct==0);
	
	//Search all products that are on sale
	
	for(int i =1; i<= totalProduct; i++) {
		
// xpath for product price
		
By productPricePath = By.xpath("//ul[contains(@class, 'product')]/li[\" + i\n"
		+ "					+ \"]//div[@class='right-block']/div[@itemprop='offers']/*");	
		
		// for each products, search if a product is on sale by checking %.

List<WebElement> prices = driver.findElements(productPricePath);
for(int j =0; j<= prices.size(); j++) {
	
	
	String percent = prices.get(j).getText();
	
	//this product is on sale.perform the action
	if(percent.contains("%")) {
		
		
		// Hover mouse to this item
		Actions action = new Actions(driver);
		
		WebElement hoverToItem = driver.findElement(By.xpath("//ul[contains(@class, 'product')]/li[" + i + "]//descendant::img"));
		
		
		
		
	}
	
	
	
	
}
		
		
		
	}
		
		
		
	}
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
}
