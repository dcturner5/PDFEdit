package com.gammarush.main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("res/form.pdf");
        List<PDFImage> pdfImages = parsePDF(file);
        exportPDFImages(pdfImages);
    }
    
    public static List<PDFImage> parsePDF(File file) throws IOException {
		@SuppressWarnings("resource")
		RandomAccessFile raf = new RandomAccessFile(file, "r");
    	FileChannel channel = raf.getChannel();
    	ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
    	PDFFile pdfFile = new PDFFile(buffer);
    	
    	List<PDFImage> pdfImages = new ArrayList<PDFImage>();
    	for (int i = 0; i < pdfFile.getNumPages(); i++) {
            pdfImages.add(convertPDFPageToImage(pdfFile.getPage(i)));
        }
    	
		return pdfImages;
    }

    public static PDFImage convertPDFPageToImage(PDFPage page) throws IOException {
    	int width = (int) page.getBBox().getWidth();
    	int height = (int) page.getBBox().getHeight();
    	
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Image image = page.getImage(width, height, new Rectangle(0, 0, width, height), null, true, true);
        Graphics2D bufferedImageGraphics = bufferedImage.createGraphics();
        bufferedImageGraphics.drawImage(image, 0, 0, null);
        
		return new PDFImage(bufferedImage);
    }
    
    public static void exportPDFImages(List<PDFImage> pdfImages) throws IOException {
    	for(int i = 0; i < pdfImages.size(); i++) {
    		
    		PDFImage pdfImage = pdfImages.get(i);
    		pdfImage.drawString("Hello", 165, 390);
    		
    		ImageIO.write(pdfImage.getBufferedImage(), "PNG", new File("res/export" + i + ".png"));
    		
    		System.out.println("Image exported as res/export" + i + ".png");
    	}
    }

}
