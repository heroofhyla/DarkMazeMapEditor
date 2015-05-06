package com.aezart.darkmazemapedit.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.aezart.darkmazemapedit.GUI;
import com.aezart.darkmazemapedit.GUI.EditingMode;

public class EnemyModeAction extends AbstractAction{
	GUI gui;
	public EnemyModeAction(GUI gui){
		super("人");
		this.gui = gui;
		putValue(SHORT_DESCRIPTION, "Enemies");

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gui.setEditingMode(EditingMode.ENEMY_MODE);
		
	}

}
