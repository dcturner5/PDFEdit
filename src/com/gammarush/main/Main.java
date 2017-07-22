package com.gammarush.main;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("res/input.pdf");
        PDDocument document = PDDocument.load(file);
    	
    	int pageIndex = 0;
    	for(PDPage page : document.getPages()) {
    		
			@SuppressWarnings("deprecation")
			PDPageContentStream contentStream = new PDPageContentStream(document, page, true, true, true);
    		contentStream.beginText();
    		contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
    		contentStream.newLineAtOffset(100, 100);
    		contentStream.showText("Hello World");
    		contentStream.endText();
    		contentStream.close();
    		
            pageIndex++;
        }
    	
    	System.out.println("PDF Saved");
    	document.save("res/output.pdf");
    	document.close();
    }
    
}
