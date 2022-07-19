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
public class CheckOutOverviewPageObject extends BaseClass{
	@FindBy (xpath ="//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div") WebElement totalPrice1;
	@FindBy (xpath ="//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]") WebElement finalPrice;
	@FindBy (xpath ="//*[@id=\"finish\"]") WebElement finishBtn;
	@FindBy (xpath ="//*[@id=\"header_container\"]/div[2]/span") WebElement completePage;
	
	public CheckOutOverviewPageObject() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double verifyPrice() {
		String price1 = ActionClass.getText(totalPrice1);
		String price2 = ActionClass.getText(finalPrice);

		Pattern p = Pattern.compile("[^0-9]*([0-9]*,?([0-9]+(\\.[0-9]*))?)");
		java.util.regex.Matcher m = p.matcher(price1);
		m.matches();
		String price1_without_$ = m.group(1).replace(",", "");
		double d_price1 = Double.valueOf(price1_without_$);
		double tax = 2.40;
		double multi_price = d_price1 + tax;
		
		//System.out.println("expected price from page"+multi_price);
		return multi_price;
		
		
	}
	
	public double getActualFinalPrice() {
		String price2 = ActionClass.getText(finalPrice);
		String price2_without_extra = price2.substring(8, 13);
		double d_price2 = Double.valueOf(price2_without_extra);
		//System.out.println("Actual price from page"+d_price2);
		return d_price2;
	}
	
	public void clickOnFinish() {
		ActionClass.click(getDriver(), finishBtn);
	}
	
	public String verifyCompletionPage() {
		String actText = ActionClass.getText(completePage);
		return actText;
	}
	
	
}
