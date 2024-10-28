import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SelectProductTest {

  private WebDriver driver;
  JavascriptExecutor js;

  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().maximize();
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void selecionarProduto() {
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"title\"]")).getText(), is("Products"));
    driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).click();
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"back-to-products\"]")).getText(), is("Back to products"));
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).getText(), is("Sauce Labs Backpack"));
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-price\"]")).getText(), is("$29.99"));
    driver.findElement(By.cssSelector("*[data-test=\"add-to-cart\"]")).click();
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"shopping-cart-badge\"]")).getText(), is("1"));
    driver.findElement(By.cssSelector("*[data-test=\"shopping-cart-link\"]")).click();
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"title\"]")).getText(), is("Your Cart"));
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"item-quantity\"]")).getText(), is("1"));
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-name\"]")).getText(), is("Sauce Labs Backpack"));
    assertEquals(driver.findElement(By.cssSelector("*[data-test=\"inventory-item-price\"]")).getText(), is("$29.99"));
    driver.findElement(By.cssSelector("*[data-test=\"remove-sauce-labs-backpack\"]")).click();
    driver.findElement(By.id("react-burger-menu-btn")).click();
    driver.findElement(By.cssSelector("*[data-test=\"logout-sidebar-link\"]")).click();
    driver.close();
  }
}