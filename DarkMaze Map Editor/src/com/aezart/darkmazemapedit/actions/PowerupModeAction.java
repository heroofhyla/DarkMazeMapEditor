package com.aezart.darkmazemapedit.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.aezart.darkmazemapedit.GUI;
import com.aezart.darkmazemapedit.GUI.EditingMode;

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
