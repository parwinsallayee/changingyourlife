package day0;

import java.util.List; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropDowns {
static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		//approach1
//	Select noOfEmpsdrp=new Select(driver.findElement(By.name("NoOfEmployees")));
//	noOfEmpsdrp.selectByVisibleText("16 - 20");
//	
//	Select industryDrp = new Select (driver.findElement(By.name("Industry")));
//	industryDrp.deselectByVisibleText("Travel");
//	
//	Select countryyDrp = new Select (driver.findElement(By.name("Country")));	 
//	countryyDrp.deselectByVisibleText("Aruba");
	//approach2	
		
	WebElement noOfEmpsEle= driver.findElement(By.name("NoOfEmployees"));
	selectOptionFromDropDown(noOfEmpsEle,"16 - 20");
	
	
	WebElement industryEle= driver.findElement(By.name("Industry"));
	selectOptionFromDropDown(industryEle,"Healthcare");
	
	
	WebElement CountryEle= driver.findElement(By.name("Country"));
	selectOptionFromDropDown(CountryEle,"Ghana");
	
	
	
	}
	
	public static void selectOptionFromDropDown(WebElement ele, String value)
	{
		Select drp = new Select(ele);
		
	List<WebElement> alloptions = drp.getOptions();
	
	for(WebElement option : alloptions){
		
		if(option.getText().equals(value)) {
			option.click();
			break;
		}
		
		
	}
	
		
		
		
		
	}
}
