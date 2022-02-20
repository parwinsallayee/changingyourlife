package day0;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2N {
	

	    
		WebDriver driver;
		    
		    @Before
		    public void beforeTest() {
		         WebDriverManager.chromedriver().setup();
		         driver = new ChromeDriver();
		        //1) Open the browser
		        //2) Enter the URL “http://practice.automationtesting.in/”
		         driver.get("http://practice.automationtesting.in/");
		         
		    }
		    
		    @After 
		    public void afterTest() {
		       // driver.close();
		    }
		    
		    @Test
		    public void testThreeArrivals() throws InterruptedException {
		    //3) Click on Shop Menu
		    driver.findElement(By.xpath("//*[@id='menu-item-40']/a")).click();
		  //*[@id="menu-item-40"]/a
		    Thread.sleep(1000);
		    //4) Now click on Home menu button
		    driver.findElement(By.xpath("//*[@id='content']/nav/a")).click();
		    
		  //*[@id="content"]/nav/a
		    //5) Test whether the Home page has Three Arrivals only
		    //6) The Home page must contains only three Arrivals
		  //*[@id="themify_builder_content-22"]/div[2]/div/div/div/div/div[2]/div
		    Thread.sleep(1000);
		    List<WebElement> newArrivals = driver.findElements(By.xpath("//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));
		    int numNewArriavals = newArrivals.size();
		    System.out.println("New arrivals: "+ numNewArriavals);
		    if(numNewArriavals==3) {
		        System.out.println("The home page has three arrivals.");
		    }else {
		        System.out.println("The home page does not contains three arrivals. XXX");
		    }
		    
		    }
		}

