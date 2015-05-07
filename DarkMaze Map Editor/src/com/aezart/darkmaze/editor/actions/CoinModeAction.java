package com.aezart.darkmaze.editor.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.aezart.darkmaze.editor.GUI;
import com.aezart.darkmaze.editor.GUI.EditingMode;

public class CoinModeAction extends AbstractAction{
	GUI gui;
	public CoinModeAction(GUI gui){
		super("円");
		this.gui = gui;
		putValue(SHORT_DESCRIPTION, "Coins");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gui.setEditingMode(EditingMode.COIN_MODE);
	}

}
