package com.propertyfinder.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

	WebDriver driver;
	

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getResultCount() {

		return driver.findElement(By.xpath("//*[@id='serp-nav']/div[2]/div"));
	}


	public ItemPage clickOnResult(String number) {
		
		driver.findElement(By.xpath("//*[@id='serp']/ul/li["+number+"]"))
				.click();
		return new ItemPage(driver);
	}


	
}
