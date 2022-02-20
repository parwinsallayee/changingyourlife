package day0;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountCreate {

	WebDriver driver;

    @Before
    public void openBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        // Using get() method to open a webpage
        driver.manage().window().maximize();

    }

    @Test
    public void alert1() {
    
        WebElement custIdInputBox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
        WebElement submitButton = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
                
                
        
        String cust1Id = "8757878786";
    
        custIdInputBox.sendKeys(cust1Id);
        submitButton.click();
        
        driver.switchTo().alert().accept();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().dismiss();

    
    
    }


}


