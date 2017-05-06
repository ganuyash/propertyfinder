package com.propertyfinder.test.helper;

import org.testng.annotations.AfterClass;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import au.com.bytecode.opencsv.CSVWriter;

public class BackupTestCasePrevLoad {

	public static WebDriver driver;
	public static List<String[]> data;
	CSVWriter writer;

	@BeforeSuite
	public void beforesuite() {
		System.out
				.println("***********************Before Suit***************************");
		String csvFile = "test.csv";
		try {
			writer = new CSVWriter(new FileWriter(csvFile));
			data = new ArrayList<String[]>();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Before Method");

		// FirefoxProfile profile = new FirefoxProfile();
		// profile.setPreference("network.manage-offline-status", false);

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// driver.manage().window().;
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void AfterMethod() {
		System.out
				.println("********************After Method**************************************");

		driver.close();
		driver.quit();
	}

	@org.testng.annotations.AfterTest
	public void afterTest() {
		System.out
				.println("************************************************ End of the Test****************************************************");
		// ResultHandler.writeAndClose();
	}

	@AfterClass
	public void AfterClass() {
		System.out
				.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%----After Class----%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		ResultHandler.writeAndClose();
	}

	@AfterSuite
	public void AfterSuit() throws IOException {
		System.out
				.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%----After Suit----%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		writer.writeAll(data);

		writer.close();
	}
}
