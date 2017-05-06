package com.propertyfinder.test.utils;

import java.io.File;
import java.io.FileOutputStream;

import jxl.Cell;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelResultWriter {

	FileOutputStream exlFileName;
	Workbook existingWorkbook;
	WritableWorkbook exlWorkBook;
	WritableSheet exlWorkSheet1;
	WritableFont cellFont;
	WritableCellFormat cellFormat;
	int columNumber;

	public ExcelResultWriter(File file, String methodName) {

		System.out.println("Constructor Building");

		try {
			// Creating an excel and naming it.
			existingWorkbook = Workbook.getWorkbook(file);
			// System.out.println(methodName);

			// Creating an instance for the above excel.
			// exlWorkBook = Workbook.createWorkbook(new File(file.getParent()
			// + "//" + methodName + "_Results.xls"), existingWorkbook);
			exlWorkBook = Workbook.createWorkbook(new File(file.getParent()
					+ "//TestResults" + "//" + methodName + "_Results.xls"),
					existingWorkbook);
			// Creating Writable work sheets for the above excel.
			WritableSheet[] ws = exlWorkBook.getSheets();
			cellFont = new WritableFont(new WritableFont(
					WritableFont.createFont("Calibri"), 11));
			cellFormat = new WritableCellFormat(cellFont);

			for (int i = 0; i < ws.length; i++) {
				// System.out.println(ws[i].getName());
				if (ws[i].getName().equalsIgnoreCase("TestData")) {
					exlWorkSheet1 = exlWorkBook.getSheet(ws[i].getName());
				}
			}
			// Creating Status Column
			columNumber = exlWorkSheet1.getColumns();
			setCellValue(0, "Status", "Empty");
			// Creating Reject Reason Column
			setCellValue(0, "Reject Reason", "Empty");
			System.out.println(columNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void write() throws Exception {
		// Writing the values into excel.
		exlWorkBook.write();
		// Close the workbook
		exlWorkBook.close();
	}

	public void setColumnDictionary(String[] columNames)
			throws RowsExceededException, WriteException {
		Label l;
		for (int i = 0; i < columNames.length; i++) {
			l = new Label(i, 0, columNames[i]);
			exlWorkSheet1.addCell(l);
		}
	}

	public void setCellValue(int r, String value, String reject) {

		try {

			WritableCellFormat newFormat = null;

			Cell readCell = exlWorkSheet1.getCell(columNumber, r);

			WritableCellFormat cellFormatObj = new WritableCellFormat(cellFont);
			CellFormat readFormat = readCell.getCellFormat() == null ? cellFormatObj
					: readCell.getCellFormat();
			newFormat = new WritableCellFormat(readFormat);
			// This is for Reject Reason
			WritableCellFormat newFormatReject = null;
			Cell readCellReject = exlWorkSheet1.getCell(columNumber + 1, r);
			CellFormat readFormatReject = readCellReject.getCellFormat() == null ? cellFormatObj
					: readCellReject.getCellFormat();
			newFormatReject = new WritableCellFormat(readFormatReject);

			System.out.println(value);
			if (value.equalsIgnoreCase("PASS")) {
				newFormat.setBackground(Colour.LIGHT_GREEN);
				Label l = new Label(columNumber, r, value, newFormat);
				exlWorkSheet1.addCell(l);
			} else if (value.equalsIgnoreCase("FAIL")) {
				newFormat.setBackground(Colour.RED);
				Label l = new Label(columNumber, r, value, newFormat);
				exlWorkSheet1.addCell(l);

				// setting Reject Reason
				newFormatReject.setBackground(Colour.RED);
				Label l2 = new Label(columNumber + 1, r, reject,
						newFormatReject);
				exlWorkSheet1.addCell(l2);
			} else if (value.equalsIgnoreCase("Status")) {
				newFormat.setBackground(Colour.GRAY_25);
				Label l = new Label(columNumber, r, value, newFormat);
				exlWorkSheet1.addCell(l);
				System.out.println(columNumber + "  " + r + " " + value);
			} else if (value.equalsIgnoreCase("Reject Reason")) {
				newFormatReject.setBackground(Colour.GRAY_25);
				Label l = new Label(columNumber + 1, r, value, newFormatReject);
				exlWorkSheet1.addCell(l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
