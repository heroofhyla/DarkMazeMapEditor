package com.aezart.darkmaze.editor.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.aezart.darkmaze.editor.GUI;
import com.aezart.darkmaze.editor.GUI.EditingMode;

public class PowerupModeAction extends AbstractAction{
	GUI gui;
	public PowerupModeAction(GUI gui){
		super("火");
		this.gui = gui;
		putValue(SHORT_DESCRIPTION, "Powerups");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gui.setEditingMode(EditingMode.POWERUP_MODE);

	}

}
