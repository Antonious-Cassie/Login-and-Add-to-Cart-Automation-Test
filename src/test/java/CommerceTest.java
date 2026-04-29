

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommerceTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();

		driver.get("https://sauce-demo.myshopify.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		}
 
	public void login() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
		
		WebElement loginButton = driver.findElement(By.id("customer_login_link"));
		loginButton.click();

		WebElement emailInput = driver.findElement(By.id("customer_email"));
		emailInput.sendKeys("cass901a@gmail.com");

		WebElement passwordInput = driver.findElement(By.id("customer_password"));
		passwordInput.sendKeys("Password123");

		WebElement signInButton = driver.findElement(By.className("button"));
		signInButton.click();

		// Wait for successful login 
		wait.until(ExpectedConditions.urlContains("/account"));
		
		Assert.assertTrue(driver.getCurrentUrl().startsWith("https://sauce-demo.myshopify.com/account")); 
	}
	
 
	@Test 
	public void addToCart() {
		
		login();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));   
		
		driver.get("https://sauce-demo.myshopify.com/collections/all");
		//driver.findElement(By.linkText("Catalog")).click(); 
		driver.findElement(By.partialLinkText("Grey")).click(); 
		
		String greyJacketUrl = "https://sauce-demo.myshopify.com/products/grey-jacket"; 
		Assert.assertEquals(driver.getCurrentUrl(), greyJacketUrl);
		 
		
		driver.findElement(By.id("add")).click();
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("My Cart"))).click(); 
		

		
		Assert.assertTrue(driver.getPageSource().contains("Grey jacket"));
		
	
		 
	
	}
	
	/*@Test 
	public void removeItem() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));   
		
		driver.navigate().refresh();
		
		
		
		 WebElement cartLink = wait.until(
			        ExpectedConditions.elementToBeClickable(By.partialLinkText("My Cart"))
			    );
			    cartLink.click();
		
			    wait.until(ExpectedConditions.elementToBeClickable(By.id("add"))).click();

			    driver.get("https://sauce-demo.myshopify.com/cart");
		
		// wait for remove button to be clickable First
	    WebElement removeBtn = wait.until(
	            ExpectedConditions.elementToBeClickable(By.className("removeLine"))
	        );
		
		removeBtn.click();
		
		//Wait for empty cart message 
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your cart is empty')]"))); 
		
		Assert.assertTrue(driver.getPageSource().contains("Your cart is empty"));
		
		String cartCount = driver.findElement(By.id("cart-target-desktop")).getText();
		Assert.assertEquals(cartCount, "(0)"); 
		
		
	}*/
	
	@Test
	public void logoutTest() {

	    login(); // reuse your existing login method

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // click logout
	    WebElement logoutBtn = wait.until(
	        ExpectedConditions.elementToBeClickable(By.linkText("Log Out"))
	    );
	    logoutBtn.click();

	    // verify you are back on login page
	    wait.until(ExpectedConditions.urlContains("login"));

	    Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}
	
	@AfterMethod
	public void tearDown() {
	    driver.quit();
	}

}
