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
 * This class hold all the elements on the login page
 *
 */
public class LoginPageObject extends BaseClass {
	
	@FindBy (xpath="//*[@id=\"user-name\"]") WebElement username;
	@FindBy (xpath="//*[@id=\"password\"]") WebElement password;
	@FindBy (xpath="//*[@id=\"login-button\"]") WebElement loginbtn;
	@FindBy (xpath="//*[@id=\"header_container\"]/div[2]/span") WebElement product;
	
	public LoginPageObject() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ProductPageObject loginSwagLabs(String uname, String pass) throws InterruptedException {
		
		System.out.println("we are in login page");
		ActionClass.type(username, uname);
		ActionClass.type(password, pass);
		ActionClass.click(getDriver(),loginbtn);
		
		return new ProductPageObject();
	}
	
	public String verifyLogin() {
		String actString=ActionClass.getText(product);
		return actString;
		
	}


}
