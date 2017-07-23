package com.gammarush.main.parser.text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gammarush.main.parser.FileLoader;

public class TextParser {
	
	public static List<TextData> parse(String path) throws IOException {
		List<TextData> texts = new ArrayList<TextData>();
		List<String> raw = FileLoader.load(path);
		for(String line : raw) {
			String[] parts = line.split("=");
			String name = parts[0], data = parts[1];
			texts.add(new TextData(name, data));
		}
		return texts;
	}

}
