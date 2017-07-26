package com.gammarush.main;

import java.io.IOException;
import java.util.List;

import com.gammarush.main.parser.position.PositionData;
import com.gammarush.main.parser.position.PositionParser;
import com.gammarush.main.parser.text.TextData;
import com.gammarush.main.parser.text.TextParser;

public class Main {

    public static void main(String[] args) throws IOException {
    	PDF pdf = new PDF("res/input.pdf");
    	List<TextData> texts = TextParser.parse("res/input-texts.txt");
    	List<PositionData> positions = PositionParser.parse("res/input-positions.txt");
    	
    	for(PositionData p : positions) {
    		for(TextData t : texts) {
    			if(t.name.equals(p.name)) {
    				pdf.addText(t.text, p.x, p.y, p.pageIndex);
    				break;
    			}
    		}
    	}
    	
    	pdf.save("res/output.pdf");
    	pdf.close();
    	
    	System.out.println("PDF Saved");
    }
    
}
