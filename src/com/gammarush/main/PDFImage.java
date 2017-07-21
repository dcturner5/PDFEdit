package com.gammarush.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class PDFImage {
	
	private BufferedImage image;
	private int width;
	private int height;
	
	private Graphics2D graphics2D;
	private Font font;
	
	public PDFImage(BufferedImage image) {
		this.image = image;
		this.width = image.getWidth();
		this.height = image.getHeight();
		
		 graphics2D = this.image.createGraphics();
	     graphics2D.drawImage(this.image, 0, 0, this.width, this.height, null);
	     graphics2D.setPaint(Color.BLACK);
	     
	     font = new Font("Arial",  Font.PLAIN, 12);
	     graphics2D.setFont(font);
	}
	
	public void drawString(String string, int x, int y) {
		graphics2D.drawString(string, x, y);
	}
	
	public void setFontColor(Color color) {
		graphics2D.setPaint(color);
	}
	
	public void setFontSize(int size) {
		font = new Font(font.getFamily(), font.getStyle(), size);
		graphics2D.setFont(font);
	}
	
	public BufferedImage getBufferedImage() {
		return image;
	}

}
