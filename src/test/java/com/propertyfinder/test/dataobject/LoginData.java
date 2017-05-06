package com.propertyfinder.test.dataobject;

import org.testng.annotations.DataProvider;

import com.propertyfinder.test.helper.ExcelToDataObject;

public class LoginData {

	public static String path;
	

	@DataProvider(name = "loginData" )
	public static Object[][] getLoginData() {
//		return new Object[][] { { "UserName1", "Pass1" },
//				{ "UserName2", "Pass2" } }; UserlevelCheck.xls
//		return data;
		return new ExcelToDataObject("data/TestCases/UserlevelCheck.xls").getDataObject();

	}

}
