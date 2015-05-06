package com.aezart.darkmazemapedit;

public class MapModel {
	//remember that arrays are stored [row][column]
	boolean[][] mapTiles = new boolean[15][19];
	
	public void toggleTile(int x, int y){
		mapTiles[y][x] = !mapTiles[y][x];
	}
	
	public void setTile(int x, int y, boolean b){
		mapTiles[y][x] = b;
	}
}
