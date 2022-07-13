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
import com.SwagLabs.pageobjectpackage.YourCartPageObject;
import com.SwagLabs.utilitypackage.LogClass;

/**
 * @author ravindrs
 *
 */
public class CheckoutPageTestCase extends BaseClass {
	
	LoginPageObject loginPage;
	ProductPageObject productPage;
	YourCartPageObject yourCart;
	//CheckOutInfoPage checkOutInfo;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName) {
		launchApp(browserName);
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
		
	}

	@Test (dataProvider ="Login", dataProviderClass = DataProviderClass.class)
	public void checkOutPageTestCase(String uname, String pass) throws InterruptedException {
		LogClass.startTestCase("checkOutPageTestCase");
		loginPage = new LoginPageObject();
		//productPage=loginPage.loginSwagLabs(prop.getProperty("username"),prop.getProperty("password"));
		LogClass.info("In login page");
		productPage=loginPage.loginSwagLabs(uname, pass);
		LogClass.info("User credentials passed and clicked on login button");
		productPage.addToCart();
		LogClass.info("Product added to cart");
		yourCart=productPage.clickOnCart();
		LogClass.info("Clicked on cart icon");
		yourCart.clickOnCheckOut();
		LogClass.info("Clicked on checkout button");
		String actualtext=yourCart.verifyChechOutPage();
		String expcttext = "CHECKOUT: YOUR INFORMATION";
		Assert.assertEquals(actualtext, expcttext);
		
		LogClass.info("we are in add your information page");
		LogClass.endTestCase("checkOutPageTestCase");
	}		

}
