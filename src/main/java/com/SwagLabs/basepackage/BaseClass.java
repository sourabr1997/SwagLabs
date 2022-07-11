/**
 * 
 */
package com.SwagLabs.basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.SwagLabs.actionpackage.ActionClass;
import com.SwagLabs.utilitypackage.ExtentManagerClass;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author ravindrs 
 * This class contains Webdriver used details and beforeSuite and AfterSuite methods
 *         
 *
 */
public class BaseClass {
	public static Properties prop;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() throws IOException {
		ExtentManagerClass.setExtent();
		DOMConfigurator.configure("log4j.xml");

		
		prop = new Properties(); 
		//System.out.println("Super constructor invoked");
		 try { 
			 FileInputStream input = new FileInputStream(System.getProperty("user.dir")+("\\ConfigurationFile\\Configuration.properties")); 
			 prop.load(input);
		     System.out.println("driver: "+getDriver());
		  
		 } catch (FileNotFoundException e) { // TODO Auto-generated catch block
		 e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		 
	}

	public static void launchApp(String browserName) {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.iedriver().setup();
		// String browserName = prop.getProperty("browser");

		if (browserName.contains("Chrome")) {
			// driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		} else if (browserName.contains("FireFox")) {
			// driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (browserName.contains("IE")) {
			// driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}

		ActionClass.implicitWait(getDriver(), 20);
		ActionClass.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));

	}

	@AfterSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void afterSuite1() throws IOException {
		ExtentManagerClass.endReport();
	}

}
