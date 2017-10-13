package com.java.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FangAn2_1 {

	public static BufferedImage geneImage() throws IOException {

		BufferedImage bImage = ImageIO.read(new File("C:\\Users\\Administrator.USER-20160515JV\\Desktop\\1.jpg"));
		Graphics2D g2d = (Graphics2D) bImage.getGraphics();
		//大字体部分
		Font font = new Font("宋体", Font.BOLD, 400);
		g2d.setFont(font);
		g2d.setColor(Color.BLACK);
		g2d.drawString("国", 55, 410);
		//序号部分
		Font font_3 = new Font("宋体", Font.BOLD, 35);
		 g2d.setFont(font_3);
		 g2d.drawString("3884", 20, 47);
		//拼音部分
		 Font font_1 = new Font("宋体", Font.BOLD,45);
		 g2d.setFont(font_1);
		 g2d.drawString(PinyinUtil.getPinYin("国"), 450, 47);
		 //笔画部分
		 Font font_2 = new Font("宋体", Font.BOLD, 90);
		 g2d.setFont(font_2);
		 g2d.drawString("国", 20, 600);
		 g2d.drawString("囗", 155, 600);
		 g2d.drawString("玉", 295, 600);
		 g2d.drawString("王", 435, 600);
		return bImage;
	}

	public static void main(String[] args) {

		try {
			ImageIO.write(geneImage(), "jpg", new File("C:\\Users\\Administrator.USER-20160515JV\\Desktop\\3.jpg"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
