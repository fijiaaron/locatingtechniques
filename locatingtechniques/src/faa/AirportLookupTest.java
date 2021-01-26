package faa;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
public class AirportLookupTest {
  private WebDriver driver;
  JavascriptExecutor js;
  @BeforeMethod
public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
  }
  @AfterMethod
public void tearDown() {
    driver.quit();
  }
  @Test
  public void airportLookup() throws InterruptedException {
    driver.get("https://www.faa.gov/");
    driver.manage().window().setSize(new Dimension(1680, 1027));
    js.executeScript("window.scrollTo(0,0)");
    driver.findElement(By.id("airportCode")).sendKeys("GPI");
    driver.findElement(By.id("checkAirport")).click();
    
    Thread.sleep(1000);
    String airportName = driver.findElement(By.cssSelector(".airportInfo b")).getText();
    System.out.println("airportName: " + airportName);
  }
}
