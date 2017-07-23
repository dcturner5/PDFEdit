package com.gammarush.main.parser.position;

public class PositionData {
	
	public String name;
	public float x, y;
	public int pageIndex;
	
	public PositionData(String name, String[] position) {
		this.name = name;
		this.x = Float.parseFloat(position[0]);
		this.y = Float.parseFloat(position[1]);
		this.pageIndex = Integer.parseInt(position[2]);
	}
	
}