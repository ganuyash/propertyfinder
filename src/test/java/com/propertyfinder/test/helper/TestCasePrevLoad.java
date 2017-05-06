package com.propertyfinder.test.helper;

import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import au.com.bytecode.opencsv.CSVWriter;

public class TestCasePrevLoad {

	public static WebDriver driver;
	public String browser = "browser";
	public static List<String[]> data;
	CSVWriter writer;

	// public static String status;
	// public static String reject = "Empty";
	// public static String path;
	// public static int execCount = 1;
	// public static String executionMethod = "empty";

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

	// @BeforeClass
	// public void beforeClass(){
	// execCount = 1;
	// }
//	@Parameters("browser")
	@BeforeMethod
//	public void launchBrowser(String browser) {
		public void launchBrowser() {
		System.out.println("Before Method");

		if (browser.equals("FF")) {
			this.browser = "FireFox";
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			// driver.manage().window().;
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} else if (browser.equals("Chrome")) {
			this.browser = "Chrome";
			System.setProperty("webdriver.chrome.driver",
					"lib/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} else if (browser.equals("IE")) {
			this.browser = "IE";
			System.setProperty("webdriver.ie.driver",
					"lib/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} else {
			//this.browser = "FireFox";
			//driver = new FirefoxDriver();
			//driver.manage().window().maximize();
			// driver.manage().window().;//
			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			this.browser = "Chrome";
			System.setProperty("webdriver.chrome.driver",
					"lib/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		}

		// driver = new FirefoxDriver();
		// driver.manage().window().maximize();
		// // driver.manage().window().;
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

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

//		ResultHandler.writeAndClose();
	}

	@AfterSuite
	public void AfterSuit() throws IOException {
		System.out
				.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%----After Suit----%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		writer.writeAll(data);

		writer.close();
	}
}
