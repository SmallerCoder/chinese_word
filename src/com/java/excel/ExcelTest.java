package com.java.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

public class ExcelTest {

	public static void main(String[] args) throws IOException {
//		C:\\Users\\Administrator.USER-20160515JV\\Desktop\\3.jpg
		Workbook wb = new HSSFWorkbook();
		Sheet sheet1 =  wb.createSheet("new Sheet");
		Sheet sheet2 =  wb.createSheet("second sheet");
		CreationHelper c = wb.getCreationHelper();
		try {
			Row row = sheet1.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue("Hello");
			row.createCell(1).setCellValue(1.2);
			row.createCell(2).setCellValue(c.createRichTextString("My name is HJW"));
			row.createCell(3).setCellValue(true);
			
			CellStyle cs = wb.createCellStyle();
			cs.setDataFormat(c.createDataFormat().getFormat("m/d/yy h:mm"));
			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(cs);
			cell4.setCellValue(new Date());
			
			
			
			 	Row row1 = sheet1.createRow((short)1);
			 	row1.setRowStyle(cs);
			    row1.createCell(0).setCellValue(1.1);
			    row1.createCell(1).setCellValue(new Date());
			    row1.createCell(2).setCellValue(Calendar.getInstance());
			    row1.createCell(3).setCellValue("a string");
			    row1.createCell(4).setCellValue(true);
			    row1.createCell(5).setCellType(CellType.ERROR);
			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Administrator.USER-20160515JV\\Desktop\\helloworld.xls");
			wb.write(fileOut);
			wb.close();
			
			DataFormatter formatter = new DataFormatter();
			for(Row row_1 : sheet1){
				for(Cell cell_1 : row_1){
					CellReference cellRef = new CellReference(row.getRowNum(), cell_1.getColumnIndex());
					String text = formatter.formatCellValue(cell_1);
		            System.out.println(text);
					System.out.println(cellRef.formatAsString());
					switch (cell_1.getCellTypeEnum()) {
	                case STRING:
	                    System.out.println(cell_1.getRichStringCellValue().getString());
	                    break;
	                case NUMERIC:
	                    if (DateUtil.isCellDateFormatted(cell_1)) {
	                        System.out.println(cell_1.getDateCellValue());
	                    } else {
	                        System.out.println(cell_1.getNumericCellValue());
	                    }
	                    break;
	                case BOOLEAN:
	                    System.out.println(cell_1.getBooleanCellValue());
	                    break;
	                case FORMULA:
	                    System.out.println(cell_1.getCellFormula());
	                    break;
	                case BLANK:
	                    System.out.println();
	                    break;
	                default:
	                    System.out.println();
	            }
				}
				
			}
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
