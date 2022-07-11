/**
 * 
 */
package com.SwagLabs.utilitypackage;

import java.io.IOException;

import com.SwagLabs.basepackage.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.SwagLabs.actionpackage.*;

/**
 * @author ravindrs
 * This class contains all methods required for extent report generation
 *
 */
public class ExtentManagerClass extends BaseClass {
	
	public static ExtentSparkReporter htmlReporter; // latest change ExtentSparkReporter 
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() throws IOException {
		//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
		
		htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+ActionClass.getCurrentTime()+"html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config_SwagLabs.xml");
		//htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("SWAG Labs Test Automation Report");
		htmlReporter.config().setTheme(Theme.DARK); 
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "SWAGLab_Project");
		extent.setSystemInfo("Tester", "Sourab");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	
	public static void endReport() {
		extent.flush();
	}

}
