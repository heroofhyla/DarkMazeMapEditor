package com.aezart.darkmaze.editor;

import com.aezart.darkmaze.editor.GUI.EditingMode;
import com.aezart.darkmaze.map.Map;

public class MapModel {
	//remember that arrays are stored [row][column]	
	Map map;
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
			return map.mapTiles;
		case ENEMY_MODE:
			return map.enemyLocations;
		case LIGHT_MODE:
			return map.lightLocations;
		case COIN_MODE:
			return map.coinLocations;
		case POWERUP_MODE:
			return map.powerupLocations;
		default:
			return map.mapTiles;
		}
	}

	public boolean getTileState(EditingMode e, int xTile, int yTile) {
		boolean[][] layer = editingLayer(e);
		return layer[yTile][xTile];
	}
}
