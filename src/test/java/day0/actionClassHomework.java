package day0;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actionClassHomework {

	WebDriver driver;

	@Before
	public void openBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		// Using get() method to open a webpage
		driver.manage().window().maximize();

	}

	@Test
	public void mouseActions() {

		Actions action = new Actions(driver);

		// test mouse over function for each tab through loop    
		List<WebElement> interactions = driver.findElements(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li"));

		for (int i = 0; i < interactions.size(); i++) {
			action.moveToElement(interactions.get(i)).build().perform();

		}

		// test contextClick (rightClick) on a chosen tab
		for (int i = 0; i < interactions.size(); i++) {

			if (interactions.get(i).getText().contains("Selectable")) {
				action.contextClick(interactions.get(i)).build().perform();
			}

		}
		
	}

}
