package com.gammarush.main.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
	
	public static List<String> load(String path) throws IOException {
		List<String> lines = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
		    String line = br.readLine();
		    while (line != null) {
		    	lines.add(line);
		        line = br.readLine();
		    }
		} 
		finally {
		    br.close();
		}
		return lines;
	}

}
