package com.aezart.darkmaze.editor.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.aezart.darkmaze.editor.GUI;
import com.aezart.darkmaze.editor.GUI.EditingMode;

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
