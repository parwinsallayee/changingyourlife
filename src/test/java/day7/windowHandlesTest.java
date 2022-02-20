package day7;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandlesTest {

	
	WebDriver driver;
    private String url = "https://phptravels.com/demo";

    @Before
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    
    @Test
    public void loginAgentFrontEndPage() throws InterruptedException {
        
        String Email = "agent@phptravels.com";
        String Password  = "demoagent";
        
        //should open up the front end page
        driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[3]/div/div/div[2]/div/div/div[1]/div/a")).click();
        
        //switch my selenium to new window
        
        System.out.println("Before switching -- title is --> " + driver.getTitle());
        
        Set<String> ids = driver.getWindowHandles();
        
        Iterator<String> it = ids.iterator();
        
        String parentID = it.next();
        String childID = it.next();
        
        
        driver.switchTo().window(childID);
        System.out.println("After Switching to Child window >> " + driver.getTitle());
        
    
        //try login in to front end agent application
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input")).sendKeys(Email);
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input")).sendKeys(Password);
        driver.findElement(By.xpath("//*[@id=\"cookie_stop\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button")).click();

        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[3]/ul/li[3]/a")).click();//

       // driver.findElement(By.cssSelector("li[class='user_wallet '] a[class=' waves-effect']"));
        
        driver.findElement(By.xpath("//*[@id=\"gateway_bank-transfer\"]")).click();

        Thread.sleep(2000);//li[contains(@class,'user_wallet')]//a[contains(@class,'waves-effect')][normalize-space()='Add Funds']

        driver.findElement(By.xpath(
                "//*[@id=\"fadein\"]/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div/div[2]/div/button"))
                .click();

        String result = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/small/strong")).getText();

        String result1 = "Bank Transfer USD 50.00";

        if (result.equalsIgnoreCase(result1)) {

            System.out.println(result);

            Thread.sleep(2000);

            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]")).click();

            Thread.sleep(2000);

           // driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/a")).click();

            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/a[1]")).click();
            
            Thread.sleep(2000);

           // driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[3]/ul/li[5]/a")).click();
            driver.findElement(By.cssSelector("div[class='sidebar-nav'] li:nth-child(5) a:nth-child(1)")).click();
        }

    }

}
//        driver.switchTo().window(parentID);
        
    