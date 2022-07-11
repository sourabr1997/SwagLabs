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
import com.SwagLabs.utilitypackage.LogClass;

import jdk.internal.org.jline.utils.Log;

/**
 * @author ravindrs
 * This class contains the scenario for user login verification
 *
 */
public class UserLoginTestCase extends BaseClass {
	
	@Parameters("browser")
	@BeforeMethod 
	public void setup(String browser) {
		launchApp(browser);
	}
	
	
	 
	@Test (dataProvider ="Login", dataProviderClass = DataProviderClass.class)
	public void userLoginTestcaseSwagLab(String uname, String pass) throws Throwable {
		LogClass.startTestCase("userLoginTestcaseSwagLab");
		LoginPageObject loginPage = new LoginPageObject();
		//loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		LogClass.info("In login page");
		loginPage.loginSwagLabs(uname, pass);
		LogClass.info("User credentials passed and clicked on login button");
		String actualURL=loginPage.verifyLogin();
		String expectedURL = "PRODUCTS";
	
		LogClass.info("We are in Profucts page TC passed");
		LogClass.endTestCase("userLoginTestcaseSwagLab");
		
		Assert.assertEquals(actualURL, expectedURL);
		
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
		
	}


}
