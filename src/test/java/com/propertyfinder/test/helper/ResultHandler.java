package com.propertyfinder.test.helper;

import java.io.File;

import com.propertyfinder.test.utils.ExcelResultWriter;

public class ResultHandler {

	static ExcelResultWriter erw;
	static String mName = "empty";
	public static void writeStatus(File file, String methodName, int r,
			String value, String reject) {
		try {
			if (erw == null) {
				erw = new ExcelResultWriter(file, methodName);
				erw.setCellValue(r, value, reject);
			} else {
				if (mName.equalsIgnoreCase(methodName)) {
					erw.setCellValue(r, value, reject);
				} else {
					erw = new ExcelResultWriter(file, methodName);
					erw.setCellValue(r, value, reject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// mStatus = "In";
		mName = methodName;
	}

	public static void writeAndClose() {
		try {
			erw.write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
