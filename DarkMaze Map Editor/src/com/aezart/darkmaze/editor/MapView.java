package com.aezart.darkmaze.editor;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.aezart.darkmaze.editor.GUI.EditingMode;

public class MapView extends JPanel{
	boolean initialized = false;
	BufferedImage tileset;
	BufferedImage enemy;
	BufferedImage mapImage;
	BufferedImage enemiesImage;
	GUI gui;
	public MapView(GUI gui){
		this.gui = gui;
	}
	public void init(){
		try {
			tileset = importImage("resources/tileset2.png", Transparency.BITMASK);
			enemy = importImage("resources/littlecloak.png", Transparency.BITMASK);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		mapImage = getGraphicsConfiguration().createCompatibleImage(608, 480);
		enemiesImage = getGraphicsConfiguration().createCompatibleImage(608, 480, Transparency.BITMASK);
		
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
			g.drawImage(enemiesImage, 0, 0, null);
			if (gui.mouseInMap()){
				if (gui.editingMode() == EditingMode.ENEMY_MODE){
					g.setColor(Color.RED);
					g.drawRect(gui.mouseHalfXTile() * 16, gui.mouseHalfYTile() * 16, 16, 16);
				}else{
					g.setColor(Color.RED);
					g.drawRect(gui.mouseXTile() * 32, gui.mouseYTile() * 32, 32, 32);
				}
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
	
	public void enemiesUpdated(int xTile, int yTile, boolean newEnemyState){
		if (newEnemyState){
			enemiesImage.getGraphics().drawImage(enemy, xTile*16, yTile*16, null);
		}else{
			Graphics2D g2d = (Graphics2D)enemiesImage.getGraphics();
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
			g2d.fillRect(xTile*16, yTile*16, 16, 16);
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
		}
	}
}
