/**
 * 
 */
package com.SwagLabs.pageobjectpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SwagLabs.actionpackage.ActionClass;
import com.SwagLabs.basepackage.BaseClass;

/**
 * @author ravindrs
 *
 */
public class ProductPageObject extends BaseClass{
	
	@FindBy (xpath ="//*[@id=\"add-to-cart-sauce-labs-backpack\"]")WebElement product;
	@FindBy (xpath ="//*[@id=\"shopping_cart_container\"]/a/span")WebElement cart;
	@FindBy (xpath ="//*[@id=\"header_container\"]/div[2]/span")WebElement your_cart;
	
	
	
	public ProductPageObject() {
		PageFactory.initElements(getDriver(), this);
	}

    
	public void addToCart() throws InterruptedException {
		ActionClass.click(getDriver(), product);
	}
	
	public YourCartPageObject clickOnCart() throws InterruptedException {
		ActionClass.click(getDriver(), cart);
		return new YourCartPageObject();
	}
		
	public String verifyCartItem() {
		String exptext = ActionClass.getText(your_cart);
		return exptext;
		}

}
