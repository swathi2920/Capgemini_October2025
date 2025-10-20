package Oct_20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorDemo {

	public static void main(String[] args) {

		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
	
		//found the pwd
		WebElement pwd= driver.findElement(By.name("password"));
		
		//find unm
		WebElement unm=driver.findElement(RelativeLocator.with(By.tagName("input")).above(pwd));
		unm.sendKeys("mercury"); // pass data to unm
		
		pwd.sendKeys("mercury"); // pass data to pwd
		
		//find submit button
		WebElement submit= driver.findElement(RelativeLocator.with(By.tagName("input")).below(pwd));
		submit.click();
	}

}
