package com.propertyfinder.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.propertyfinder.test.helper.PageWaitHandler;

public class LandingPage {

	private WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPage selectServiceType(String serviceType) {

		driver.findElement(
				By.xpath("//*[@id='search-form-property']/div[3]/div[2]/div/button"))
				.click();
		if (serviceType.equalsIgnoreCase("Rent")) {
			driver.findElement(
					By.xpath("//*[@id='search-form-property']/div[3]/div[2]/div/div/ul/li[1]"))
					.click();

		} else if (serviceType.equalsIgnoreCase("Buy")) {
			driver.findElement(
					By.xpath("//*[@id='search-form-property']/div[3]/div[2]/div/div/ul/li[2]"))
					.click();

		} else if (serviceType.equalsIgnoreCase("Commercial rent")) {
			driver.findElement(
					By.xpath("//*[@id='search-form-property']/div[3]/div[2]/div/div/ul/li[3]"))
					.click();

		} else if (serviceType.equalsIgnoreCase("Commercial buy")) {
			driver.findElement(
					By.xpath("//*[@id='search-form-property']/div[3]/div[2]/div/div/ul/li[4]"))
					.click();

		} else if (serviceType.equalsIgnoreCase("Agent")) {
			driver.findElement(
					By.xpath("//*//*[@id='search-form-property']/div[3]/div[2]/div/div/ul/li[5]"))
					.click();

		}
		return this;
	}

	public LandingPage enterCity(String city) {
		driver.findElement(By.xpath("//*[@id='search-form-property']/div[3]/div[1]/span/input"))
				.sendKeys(city);
		driver.findElement(
				By.xpath("//*[@id='search-form-property']/div[3]/div[1]/span/div/div/div[1]/strong"))
				.click();

		return this;
	}

	public LandingPage selectPropertyType(String propertyType) {

		driver.findElement(
				By.xpath("//*[@id='search-form-property']/div[4]/div/div[1]/div/button"))
				.click();
		
		if (propertyType.equalsIgnoreCase("Apartment")) {
			driver.findElement(
					By.xpath("//*[@id='search-form-property']/div[4]/div/div[1]/div/div/ul/li[2]"))
					.click();

		} else if (propertyType.equalsIgnoreCase("Villa")) {
			driver.findElement(
					By.xpath("//*[@id='search-form-property']/div[4]/div/div[1]/div/div/ul/li[3]"))
					.click();

		} else if (propertyType.equalsIgnoreCase("Townhouse")) {
			driver.findElement(
					By.xpath("//*[@id='search-form-property']/div[4]/div/div[1]/div/div/ul/li[4]"))
					.click();

		} else if (propertyType.equalsIgnoreCase("Penthouse")) {
			driver.findElement(
					By.xpath("//*[@id='search-form-property']/div[4]/div/div[1]/div/div/ul/li[5]"))
					.click();

		} else if (propertyType.equalsIgnoreCase("Compound")) {
			driver.findElement(
					By.xpath("//*[@id='search-form-property']/div[4]/div/div[1]/div/div/ul/li[6]"))
					.click();

		} else if (propertyType.equalsIgnoreCase("Duplex")) {
			driver.findElement(
					By.xpath("//*[@id='search-form-property']/div[4]/div/div[1]/div/div/ul/li[7]"))
					.click();

		} else if (propertyType.equalsIgnoreCase("Whole Building")) {
			driver.findElement(
					By.xpath("//*[@id='search-form-property']/div[4]/div/div[1]/div/div/ul/li[8]"))
					.click();

		}
		return this;
	}

	public LandingPage selectDuration(String duration) {


		driver.findElement(
				By.xpath("//*[@id='search-form-property']/div[4]/div/div[2]/div/button"))
				.click();
		
		if (duration.equalsIgnoreCase("Monthly")) {
			driver.findElement(
					By.xpath("//*[@id='search-form-property']/div[4]/div/div[2]/div/div/ul/li[1]"))
					.click();

		} else if (duration.equalsIgnoreCase("Weekly")) {
			driver.findElement(
					By.xpath("//*[@id='search-form-property']/div[4]/div/div[2]/div/div/ul/li[2]"))
					.click();

		}
		return this;
	}

	public LandingPage SelectMinPrice(String minPrice) throws InterruptedException {

		
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='price_group']/div[1]/select")));
		
//		driver.findElement(
//				By.xpath("//*[@id='price_group']/div[1]/div/button"))
//				.click();
//		PageWaitHandler.waitForAjax(30, driver);
		if (minPrice.equalsIgnoreCase("MinPrice")) {
//			driver.findElement(
//					By.xpath("//*[@id='price_group']/div[1]/div/div/ul/li[1]"))
//					.click();
			
			dropdown.selectByVisibleText("Min. price");
		}
		return this;
	}

	public LandingPage SelectMaxPrice(String maxPrice) {
		
		driver.findElement(
				By.xpath("//*[@id='price_group']/div[2]/div/button"))
				.click();
		Sleeper.sleepTightInSeconds(5);
//		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='price_group']/div[2]/select")));
		
//		PageWaitHandler.waitForAjax(30, driver);
		if (maxPrice.equalsIgnoreCase("NoPrice")) {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			PageWaitHandler.waitForAjax(30, driver);
			driver.findElement(
					By.xpath("//*[@id='price_group']/div[2]/div/div/ul/li[24]"))
					.click();
			
//			dropdown.selectByVisibleText("No max");
		}
		return this;
	}

	public LandingPage selectMinBedCount(String minBedCOunt) {
		
		driver.findElement(
				By.xpath("//*[@id='bedroom_group']/div[1]/div/button"))
				.click();
		
		if (minBedCOunt.equalsIgnoreCase("2")) {
			driver.findElement(
					By.xpath("//*[@id='bedroom_group']/div[1]/div/div/ul/li[4]"))
					.click();
		}

		return this;
	}

	public LandingPage selectMaxBedCount(String maxBedCOunt) {
		
		driver.findElement(
				By.xpath("//*[@id='bedroom_group']/div[2]/div/button"))
				.click();
		
		if (maxBedCOunt.equalsIgnoreCase("Max")) {
			driver.findElement(
					By.xpath("//*[@id='bedroom_group']/div[2]/div/div/ul/li[1]"))
					.click();
		}

		return this;
	}

	public LandingPage selectMinArea(String minArea) {
		
		driver.findElement(
				By.xpath("//*[@id='area_group']/div[1]/div/button"))
				.click();
		
		if (minArea.equalsIgnoreCase("Min")) {
			driver.findElement(
					By.xpath("//*[@id='area_group']/div[1]/div/div/ul/li[1]"))
					.click();
		}
		return this;

	}

	public LandingPage selectMaxArea(String maxArea) {
		
		driver.findElement(
				By.xpath("//*[@id='area_group']/div[2]/div/button"))
				.click();
		
		if (maxArea.equalsIgnoreCase("Max")) {
			driver.findElement(
					By.xpath("//*[@id='area_group']/div[2]/div/div/ul/li[1]"))
					.click();
		}
		return this;

	}

	public LandingPage slectFurnishType(String funishType) {

		
		driver.findElement(
				By.xpath("//*[@id='search-form-property']/div[4]/div/div[6]/div/button"))
				.click();
		
		if (funishType.equalsIgnoreCase("All")) {
			driver.findElement(
					By.xpath("//*[@id='search-form-property']/div[4]/div/div[6]/div/div/ul/li[1]"))
					.click();
		}

		return this;
	}

	public LandingPage enterKeyword(String keyword) {
		
		
		driver.findElement(By.xpath("//*[@id='container']/form/div[4]/input"))
				.sendKeys(keyword);
		return this;
	}

	public LandingPage clickReset() {
		driver.findElement(By.xpath("//*[@id='container']/form/div[4]/input"))
				.click();
		return this;
	}

	public SearchResultPage clickSearch() {
		driver.findElement(By.xpath("//*[@id='search-form-property']/div[3]/div[1]/button")).click();
//		return this;
		return new SearchResultPage(driver);
	}

}
