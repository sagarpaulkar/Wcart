package com.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {

	public static Object[][] getTestDataFromExcel(String sheetName){
		DataFormatter df= new DataFormatter();
		File excelFile= new File(System.getProperty("user.dir")+"\\src\\main\\resources\\credentialsWcart.xlsx");
		XSSFWorkbook workbook=null;
		try {
			FileInputStream fisExcel= new FileInputStream(excelFile);
			workbook= new XSSFWorkbook(fisExcel);
		}catch (Throwable e)
		{
			e.printStackTrace();
		}
	
		XSSFSheet sheet= workbook.getSheet(sheetName);
		
		int rows= sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object [][] data= new Object [rows][cols];
		for(int i=0;i<rows;i++) {
			int col= sheet.getRow(i).getLastCellNum();
			for(int j=0;j<col;j++) {
				data[i][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
			}
			
		}
		return data;
	}
}
