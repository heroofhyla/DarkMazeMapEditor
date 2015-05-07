package com.aezart.darkmaze.editor.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.aezart.darkmaze.editor.GUI;
import com.aezart.darkmaze.editor.GUI.EditingMode;

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
