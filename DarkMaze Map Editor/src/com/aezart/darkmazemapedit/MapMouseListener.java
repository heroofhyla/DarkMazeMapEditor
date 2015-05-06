package com.aezart.darkmazemapedit;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.aezart.darkmazemapedit.GUI.EditingMode;

public class MapMouseListener implements MouseListener, MouseMotionListener{
	public boolean painting = false;
	public boolean paintingWalls = false;
	int currentXTile = 0;
	int currentHalfXTile = 0;
	int currentHalfYTile = 0;
	int currentYTile = 0;
	GUI gui;
	public MapMouseListener(GUI gui){
		this.gui = gui;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		currentXTile = -1;
		currentYTile = -1;
		currentHalfXTile = -1;
		currentHalfYTile = -1;
		gui.alertMouseMove();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		paintingWalls = !gui.getTileState(EditingMode.MAP_MODE, currentXTile, currentYTile);
		gui.alertPaint(currentXTile, currentYTile, currentHalfXTile, currentHalfYTile);
		painting = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		painting = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int nextXTile = e.getX()/32;
		int nextYTile = e.getY()/32;
		int nextHalfXTile = e.getX()/16;
		int nextHalfYTile = e.getY()/16;
		boolean needRepaint = false;
		if (nextXTile != currentXTile || nextYTile != currentYTile){
			currentXTile = e.getX()/32;
			currentYTile = e.getY()/32;
			needRepaint = true;
		}
		if (nextHalfXTile != currentHalfXTile || nextHalfYTile != currentHalfYTile){
			currentHalfXTile = e.getX()/16;
			currentHalfYTile = e.getY()/16;
			needRepaint = true;
		}
		
		if (needRepaint){
			gui.alertMouseMove();
		}
		if (currentXTile >= 0 && currentXTile < 19 && currentYTile >= 0 && currentYTile < 15){
			gui.alertDragPaint(currentXTile, currentYTile);
		}


	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int nextXTile = e.getX()/32;
		int nextYTile = e.getY()/32;
		int nextHalfXTile = e.getX()/16;
		int nextHalfYTile = e.getY()/16;
		boolean needRepaint = false;
		if (nextXTile != currentXTile || nextYTile != currentYTile){
			currentXTile = e.getX()/32;
			currentYTile = e.getY()/32;
			needRepaint = true;
		}
		if (nextHalfXTile != currentHalfXTile || nextHalfYTile != currentHalfYTile){
			currentHalfXTile = e.getX()/16;
			currentHalfYTile = e.getY()/16;
			needRepaint = true;
		}
		
		if (needRepaint){
			gui.alertMouseMove();
		}
	}
	
}
