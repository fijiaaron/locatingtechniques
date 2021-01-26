package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest
{

	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("Testing login with Firefox and Selenium");
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// open login page (add https -- change)
		driver.get("https://the-internet.herokuapp.com/login");
		
		// set window size 
		driver.manage().window().maximize();
		
		// enter user name
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		
		// enter password
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

		// click login button
		driver.findElement(By.xpath("//form[@id='login']/button")).click();
		
		// verify logged into secure area
		String message = driver.findElement(By.cssSelector(".flash")).getText();
		if (message.contains("You logged into a secure area!"))
		{
			System.out.println("login succeeded");
		}
		else 
		{
			throw new RuntimeException("Login failed");
		}
		
		// click logout button
		driver.findElement(By.linkText("Logout")).click();
		
		
		// verify logout
		message = driver.findElement(By.className("flash")).getText();
		if (message.contains("You logged out of the secure area!"))
		{
			System.out.println("lougout succeeded");
		}
		else 
		{
			throw new RuntimeException("Logout failed");
		}
				
		Thread.sleep(3000);
		driver.quit();
	}

}
