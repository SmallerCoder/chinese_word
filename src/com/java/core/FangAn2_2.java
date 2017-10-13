package com.java.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FangAn2_2 {

	public static BufferedImage geneImage() throws IOException {

		BufferedImage bImage = ImageIO.read(new File("C:\\Users\\Administrator.USER-20160515JV\\Desktop\\1.jpg"));
		Graphics2D g2d = (Graphics2D) bImage.getGraphics();
	
		Font font = new Font("宋体", Font.BOLD, 370);
		g2d.setFont(font);
		g2d.setColor(Color.BLACK);
		g2d.drawString("总", 78, 405);

		Font font_3 = new Font("宋体", Font.BOLD, 35);
		 g2d.setFont(font_3);
		 g2d.drawString("5", 495, 75);//435,,,492
		
		 Font font_1 = new Font("宋体", Font.BOLD,35);
		 g2d.setFont(font_1);
		 g2d.drawString(PinyinUtil.getPinYin("总"), 30, 75);
		 Font font_2 = new Font("宋体", Font.BOLD, 90);
		 g2d.setFont(font_2);
		 g2d.drawString("总", 42, 583);
		 g2d.drawString("丷", 162, 583);
		 g2d.drawString("口", 282, 583);
		 g2d.drawString("心", 402, 583);
		return bImage;
	}

	public static void main(String[] args) {

		try {
			ImageIO.write(geneImage(), "jpg", new File("C:\\Users\\Administrator.USER-20160515JV\\Desktop\\3.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
