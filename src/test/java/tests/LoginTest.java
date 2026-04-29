package tests;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;


public class LoginTest {

WebDriver driver;
LoginPage loginPage;

@BeforeMethod
public void setUp() {
	driver = new ChromeDriver();
	
	driver.get("https://sauce-demo.myshopify.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	loginPage = new LoginPage(driver);
	
}

@Test

public void testLogin() {
	
	loginPage.executeLogin("cass901a@gmail.com", "Password123");
	
	Assert.assertTrue(driver.getCurrentUrl().startsWith("https://sauce-demo.myshopify.com/account"));
	
}
	
}




