package com.aezart.darkmazemapedit;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class GUI {
	JFrame frame;
	MapView mapView;
	MapMouseListener mouseInfo;
	MapModel mapModel;
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
		tools.add(createJButton("図", "Map"));
		tools.add(createJButton("人", "Enemies"));
		tools.add(createJButton("光", "Light Sources"));
		tools.add(createJButton("円", "Coins"));
		tools.add(createJButton("火", "Powerups"));
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
	
	public JButton createJButton(String text, String toolTip){
		JButton btn = new JButton(text);
		btn.setToolTipText(toolTip);
		return btn;
	}
	
	public int mouseXTile(){
		return mouseInfo.currentXTile;
	}
	
	public int mouseYTile(){
		return mouseInfo.currentYTile;
	}
	
	public void alertMouseMove(){
		frame.repaint();
	}
	
	public boolean mouseInMap(){
		return (mouseInfo.currentXTile >= 0 && mouseInfo.currentYTile >= 0);
	}
	
	public void alertPaint(int xTile, int yTile){
		mapModel.setTile(xTile, yTile, mouseInfo.paintingWalls);
		mapView.mapUpdated(xTile, yTile, getTileState(xTile,yTile));
		frame.repaint();
	}
	
	public boolean getTileState(int xTile, int yTile){
		return mapModel.mapTiles[yTile][xTile];
	}
}
