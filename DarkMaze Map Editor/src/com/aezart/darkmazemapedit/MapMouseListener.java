package com.aezart.darkmazemapedit;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MapMouseListener implements MouseListener, MouseMotionListener{
	public boolean painting = false;
	public boolean paintingWalls = false;
	int currentXTile = 0;
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
		gui.alertMouseMove();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("pressed!");
		paintingWalls = !gui.getTileState(currentXTile, currentYTile);
		gui.alertPaint(currentXTile, currentYTile);
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
		if (nextXTile != currentXTile || nextYTile != currentYTile){
			currentXTile = e.getX()/32;
			currentYTile = e.getY()/32;
			gui.alertMouseMove();
			gui.alertPaint(currentXTile, currentYTile);
		}		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int nextXTile = e.getX()/32;
		int nextYTile = e.getY()/32;
		if (nextXTile != currentXTile || nextYTile != currentYTile){
			currentXTile = e.getX()/32;
			currentYTile = e.getY()/32;
			gui.alertMouseMove();
		}
	}
	
}
