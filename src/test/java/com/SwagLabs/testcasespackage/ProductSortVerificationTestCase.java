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
public class ProductSortVerificationTestCase extends BaseClass{
	
	ProductPageObject productPageForSorting;
	
	@Parameters("browser")
	@BeforeMethod 
	public void setup(String browser) {
		launchApp(browser);
	}
	 
	@Test (dataProvider ="Login", dataProviderClass = DataProviderClass.class)
	public void sortVerificationTestCase(String uname, String pass) throws Throwable {
		LogClass.startTestCase("userLoginTestcaseSwagLab");
		LoginPageObject loginPage = new LoginPageObject();
		//loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		LogClass.info("In login page");
		productPageForSorting = loginPage.loginSwagLabs(uname, pass);
		LogClass.info("User credentials passed and clicked on login button");
		LogClass.info("We are in Profucts page");
		
		String sortType = "Descending";
		
		
		if (sortType.equalsIgnoreCase("Ascending")) {
			
			productPageForSorting.selectDropDownOption(sortType);
			LogClass.info("Page sorted");
			double top = productPageForSorting.topProductValue();
			double bottom = productPageForSorting.bottomProductValue();
			if (top < bottom) {
				Assert.assertEquals(true, true);
				LogClass.info("Product page in ascending order");
				LogClass.endTestCase("sortVerificationTestCase completed");
			}
			
		}
			else if (sortType.equalsIgnoreCase("Descending")) {
				
				productPageForSorting.selectDropDownOption(sortType);
				LogClass.info("Page sorted");
				double top2 = productPageForSorting.topProductValue();
				double bottom2 = productPageForSorting.bottomProductValue();
				if (top2 > bottom2) {
					Assert.assertEquals(true, true);
					LogClass.info("Product page in descending order");
					LogClass.endTestCase("sortVerificationTestCase completed");
				}
			
			}
		
		}	
		
		
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
		
	}
	
	
	

}
