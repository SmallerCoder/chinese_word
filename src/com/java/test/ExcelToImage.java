package com.java.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

import com.java.core.PinyinUtil;
public class ExcelToImage {
	
	final static int maxColumnNum = 15;
	final static int maxRowNum =4243;
	
	//部件坐标哈希表
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		
				try {
					HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(new File("C:\\Users\\Administrator.USER-20160515JV\\Desktop\\hanzi_!.xls")));
					Sheet sheet = wb.getSheet("汉字部件拆分表");
					
					Font font_3 = new Font("宋体", Font.BOLD, 35);
					Font font_1 = new Font("宋体", Font.BOLD,45);
					Font font = new Font("宋体", Font.BOLD, 370);
					Font font_2 = new Font("宋体", Font.BOLD, 90);

					//初始化坐标
					list.add(42);
					list.add(162);
					list.add(282);
					list.add(402);
					
					for(int startRowNum = 1; startRowNum < maxRowNum ; startRowNum ++){
						
						BufferedImage bImage = ImageIO.read(new File("./image/1.jpg"));

						Graphics2D g2d = (Graphics2D) bImage.getGraphics();
						g2d.setColor(Color.BLACK);
						
						//获取每行第一个单元格，序号
						HSSFCell cell_0 = (HSSFCell) sheet.getRow(startRowNum).getCell(0);
						g2d.setFont(font_3);
						g2d.drawString(String.valueOf((int)cell_0.getNumericCellValue()), 30, 75);
						
						//获取每行第2个单元格,拼音
						HSSFCell cell_1 = (HSSFCell) sheet.getRow(startRowNum).getCell(1);
						g2d.setFont(font_1);
						g2d.drawString(PinyinUtil.getPinYin(cell_1.getStringCellValue()), 410, 75);
						 
						//汉字
						g2d.setFont(font);
						g2d.drawString(cell_1.getStringCellValue(), 78, 405);
						g2d.setFont(font_2);
						for (int startColumnNum = 2; startColumnNum < maxColumnNum; startColumnNum++) {
							//遍历每一个部件
							HSSFCell cell = (HSSFCell) sheet.getRow(startRowNum).getCell(startColumnNum);
							if(cell==null){
								System.out.println(1);
								break;
							}
							String cellVlaue = cell.getStringCellValue();
							System.out.print(cellVlaue);
							
							if(cellVlaue!=""){
								if((startColumnNum-1)<=4){
								g2d.drawString(cellVlaue,list.get(startColumnNum-2),583);
								}else if((startColumnNum-1)<=8){
								g2d.drawString(cellVlaue, list.get(startColumnNum-6),705);
								}else if((startColumnNum-1)<=12){
								g2d.drawString(cellVlaue,list.get(startColumnNum-10), 827);
								}
							}else{
								ImageIO.write(bImage, "jpg", new File("C:\\Users\\Administrator.USER-20160515JV\\Desktop\\kapai_1\\"+ ((int)cell_0.getNumericCellValue()-1) + ".jpg"));
								break;
							}
						}
						wb.close();
					}
				
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
}
