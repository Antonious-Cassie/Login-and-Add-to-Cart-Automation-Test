package tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductPage;

public class addToCartTest extends LoginTest {

	@BeforeMethod
	public void setUp() {
	    loginPage.executeLogin("cass901a@gmail.com", "Password123");
	}
	
	
	
	@Test
	public void addToCart() {
		

		
		ProductPage productPage = new ProductPage(driver);
		
		productPage.openProductPage();
		productPage.clickGreyJacket();
		
		
		String greyJacketUrl = "https://sauce-demo.myshopify.com/products/grey-jacket"; 
		Assert.assertEquals(driver.getCurrentUrl(), greyJacketUrl);
		
		productPage.addToCart();
		
		Assert.assertTrue(driver.getPageSource().contains("Grey jacket"));
	}
	

	@AfterMethod
	public void tearDown() {
	    driver.quit();
	}
	
}

