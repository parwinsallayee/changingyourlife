package day3;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxIntro {

	
	WebDriver driver;

	@Before
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	
	}
	@Test
    public void test1() {
        
        //navigate to checkbox page
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a")).click();
        
        WebElement firstCheckboxElement = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement secondCheckboxElement = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        
        Boolean firstCheckbox = firstCheckboxElement.isSelected(); //false
        
        Boolean secondCheckbox = secondCheckboxElement.isSelected();

        
        
        

        if(firstCheckbox) {
            System.out.println("First Checkbox is not selected");
        }else {
            firstCheckboxElement.click();
        }
        
        if(secondCheckbox) {
            System.out.println("Second Checkbox is alread selected");
        }else {
            secondCheckboxElement.click();
        }
        
        
        
    
    }
	
	
	
	
	
	
	
	
	
}
