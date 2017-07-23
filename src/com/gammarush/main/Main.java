package com.gammarush.main;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        PDF pdf = new PDF("res/input.pdf");
    	
        pdf.setFontSize(14);
    	pdf.addText("The quick brown fox jumps over the lazy dog.", .25f, .5f, 0);
    	
    	System.out.println("PDF Saved");
    	pdf.save("res/output.pdf");
    	pdf.close();
    }
    
}
