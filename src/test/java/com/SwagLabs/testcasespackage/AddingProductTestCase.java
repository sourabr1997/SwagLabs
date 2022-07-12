/**
 * 
 */
package com.SwagLabs.testcasespackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.SwagLabs.basepackage.BaseClass;
import com.SwagLabs.dataproviderpackage.DataProviderClass;
import com.SwagLabs.pageobjectpackage.LoginPageObject;
import com.SwagLabs.pageobjectpackage.ProductPageObject;
import com.SwagLabs.utilitypackage.LogClass;

/**
 * @author ravindrs
 *
 */
public class AddingProductTestCase extends BaseClass{
	
	LoginPageObject loginPage;
	ProductPageObject productPage;
	//YourCart yourCart;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName) {
		launchApp(browserName);
	}

	@Test (dataProvider ="Login", dataProviderClass = DataProviderClass.class)
	public void addProductToCartTestCase(String uname, String pass) throws InterruptedException {
		LogClass.startTestCase("addProductToCartTestCase");
		loginPage = new LoginPageObject();
		LogClass.info("In login page");
		productPage=loginPage.loginSwagLabs(uname, pass);
		LogClass.info("User credentials passed and clicked on login button");
		//productPage=loginPage.loginSwagLabs(prop.getProperty("username"),prop.getProperty("password"));	
		productPage.addToCart();
		LogClass.info("Product added to cart");
		productPage.clickOnCart();
		LogClass.info("Clicked on cart icon");
		String actext=productPage.verifyCartItem();
		String exptext ="YOUR CART";
		Assert.assertEquals(actext, exptext);
		
		LogClass.info("We are in your Profuct page TC passed");
		LogClass.endTestCase("addProductToCartTestCase");
		}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
		
	}

}
