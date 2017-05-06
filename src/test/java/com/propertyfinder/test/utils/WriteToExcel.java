package com.propertyfinder.test.utils;

import java.io.File;
import java.io.FileOutputStream;

import jxl.Cell;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.Font;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class WriteToExcel {

	FileOutputStream exlFileName;
	Workbook existingWorkbook;
	WritableWorkbook exlWorkBook;
	WritableSheet exlWorkSheet1;
	WritableFont cellFont;
	WritableCellFormat cellFormat;

	public WriteToExcel() {

		// try {
		// //Creating an excel and naming it.
		// exlFileName= new
		// FileOutputStream("C://Users//ganukay.PRONTO//workspace//HubTest//data//Data_New_Results.xls");
		// //Creating an instance for the above excel.
		// exlWorkBook = Workbook.createWorkbook(exlFileName);
		// //Creating Writable work sheets for the above excel.
		// exlWorkSheet1 = exlWorkBook.createSheet("TestSheet1",0);
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	public WriteToExcel(File file, String methodName) {

		try {
			// Creating an excel and naming it.
			existingWorkbook = Workbook.getWorkbook(file);
			System.out.println(methodName);

			// Creating an instance for the above excel.
			exlWorkBook = Workbook.createWorkbook(new File(file.getParent()
					+ "//" + methodName + "_Results.xls"), existingWorkbook);
			// Creating Writable work sheets for the above excel.
			WritableSheet[] ws = exlWorkBook.getSheets();
			cellFont = new WritableFont(new WritableFont(
					WritableFont.createFont("Calibri"), 11));
			cellFormat = new WritableCellFormat(cellFont);

			for (int i = 0; i < ws.length; i++) {
				System.out.println(ws[i].getName());
				exlWorkSheet1 = exlWorkBook.getSheet(ws[i].getName());
			}
			// Creating Status Column
			setCellValue(exlWorkSheet1.getColumns(), 0, "Status");
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

	public void setCellValue(int c, int r, String value) {
		try {
			// Cell readCell = exlWorkSheet1.getCell(c, r);
			// CellFormat readFormat = readCell.getCellFormat() == null ?
			// cellFormat
			// : readCell.getCellFormat();
			// cellFormat = new WritableCellFormat(readFormat);

			WritableCellFormat newFormat = null;
			Cell readCell = exlWorkSheet1.getCell(c, r); // read format from
															// another cell(if
															// you want to copy
															// its existing
															// properties
															// otherwise you can
															// ignore).
			WritableCellFormat cellFormatObj = new WritableCellFormat(cellFont);
			CellFormat readFormat = readCell.getCellFormat() == null ? cellFormatObj
					: readCell.getCellFormat();
			newFormat = new WritableCellFormat(readFormat);

			if (value.equalsIgnoreCase("PASS")) {
				newFormat.setBackground(Colour.LIGHT_GREEN);
				Label l = new Label(c, r, value, newFormat);
				exlWorkSheet1.addCell(l);
			} else if (value.equalsIgnoreCase("FAIL")) {
				newFormat.setBackground(Colour.RED);
				Label l = new Label(c, r, value, newFormat);
				exlWorkSheet1.addCell(l);
			} else {
				newFormat.setBackground(Colour.GRAY_25);
				Label l = new Label(c, r, value, newFormat);
				exlWorkSheet1.addCell(l);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
