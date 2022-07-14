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
import com.SwagLabs.pageobjectpackage.CheckoutPageObject;
import com.SwagLabs.pageobjectpackage.LoginPageObject;
import com.SwagLabs.pageobjectpackage.ProductPageObject;
import com.SwagLabs.pageobjectpackage.YourCartPageObject;
import com.SwagLabs.utilitypackage.LogClass;

/**
 * @author ravindrs
 *
 */
public class UserInfoPageTestCase extends BaseClass{
	
	LoginPageObject loginPage;
	ProductPageObject productPage;
	YourCartPageObject yourCart;
	CheckoutPageObject checkOutPage;
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

	@Test (dataProvider ="User_Details", dataProviderClass = DataProviderClass.class)
	public void checkOutPageTestCase(String firstName, String lastName, String code) throws InterruptedException {
		LogClass.startTestCase("checkOutPageTestCase");
		loginPage = new LoginPageObject();
		//productPage=loginPage.loginSwagLabs(prop.getProperty("username"),prop.getProperty("password"));
		LogClass.info("In login page");
		productPage=loginPage.loginSwagLabs("standard_user", "secret_sauce");
		LogClass.info("User credentials passed and clicked on login button");
		productPage.addToCart();
		LogClass.info("Product added to cart");
		yourCart=productPage.clickOnCart();
		LogClass.info("Clicked on cart icon");
		checkOutPage=yourCart.clickOnCheckOut();
		LogClass.info("Clicked on checkout button");
		LogClass.info("In Check your information page");
		checkOutPage.addInfo(firstName, lastName, code);
		LogClass.info("Added User information");
		
		String actText=checkOutPage.verifyOverview();
		String extText="CHECKOUT: OVERVIEW";
		
		//Assert.assertEquals(actText, extText);
		LogClass.info("we are checkout overview page");
		LogClass.endTestCase("checkOutPageTestCase");
		
	}

}
