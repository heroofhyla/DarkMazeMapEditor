package com.aezart.darkmazemapedit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MapView extends JPanel{
	boolean initialized = false;
	BufferedImage tileset;
	BufferedImage mapImage;
	GUI gui;
	public MapView(GUI gui){
		this.gui = gui;
	}
	public void init(){
		try {
			tileset = importImage("resources/tileset2.png", Transparency.BITMASK);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		mapImage = getGraphicsConfiguration().createCompatibleImage(608, 480);
		
		for (int i = 0; i < 19; ++i){
			for (int k = 0; k < 15; ++k){
				mapImage.getGraphics().drawImage(tileset, 32*i, 32*k, 32*i + 32, 32*k + 32, 0, 0, 16,16,null);
				
			}
		}
		initialized = true;
		
		
	}
	@Override
	public void paintComponent(Graphics g){
		if (initialized){
			g.drawImage(mapImage, 0, 0, null);
			if (gui.mouseInMap()){
				g.setColor(Color.RED);
				g.drawRect(gui.mouseXTile() * 32, gui.mouseYTile() * 32, 32, 32);
			}
		}
	}
	
	public BufferedImage importImage(String filePath, int transparency) throws IOException{
		BufferedImage rawImage = ImageIO.read(this.getClass().getResource(filePath));
		BufferedImage optimizedImage = getGraphicsConfiguration().createCompatibleImage(rawImage.getWidth(), rawImage.getHeight(), transparency);
		optimizedImage.getGraphics().drawImage(rawImage, 0, 0, null);
		return optimizedImage;
	}
	
	public void mapUpdated(int xTile, int yTile, boolean newTileState){
		if (newTileState){
			mapImage.getGraphics().drawImage(tileset, 32*xTile, 32*yTile, 32*xTile + 32, 32*yTile + 32, 16, 0, 32, 16, null);
		}else{
			mapImage.getGraphics().drawImage(tileset, 32*xTile, 32*yTile, 32*xTile + 32, 32*yTile + 32, 0, 0, 16, 16, null);
		}
	}
}
