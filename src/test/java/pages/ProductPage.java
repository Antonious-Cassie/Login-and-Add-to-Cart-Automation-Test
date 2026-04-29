package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class ProductPage {

	
	WebDriver driver; 
	
	By greyJacketLink = By.partialLinkText("Grey");
	By addToCartLink = By.id("add");
	By checkMyCartLink = By.partialLinkText("My Cart"); 
	
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openProductPage() {
		driver.get("https://sauce-demo.myshopify.com/collections/all");
	}
	
	public void clickGreyJacket() {
		driver.findElement(greyJacketLink).click();
	}
	
	public void addToCart() {
		driver.findElement(addToCartLink).click();
	}
	
	
	
	
}











