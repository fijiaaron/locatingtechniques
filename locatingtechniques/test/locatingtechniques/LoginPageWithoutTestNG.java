/*
 * This program demonstrates how to write a basic
 * WebDriver test
 * 
 */
package locatingtechniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPageWithoutTestNG {

	public static void main(String[] args) {
		/*
		 * FirefoxDriver searches for geckodriver.exe on the path specified by
		 * the "webdriver.gecko.driver" environment variable
		 */
		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver.exe");
		/*
		 * Declaring driver object reference of type WebDriver which is pointing
		 * to an object of FirefoxDriver. This will open Firefox browser.
		 */
		WebDriver driver = new FirefoxDriver();
		/*
		 * get() method gets the url specified as a parameter.
		 */
		driver.get("https://the-internet.herokuapp.com/login");

		/*
		 * findElement in WebDriver returns the WebElement. The parameter passed
		 * of type By class. The locating technique used is id. "username" is
		 * nothing but the id attribute of the text box in which we need to type
		 * "tomsmith". You can do inspect element by right clicking on the element
		 * on the page.
		 */
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
		 * of some text on the resulting page.
		 */

		if (secureArea.equals("Secure Area"))
			System.out.println("Login Successful");
		else
			System.out.println("Login Failed");

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

		/*
		 * Closing the browser after test execution is done.
		 */
		driver.quit();
	}

}