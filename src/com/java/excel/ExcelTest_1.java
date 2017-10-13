package com.java.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelTest_1 {
	
	final static int maxColumnNum = 15;
	final static int maxRowNum =4251;
	
	
	public static void main(String[] args) {
		
		try {
			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(new File("C:\\Users\\Administrator.USER-20160515JV\\Desktop\\hanzi.xls")));
			Sheet sheet = wb.getSheet("汉字部件拆分表");
			
			
			for(int startRowNum = 1; startRowNum < maxRowNum ; startRowNum ++){
				
				for (int startColumnNum = 1; startColumnNum < maxColumnNum; startColumnNum++) {
					
					HSSFCell cell = (HSSFCell) sheet.getRow(startRowNum).getCell(startColumnNum);
					String cellVlaue = cell.getStringCellValue();
					if(cellVlaue==""){
						System.out.print(1);
					}
					
					
					
					
				}
				System.out.println();
				
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
