package com.propertyfinder.test.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageWaitHandler {

	public static void waitTillVisible(String xPath, WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 20);
		System.out.println("Wait Till " + xPath);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(xPath)));

	}

	public static void waitTillPresent(String xPath, WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 20);
		System.out.println("Wait Till " + xPath);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(xPath)));

	}

	public static void waitForAjax(int timeoutInSeconds, WebDriver driver)  {
//		  System.out.println("Checking active ajax calls by calling jquery.active");
		  System.out.println("Checking active ajax calls by calling window.$.active");
		    try {
		      if (driver instanceof JavascriptExecutor) {
			JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
				
		        for (int i = 0; i< timeoutInSeconds; i++) 
		        {
		        	Thread.sleep(2000);
//			    Object numberOfAjaxConnections = jsDriver.executeScript("return jQuery.active");
			    Object numberOfAjaxConnections = jsDriver.executeScript("return window.$.active");
			    // return should be a number
			    if (numberOfAjaxConnections instanceof Long) {
			        Long n = (Long)numberOfAjaxConnections;
			        System.out.println("Number of active jquery ajax calls: " + n);
			        if (n.longValue() == 0L)
			        	break;
			        }
		            Thread.sleep(1000);
			    }
			}
			else {
				System.out.println("Web driver: " + driver + " cannot execute javascript");
			}
		}
			catch (InterruptedException e) {
				System.out.println("Before getting jQuery undefined error.");
				e.printStackTrace();
			}
		}
	
	
//	public static boolean waitForJQueryProcessing(int timeOutInSeconds) {
//	    boolean jQcondition = false;
//	    try {
//	        new WebDriverWait(driver, timeOutInSeconds) {
//	        }.until(new ExpectedCondition<Boolean>() {
//
//	            @Override
//	            public Boolean apply(WebDriver driverObject) {
//	                return (Boolean) ((JavascriptExecutor) driverObject)
//	                        .executeScript("return jQuery.active == 0");
//	            }
//	        });
//	        jQcondition = (Boolean) ((JavascriptExecutor) driver).executeScript("return window.jQuery != undefined && jQuery.active === 0");
//	        return jQcondition;
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return jQcondition;
//	}
	
}
