package com.propertyfinder.test.dataobject;

import org.testng.annotations.DataProvider;

import com.propertyfinder.test.helper.ExcelToDataObject;

public class SearchPropertyData {

	public static String path;
	

	@DataProvider(name = "loginData" )
	public static Object[][] getLoginData() {
		return new ExcelToDataObject("data/TestCases/SearchProperty.xls").getDataObject();

	}

}
