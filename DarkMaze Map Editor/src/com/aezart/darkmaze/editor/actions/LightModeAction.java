package com.aezart.darkmaze.editor.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.aezart.darkmaze.editor.GUI;
import com.aezart.darkmaze.editor.GUI.EditingMode;

public class LightModeAction extends AbstractAction{
	GUI gui;

	public LightModeAction(GUI gui){
		super("光");
		this.gui = gui;
		putValue(SHORT_DESCRIPTION, "Light Sources");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gui.setEditingMode(EditingMode.LIGHT_MODE);
		
	}

}
