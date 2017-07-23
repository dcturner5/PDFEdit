package com.gammarush.main;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.gammarush.main.gui.AnchorDetails;
import com.gammarush.main.gui.PDFPreview;
import com.gammarush.main.pdf.PDF;

public class PDFPrototype {
	
	public JFrame frame;
	public PDFPreview preview;
	private int previewWidth = 256;
	private int previewHeight = 512;
	
	public PDFPrototype() {
		frame = new JFrame("PDF Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(2560, 1440);
		frame.setResizable(true);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		preview = new PDFPreview();
		preview.setBounds(16, 16, previewWidth, previewHeight);
		
		frame.add(preview);
		
		AnchorDetails d = new AnchorDetails();
		//d.setBounds(800, 800, 800, 800);
		frame.add((JPanel) d);
		
		try {
			PDF pdf = new PDF("res/input.pdf");
			preview.load(pdf);
			
			pdf.addText("The quick brown fox jumps over the lazy dog.", .25f, .5f, 0);
			
			preview.render(0);
	    	//pdf.save("res/output.pdf");
	    	pdf.close();
    	} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) {
    	new PDFPrototype();
    }
    
}
