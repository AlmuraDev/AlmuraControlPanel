/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.GenericButton;

import com.almuramc.almuracontrolpanel.AlmuraControlPanel;

public class CloseButton extends GenericButton {

	public CloseButton(AlmuraControlPanel i) {
		super("Close");	
	}

	public CloseButton(boolean openMain) {
		super("Close");
	}

	@Override
	public void onButtonClick(ButtonClickEvent event) {
		event.getPlayer().getMainScreen().closePopup();
	}
}