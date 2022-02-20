package Practice;

import java.util.concurrent.TimeUnit;

import org.junit.Before;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Alert {



	WebDriver driver;
	

	@Before
		public void beforeMethod() {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://demoqa.com/alerts");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			
	     

	   @Test

	        // Click on the Button "Timing Alert"

	       driver.findElement(By.cssSelector("#alertButton")).click();


	        // Create new WebDriver wait

	        WebDriverWait wait = new WebDriverWait(driver, 10);

	        // Wait for Alert to be present

	        org.openqa.selenium.Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());

	        System.out.println("Either Pop Up is displayed or it is Timed Out");

	        // Accept the Alert

	        myAlert.accept();

	        System.out.println("Alert Accepted");

	        // Close the main window

	        driver.close();

		}

}
