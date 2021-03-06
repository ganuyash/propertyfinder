package com.propertyfinder.test.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

public class FileOperations {

	static SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH-mm-ss ");

	public static void copyFileUsingApacheCommonsIO(File source, File dest)
			throws IOException {

		if (!dest.exists()) {
			FileUtils.copyFile(source, dest);
		}

	}

	public static void captureScreenshot(String methodName, WebDriver driver,
			String failedTestID) {
		try {
			String destDir = "screens/" + methodName;
			if (!new File(destDir).exists()) {
				new File(destDir).mkdirs();
			}

			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			// the screenshots can be moved to a folder for sorting
			FileUtils.copyFile(scrFile, new File(destDir + "/" + "TC_"+ failedTestID
					+ "_failed_" + sdf.format(new Date()) + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
//			e.getMessage();
		}
	}

	// public static void main(String[] args) {
	// try {
	// sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
	// System.out.println(sdf.format(new Date()));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}
