package com.propertyfinder.test.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {

	WebDriver driver;
	

	public ItemPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBedCount() {

		return driver.findElement(By.xpath("//*[@id='property-facts']/table/tbody/tr[4]/td"));
	}

	public WebElement getReference() {

		return driver.findElement(By.xpath("//*[@id='property-facts']/table/tbody/tr[3]/td"));
	}

	
}
