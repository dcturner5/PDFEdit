package com.gammarush.main.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

import org.apache.pdfbox.rendering.PDFRenderer;

import com.gammarush.main.pdf.PDF;

public class PDFPreview extends JPanel {
	
	private static final long serialVersionUID = 8061753738253124997L;
	
	private PDF pdf;
	private PDFRenderer renderer;
	private BufferedImage image = null;
	
	public void load(PDF pdf) {
		this.pdf = pdf;
		renderer = new PDFRenderer(this.pdf.getDocument());
	}
	
	public void render(int pageIndex) throws IOException {
		setSize((int) pdf.getDocument().getPage(pageIndex).getMediaBox().getWidth(), (int) pdf.getDocument().getPage(pageIndex).getMediaBox().getHeight());
		image = renderer.renderImage(pageIndex);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image != null) g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
    }
	
}
