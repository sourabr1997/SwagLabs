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
public class CheckoutPageObject extends BaseClass{
	
	@FindBy (xpath ="//*[@id=\"first-name\"]") WebElement FirstName;
	@FindBy (xpath ="//*[@id=\"last-name\"]") WebElement LasttName;
	@FindBy (xpath ="//*[@id=\"postal-code\"]") WebElement ZipCode;
	@FindBy (xpath ="//*[@id=\"continue\"]") WebElement ContinueBtn;
	@FindBy (xpath ="//*[@id=\"header_container\"]/div[2]/span") WebElement checkOutOverview;
	
	
	
	
	public CheckoutPageObject() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public CheckOutOverviewPageObject addInfo(String firstname, String lastname, String zipcode) throws InterruptedException {
		ActionClass.type(FirstName, firstname);
		ActionClass.type(LasttName, lastname);
		ActionClass.type(ZipCode, zipcode);
		ActionClass.click(getDriver(), ContinueBtn);
		
		Thread.sleep(5000);
		return new CheckOutOverviewPageObject();
		
	}
	
	public String verifyOverview() {
		String expText = ActionClass.getText(checkOutOverview);
		return expText;
		}

}
