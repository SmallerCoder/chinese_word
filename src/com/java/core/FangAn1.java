package com.java.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FangAn1 {

	public static BufferedImage geneImage() throws IOException {

		BufferedImage bImage = ImageIO.read(new File("C:\\Users\\Administrator.USER-20160515JV\\Desktop\\1.jpg"));
		// BufferedImage bImage = new BufferedImage(540, 900,
		// BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D) bImage.getGraphics();
		//填满画布，为白色
		// g2d.setColor(Color.WHITE);
		// g2d.fillRect(0, 0,540, 900);
		//大字体部分
		Font font = new Font("宋体", Font.BOLD, 270);
		g2d.setFont(font);
		g2d.setColor(Color.BLACK);
		g2d.drawString("国", 130, 360);
		//拼音部分
		 Font font_1 = new Font("宋体", Font.BOLD, 60);
		 g2d.setFont(font_1);
		 g2d.drawString(PinyinUtil.getPinYin("国"), 220, 70);
		 //笔画部分
		 Font font_2 = new Font("宋体", Font.BOLD, 90);
		 g2d.setFont(font_2);
		 g2d.drawString("国", 45, 560);
		 g2d.drawString("囗", 165, 560);
		 g2d.drawString("玉", 285, 560);
		 g2d.drawString("王", 405, 560);
		 //底部序号部分
		 Font font_3 = new Font("宋体", Font.BOLD, 45);
		 g2d.setFont(font_3);
		 g2d.drawString("3884", 215, 880);
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
