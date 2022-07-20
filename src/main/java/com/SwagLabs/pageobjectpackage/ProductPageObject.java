/**
 * 
 */
package com.SwagLabs.pageobjectpackage;

import java.util.regex.Pattern;

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
	
	@FindBy (xpath ="//*[@id=\"header_container\"]/div[2]/div[2]/span/select")WebElement sortDropDown;
	@FindBy (xpath ="//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")WebElement topProduct;
	@FindBy (xpath ="//*[@id=\"inventory_container\"]/div/div[6]/div[2]/div[2]/div")WebElement bottomProduct;
	
	
	
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
	
	
	
	public void selectDropDownOption(String input) throws InterruptedException {
		if (input.equalsIgnoreCase("Ascending")) {
			ActionClass.selectByVisibleText("Price (low to high)", sortDropDown);
			Thread.sleep(5000);
			
		}
		else if (input.equalsIgnoreCase("Descending")) {
			ActionClass.selectByVisibleText("Price (high to low)", sortDropDown);
			Thread.sleep(5000);
		}
		
	}
	
	public double bottomProductValue() throws InterruptedException {
		String bottomPriceWith$ = ActionClass.getText(bottomProduct);
		Pattern p = Pattern.compile("[^0-9]*([0-9]*,?([0-9]+(\\.[0-9]*))?)");
		java.util.regex.Matcher m = p.matcher(bottomPriceWith$);
		m.matches();
		String bottomPrice_without_$ = m.group(1).replace(",", "");
		double d_bottomPrice = Double.valueOf(bottomPrice_without_$);
		System.out.println(d_bottomPrice);
		
		return d_bottomPrice;
	}
	
	public double topProductValue() {
		String topPriceWith$ = ActionClass.getText(topProduct);
		Pattern p = Pattern.compile("[^0-9]*([0-9]*,?([0-9]+(\\.[0-9]*))?)");
		java.util.regex.Matcher m = p.matcher(topPriceWith$);
		m.matches();
		String topPrice_without_$ = m.group(1).replace(",", "");
		double d_topPrice = Double.valueOf(topPrice_without_$);
		System.out.println(d_topPrice);
		
		return d_topPrice;
	}

}
