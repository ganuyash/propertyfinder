package com.propertyfinder.test.execution;

import java.io.File;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.propertyfinder.test.dataobject.LoginData;
import com.propertyfinder.test.helper.ResultHandler;
import com.propertyfinder.test.helper.TestCasePrevLoad;
import com.propertyfinder.test.pageobject.ItemPage;
import com.propertyfinder.test.pageobject.LandingPage;
import com.propertyfinder.test.pageobject.SearchResultPage;

public class LoginExecution extends TestCasePrevLoad {

	int execuionCount = 1;// Value set to 1, skip the headers
	String status;
	String reject = "Empty";
	String path = "data/TestCases/UserlevelCheck.xls";

	@Test(dataProvider = "loginData", dataProviderClass = LoginData.class)
	public void LoginExecute(String serviceType, String city,
			String propertyType, String duration, String minPrice,
			String maxPrice, String minBedCount, String maxBedCount,
			String minArea, String maxArea, String furnishType, String keyword,
			String resultCount, String clickOnItem, String resultedBedCount,
			String resultedReference) throws InterruptedException {

		try {

			driver.get("https://www.propertyfinder.qa");
			LandingPage landing = new LandingPage(driver);
			SearchResultPage sr = landing.selectServiceType(serviceType)
					.enterCity(city).selectPropertyType(propertyType)
					.selectDuration(duration).SelectMinPrice(minPrice)
					.selectMinBedCount(minBedCount)
					.selectMaxBedCount(maxBedCount).selectMinArea(minArea)
					.selectMaxArea(maxArea).slectFurnishType(furnishType)
					.clickSearch();

			// Asserting the Result Count,actual result derived from the excel file
			Assert.assertEquals(resultCount, sr.getResultCount().getText());

			// Navigatng to second result(last result), user selected item pass through data excel
			ItemPage item = sr.clickOnResult(clickOnItem);

			// Asserting the Bed count of selected Item, actual result derived from the excel file
			Assert.assertEquals(resultedBedCount, item.getBedCount().getText());
			// Asserting the reference number of selected Item, actual result derived from the excel file
			Assert.assertEquals(resultedReference, item.getReference().getText());

		} catch (AssertionError e) {
			// if above steps failed Status should be set to fail
			// e.printStackTrace();
			// System.out.println("AssertionError");
			// status = KeywordHandler.testFail;
			// reject = e.getMessage();
			// FileOperations.captureScreenshot(
			// new Exception().getStackTrace()[0].getMethodName(), driver,
			// userName);
			// System.out.print(e.printStackTrace());
			throw e;
		} catch (Exception e) {
			// if above steps failed Status should be set to fail
			// e.printStackTrace();
			// status = KeywordHandler.testFail;
			// reject = e.getMessage();
			// FileOperations.captureScreenshot(
			// new Exception().getStackTrace()[0].getMethodName(), driver,
			// userName);
			//
			// System.out.print(e.printStackTrace());
			throw e;
		} finally {
//			ResultHandler.writeStatus(new File(path),
//					new Exception().getStackTrace()[0].getMethodName(),
//					execuionCount, status, reject);
			execuionCount++;
		}
	}

}
