package Oct_20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeadLessExection {
	WebDriver driver;

	@BeforeMethod
	public void launch()
	{
		 driver= new HtmlUnitDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
	}
  @Test
  public void login() 
  {	
	  System.out.println(driver.getTitle());
		//found the pwd
		WebElement pwd= driver.findElement(By.name("password"));
		pwd.sendKeys("mercury");
		System.out.println(driver.getTitle());
  }
}
