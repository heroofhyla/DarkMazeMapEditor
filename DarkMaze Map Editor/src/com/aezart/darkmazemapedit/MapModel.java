package com.aezart.darkmazemapedit;

import com.aezart.darkmazemapedit.GUI.EditingMode;

public class MapModel {
	//remember that arrays are stored [row][column]
	boolean[][] mapTiles = new boolean[15][19];
	boolean[][] enemyLocations = new boolean[30][38];
	boolean[][] coinLocations = new boolean[15][19];
	boolean[][] lightLocations = new boolean[15][19];
	boolean[][] powerupLocations = new boolean[15][19];
	
	public void toggleTile(EditingMode e, int x, int y){
		boolean[][] layer = editingLayer(e);
		
		layer[y][x] = !layer[y][x];
	}
	
	public void setTile(EditingMode e, int x, int y, boolean b){
		boolean[][] layer = editingLayer(e);
		layer[y][x] = b;
	}
	
	private boolean[][] editingLayer(EditingMode e){
		switch (e){
		case MAP_MODE:
			return mapTiles;
		case ENEMY_MODE:
			return enemyLocations;
		case LIGHT_MODE:
			return lightLocations;
		case COIN_MODE:
			return coinLocations;
		case POWERUP_MODE:
			return powerupLocations;
		default:
			return mapTiles;
		}
	}

	public boolean getTileState(EditingMode e, int xTile, int yTile) {
		boolean[][] layer = editingLayer(e);
		return layer[yTile][xTile];
	}
}
