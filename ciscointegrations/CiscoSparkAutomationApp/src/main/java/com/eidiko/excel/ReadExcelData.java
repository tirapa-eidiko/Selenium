package com.eidiko.excel;

import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("resource")
public class ReadExcelData {
	
	final static Logger logs = Logger.getLogger(ReadExcelData.class);
	
	String sheetPath;
	XSSFSheet xssFSheet;
	
	public ReadExcelData(String sheetPath){
		this.sheetPath = sheetPath;
		try {
			xssFSheet = getExcelSheet();
		} catch (Exception e) {
			logs.info(e.getMessage());
		}
	}
	public XSSFSheet getExcelSheet() throws Exception {
		return new XSSFWorkbook(new FileInputStream(sheetPath)).getSheetAt(0);
	}
	
	public String getData(int row, int column){
		xssFSheet.getSheetName();
		return xssFSheet.getRow(row).getCell(column).toString();
	}
}
