package com.gammarush.main.parser.position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gammarush.main.parser.FileLoader;

public class PositionParser {
	
	public static List<PositionData> parse(String path) throws IOException {
		List<PositionData> positions = new ArrayList<PositionData>();
		List<String> raw = FileLoader.load(path);
		for(String line : raw) {
			String[] parts = line.split("=");
			String name = parts[0], data = parts[1];
			String[] position = data.split(",");
			positions.add(new PositionData(name, position));
		}
		return positions;
	}

}
