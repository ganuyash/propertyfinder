package com.propertyfinder.test.helper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HtmlTableHandler {

	public static List<List<String>> getTableRows(WebDriver driver) {
		int i = 0;
		List<List<String>> rowsCollection = new ArrayList<List<String>>();

		WebElement simpleTable = driver.findElement(By.id("results"));

		List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
		System.out.println("IN C Before FOR");
		// Print data from each row
		for (WebElement row : rows) {

			ArrayList<String> rowData = new ArrayList<String>();
			System.out.println("Before getting TD's");
			if (i > 0) {
				List<WebElement> cols = row.findElements(By.tagName("td"));
				System.out.println("After getting TD's");
				for (WebElement col : cols) {
					if (!col.getText().equals("")) {
						rowData.add(col.getText());
						System.out.print(col.getText() + "|");
					}
				}
				if (!rowData.isEmpty()) {
					rowsCollection.add(rowData);
					System.out.println();
				}
			}
			i++;
		}
		System.out.println("IN End Of FOR");
		return rowsCollection;
	}

	public static String getTableRowCount(WebDriver driver) {
		WebElement simpleTable = driver.findElement(By.id("results"));
		List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
		return String.valueOf((rows.size() - 1));
	}

	public static String getTableRowCount(WebDriver driver, String tableID) {
		WebElement simpleTable = driver.findElement(By.id(tableID));
		List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
		return String.valueOf((rows.size() - 1));
	}

	public static WebElement getRowElementByColumnValue(WebDriver driver,
			String columnValue, int columnIndex) {
		WebElement searchedRow = null;

		// Print data from each row

		WebElement holder = driver.findElement(By.className("holder"));
		List<WebElement> anchorTags = holder.findElements(By.tagName("a"));

		outerloop: for (int j = 0; j < anchorTags.size() - 1; j++) {
			int pages = (anchorTags.size() - 2);

			if (pages > 1 && (anchorTags.size() - 1) > (j + 2)) {
				anchorTags.get(j + 2).click();
				PageWaitHandler.waitForAjax(30, driver);

				int i = 0;
				WebElement simpleTable = driver.findElement(By.id("results"));

				List<WebElement> rows = simpleTable.findElements(By
						.tagName("tr"));
				for (WebElement row : rows) {

					if (i > 0) {
						List<WebElement> cols = row.findElements(By
								.tagName("td"));
//						System.out.println(cols.get(columnIndex).getText());
						if (cols.get(columnIndex).getText().equals(columnValue)) {
							searchedRow = row;
							System.out.println("Found***************************************");
							break outerloop;
						}
					}
					i++;
				}
			}
		}

		return searchedRow;

	}

}
