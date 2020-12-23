package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiTime {
	
	static 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver1.exe");
	}
	static WebDriver driver;

	public static void main(String[] args)
	{
		ActiTime a= new ActiTime();
	    driver=new  ChromeDriver();
		driver.get("http://localhost/login.do");
		driver.manage().window().maximize();
		a.logIn();
	

	}
	 public void logIn() 
	 {
		 driver.findElement(By.id("username")).sendKeys("admin");
		 driver.findElement(By.name("pwd")).sendKeys("manager");
		 driver.findElement(By.xpath("//div[text()='Login ']")).click();
		 WebElement eRRmsg =driver.findElement(By.xpath("//span[contains(text(),' invalid. ')]"));
		 String actErrmsg=eRRmsg.getText();
		 String expectedErr = "Username or Password is invalid. Please try again.";
		 if(actErrmsg.equals(expectedErr))
		 {
			 System.out.println("The error message is diaplayed " + expectedErr );
		 }
		 
		 
	 }
	 public void logOut() 
	 {
		 driver.findElement(By.linkText("Logout")).click();
		 
	 }

}
