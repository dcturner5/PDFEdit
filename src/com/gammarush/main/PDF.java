package com.gammarush.main;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDF {
	
	private PDDocument document;
	
	private PDFont font = PDType1Font.HELVETICA;
	private float fontSize = 12;
	
	public PDF(String path) throws InvalidPasswordException, IOException {
		File file = new File(path);
        document = PDDocument.load(file);
	}
	
	public void addText(String text, float x, float y, PDPage page) throws IOException {
		@SuppressWarnings("deprecation")
		PDPageContentStream contentStream = new PDPageContentStream(document, page, true, true, true);
		contentStream.beginText();
		contentStream.setFont(font, fontSize);
		contentStream.newLineAtOffset(x * page.getMediaBox().getWidth(), y * page.getMediaBox().getHeight());
		contentStream.showText(text);
		contentStream.endText();
		contentStream.close();
	}
	
	public void addText(String text, float x, float y, int pageIndex) throws IOException {
		PDPage page = document.getPage(pageIndex);
		addText(text, x, y, page);
	}
	
	public PDDocument getDocument() {
		return document;
	}
	
	public PDPageTree getPages() {
		return document.getPages();
	}
	
	public void setFont(PDFont font, float fontSize) {
		this.font = font;
		this.fontSize = fontSize;
	}
	
	public void setFont(PDFont font) {
		setFont(font, this.fontSize);
	}
	
	public void setFontSize(float fontSize) {
		setFont(this.font, fontSize);
	}
	
	public void save(String path) throws IOException {
		document.save(path);
	}
	
	public void close() throws IOException {
		document.close();
	}

}
