package com.aezart.darkmaze.editor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import com.aezart.darkmaze.editor.actions.*;

public class GUI {
	public enum EditingMode{
		MAP_MODE,
		ENEMY_MODE,
		LIGHT_MODE,
		COIN_MODE,
		POWERUP_MODE
	}
	JFrame frame;
	MapView mapView;
	MapMouseListener mouseInfo;
	MapModel mapModel;
	EditingMode editingMode = EditingMode.MAP_MODE;
	public GUI(){
		mapModel = new MapModel();
		mouseInfo = new MapMouseListener(this);
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new JMenuItem("New"));
		fileMenu.add(new JMenuItem("Save"));
		fileMenu.add(new JMenuItem("Open"));
		fileMenu.add(new JMenuItem("Export"));
		fileMenu.add(new JMenuItem("Exit"));
		menuBar.add(fileMenu);
		JToolBar tools = new JToolBar(JToolBar.VERTICAL);
		//TODO: Button icons!
		ButtonGroup toolButtonsGroup = new ButtonGroup();
		
		ArrayList<JToggleButton> toolButtons = new ArrayList<JToggleButton>();
		toolButtons.add(new JToggleButton(new MapModeAction(this)));
		toolButtons.add(new JToggleButton(new EnemyModeAction(this)));
		toolButtons.add(new JToggleButton(new LightModeAction(this)));
		toolButtons.add(new JToggleButton(new CoinModeAction(this)));
		toolButtons.add(new JToggleButton(new PowerupModeAction(this)));
		toolButtons.get(0).setSelected(true);
		for (JToggleButton b: toolButtons){
			tools.add(b);
			toolButtonsGroup.add(b);
		}
		
		tools.setFloatable(false);
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		mapView = new MapView(this);
		mapView.setPreferredSize(new Dimension(608,480));
		frame.add(menuBar, BorderLayout.NORTH);
		frame.add(tools, BorderLayout.EAST);
		frame.add(mapView, BorderLayout.CENTER);
		mapView.init();
		mapView.addMouseListener(mouseInfo);
		mapView.addMouseMotionListener(mouseInfo);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.repaint();

		frame.setVisible(true);
	}
		
	public int mouseXTile(){
		return mouseInfo.currentXTile;
	}
	
	public int mouseHalfXTile(){
		return mouseInfo.currentHalfXTile;
	}
	public int mouseYTile(){
		return mouseInfo.currentYTile;
	}
	
	public int mouseHalfYTile(){
		return mouseInfo.currentHalfYTile;
	}
	public void alertMouseMove(){
		frame.repaint();
	}
	
	public boolean mouseInMap(){
		return (mouseInfo.currentXTile >= 0 && mouseInfo.currentYTile >= 0);
	}
	
	public void alertPaint(int xTile, int yTile, int halfXTile, int halfYTile){
		if (editingMode == EditingMode.MAP_MODE){
			mapModel.setTile(editingMode, xTile, yTile, mouseInfo.paintingWalls);
			mapView.mapUpdated(xTile, yTile, getTileState(editingMode,xTile,yTile));
			frame.repaint();
		}
		if (editingMode == EditingMode.ENEMY_MODE){
			mapModel.toggleTile(editingMode, halfXTile, halfYTile);
			mapView.enemiesUpdated(halfXTile, halfYTile, getTileState(EditingMode.ENEMY_MODE,halfXTile, halfYTile));
			frame.repaint();
		}
	}
	
	public void alertDragPaint(int xTile, int yTile){
		if (editingMode == EditingMode.MAP_MODE){
			alertPaint(xTile, yTile, xTile*2, yTile*2);
		}
	}
	public boolean getTileState(EditingMode e, int xTile, int yTile){
			return mapModel.getTileState(e, xTile, yTile);
	}
	
	public void setEditingMode(EditingMode e){
		this.editingMode = e;
	}
	
	public EditingMode editingMode(){
		return editingMode;
	}
}
