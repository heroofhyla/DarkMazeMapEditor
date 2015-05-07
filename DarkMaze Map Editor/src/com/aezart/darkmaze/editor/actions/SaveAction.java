package com.aezart.darkmaze.editor.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;

import com.aezart.darkmaze.editor.GUI;
import com.aezart.darkmaze.editor.MapModel;

public class SaveAction extends AbstractAction{
	MapModel mapModel;
	GUI gui;
	public SaveAction(MapModel mapModel, GUI gui){
		super("Save");
		this.mapModel = mapModel;
		this.gui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser fileDialog = new JFileChooser();
		if (fileDialog.showSaveDialog(gui.frame) == JFileChooser.APPROVE_OPTION){
			File toSave = fileDialog.getSelectedFile();
			System.out.println(toSave.toString());
			System.out.println(toSave.toString().endsWith(".dmap"));
			if (!(toSave.toString().endsWith(".dmap"))){
				toSave = new File(toSave.getAbsolutePath() + ".dmap");
			}
			FileOutputStream fileOS;
			try {
				fileOS = new FileOutputStream(toSave);
				ObjectOutputStream objectOS = new ObjectOutputStream(fileOS);
				objectOS.writeObject(mapModel.map);
				objectOS.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
