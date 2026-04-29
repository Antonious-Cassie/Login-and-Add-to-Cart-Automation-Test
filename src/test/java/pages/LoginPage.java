package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {


WebDriver driver; 
By loginButtonLocator = By.id("customer_login_link");
By emailInputLocator = By.id("customer_email"); 
By passwordInputLocator = By.id("customer_password");
By submitButtonLocator = By.className("button");
	

public LoginPage(WebDriver driver) {
	this.driver = driver;	
	
}

public void clickLoginButton() {
	driver.findElement(loginButtonLocator).click();
	
}

public void enterEmail(String email) {
	driver.findElement(emailInputLocator).sendKeys(email);
}

public void enterPassword(String password) {
	driver.findElement(passwordInputLocator).sendKeys(password);
}

public void clickSubmitButton() {
	driver.findElement(submitButtonLocator).click();
	
}

public void waitForLoginSuccess() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.urlContains("/account"));
}

public void executeLogin(String email, String password) {
	clickLoginButton();
	enterEmail(email);
	enterPassword(password);
	clickSubmitButton();
	waitForLoginSuccess();
}

}

