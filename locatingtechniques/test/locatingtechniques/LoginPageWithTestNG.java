package locatingtechniques;

import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class LoginPageWithTestNG {
  WebDriver driver;
  
  @Test
  public void loginTest() {
	  WebElement user = driver.findElement(By.id("username"));

		/*
		 * Calling sendKeys method of WebElement to type "tomsmith" in text box
		 * field
		 */
		user.sendKeys("tomsmith");

		/*
		 * Calling sendKeys() method on password field. Note here WebElement
		 * object is not created and method chaining is used instead. This is
		 * preferred if you are not going perform any other action on the same
		 * text box.
		 */
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		/*
		 * cling on login button.
		 */
		driver.findElement(By.className("radius")).click();

		/*
		 * It is discouraged to use Thread.sleep in our tests. 
		 * We will eventually cover how to do away with them. 
		 * But for this test, check removing below code and see
		 * if the test passes or fails?
		 */
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Verifying after login, "Secure Area" is displayed in at the top.
		 */
		String secureArea = driver.findElement(By.tagName("h2")).getText();

		/*
		 * Verifying expected out with the actual output by checking the value
		 * of some text on the resulting page by using assertEquals() method of 
		 * TestNG.
		 */
		assertEquals(secureArea,"Secure Area","Login Failed as text expected is Secure Area while actual value on page is " + secureArea);

		/* Logging out */
		driver.findElement(By.className("secondary")).click();
		
		/*
		 * It is discouraged to use Thread.sleep in our tests. 
		 * We will eventually cover how to do away with them. 
		 * Thread.sleep below is used so that you can 
		 * observe that it has actually logout and then browser closes.
		 */
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  }
  @BeforeMethod
  public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/login");		
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
