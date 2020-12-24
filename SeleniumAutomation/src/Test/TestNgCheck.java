package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgCheck 
{
	WebDriver driver;
	@BeforeTest
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver1.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
	}
	@Test
	public void loggIn()
	{
		 driver.findElement(By.id("username")).sendKeys("admin");
		 driver.findElement(By.name("pwd")).sendKeys("manager");
		 driver.findElement(By.xpath("//div[text()='Login ']")).click();
	}
	@AfterTest
	public void logOut() 
	 {
		 driver.findElement(By.linkText("Logout")).click();
		 
	 }

}
