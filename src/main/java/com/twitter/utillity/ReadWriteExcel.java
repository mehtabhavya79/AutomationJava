package com.twitter.utillity;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel

{
	public static XSSFWorkbook workbookData;
	public static XSSFSheet sheet;

	public static void readFile() throws IOException {
		String excelFilepath = "src\\main\\resources\\loginData.xlsx";
		String sheetName = "Sheet1";
		FileInputStream fileinputstream = new FileInputStream(excelFilepath);
		workbookData = new XSSFWorkbook(fileinputstream);

		sheet = workbookData.getSheet(sheetName);

	}

}
