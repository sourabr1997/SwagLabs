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
public class YourCartPageObject extends BaseClass {
	
@FindBy (xpath ="//*[@id=\"checkout\"]")WebElement checkoutbtn;
@FindBy (xpath ="//*[@id=\"header_container\"]/div[2]/span")WebElement checkoutpge;


	
	public YourCartPageObject() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnCheckOut() throws InterruptedException {
		ActionClass.click(getDriver(), checkoutbtn);
		Thread.sleep(5000);
		//return new CheckOutInfoPage();
	}
	
	public String verifyChechOutPage() {
		String exptext = ActionClass.getText(checkoutpge);
		return exptext;
		}
	

}
