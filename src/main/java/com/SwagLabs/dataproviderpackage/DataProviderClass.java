/**
 * 
 */
package com.SwagLabs.dataproviderpackage;

import org.testng.annotations.DataProvider;

import com.SwagLabs.utilitypackage.ExcelLibraryClass;

/**
 * @author ravindrs
 *
 */
public class DataProviderClass {
	ExcelLibraryClass obj = new ExcelLibraryClass();
	
	@DataProvider(name ="Login") // Data provider name
	public Object[][] getCredentials(){
		int rows = obj.getRowCount("login");
		int column = obj.getColumnCount("login");
		int actRows=rows-1;
		
		Object[][] data = new Object[actRows][column];
		for (int i = 0; i< actRows; i++) {
			 for (int j = 0;j < column; j++) {
				 data[i][j] = obj.getCellData("login", j, i+2);
			 }
		}
		return data;
	}

}
