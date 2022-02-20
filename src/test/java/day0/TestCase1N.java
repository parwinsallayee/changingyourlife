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

public class TestCase1N {

	 WebDriver driver;
	    
	    @Before
	    public void beforeTest() {
	         WebDriverManager.chromedriver().setup();
	         driver = new ChromeDriver();
	        //1) Open the browser
	        //2) Enter the URL “http://practice.automationtesting.in/”
	         driver.get("http://practice.automationtesting.in/");
	    }
	     
	    @Test
	    public void checkHomePageHasThreeSlides() {
	        //3) Click on Shop Menu
	        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();
	        //4) Now click on Home menu button
	        driver.findElement(By.xpath("//div[@id='content']/nav/a")).click();
	        //5) Test whether the Home page has Three Sliders only
	        //6) The Home page must contains only three sliders
	        List<WebElement>list = driver.findElements(By.xpath("//*[@id='n2-ss-6']/div[1]/div/div/div"));
	        int numOfSlides = list.size();
	        System.out.println("Number of slides: "+numOfSlides);
	        if(numOfSlides==3) {
	            System.out.println("The web page contains three slides");
	        }else {
	            System.out.println("The web page doesn't contains three slides");
	        }

	    }
	    
	    @After
	    public void afterTest() {
	       driver.close();
	    }
	    
	    
	}
