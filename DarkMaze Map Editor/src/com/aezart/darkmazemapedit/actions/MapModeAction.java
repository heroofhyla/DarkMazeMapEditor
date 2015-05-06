package com.aezart.darkmazemapedit.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.aezart.darkmazemapedit.GUI;
import com.aezart.darkmazemapedit.GUI.EditingMode;

public class MapModeAction extends AbstractAction{
	GUI gui;
	public MapModeAction(GUI gui){
		super("図");
		this.gui = gui;

		putValue(SHORT_DESCRIPTION, "Map");

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gui.setEditingMode(EditingMode.MAP_MODE);
		
	}

}
