package day0;




import java.util.Iterator; 
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getWindowHandlesTask {

	WebDriver driver;

	@Before
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://phptravels.com/demo");
		driver.manage().window().maximize();

	}

	@Test
	public void test() {

		String parentTab = driver.getWindowHandle();
		System.out.println(parentTab);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement customerFrontEnd = driver.findElement(
				By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/a/small"));

		customerFrontEnd.click();

		WebElement agentFrontEnd = driver.findElement(
				By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[3]/div/div/div[2]/div/div/div[1]/div/a/small"));

		WebElement adminBackEnd = driver.findElement(
				By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[4]/div/div/div[2]/div/div/div[1]/div/a/small"));

		WebElement supplierBackEnd = driver.findElement(
				By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/a/small"));

		Set<String> allWindows = driver.getWindowHandles();

		System.out.println(allWindows);

		for (String childTab : allWindows) {
			if (!parentTab.equalsIgnoreCase(childTab)) {
				driver.switchTo().window(parentTab);
				agentFrontEnd.click();
				driver.switchTo().window(parentTab);
				adminBackEnd.click();
				driver.switchTo().window(parentTab);
				supplierBackEnd.click();
				driver.switchTo().window(parentTab);

			}

		}

		String supplierBackEnd_title = "Supplier Login";
		System.out.println(supplierBackEnd_title);

		Set<String> allWindows4 = driver.getWindowHandles();

		for (String childTabNew : allWindows4) {
			driver.switchTo().window(childTabNew);
			driver.getTitle();

			if (driver.getTitle().contains(supplierBackEnd_title)) {

				driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/label[1]/input"))
						.sendKeys("supplier@phptravels.com");
				driver.findElement(By.xpath("/html/body/div[1]/form[1]/div[1]/label[2]/input")).sendKeys("demoadmin");
				driver.findElement(By.xpath("/html/body/div[1]/form[1]/button/span[1]")).click();
			} 
			
		}
	}
//	@After
//	
//	public void closeBrowser() {
//		driver.close();
//	}
}




