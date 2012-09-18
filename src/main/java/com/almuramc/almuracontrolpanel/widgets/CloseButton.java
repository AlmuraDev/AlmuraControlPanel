/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import com.almuramc.playerplus.PlayerPlus;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.GenericButton;

import com.almuramc.almuracontrolpanel.AlmuraControlPanel;

public class CloseButton extends GenericButton {

	private AlmuraControlPanel i;

	public CloseButton(AlmuraControlPanel i) {
		super("Close");
		this.i = i;
	}

	public CloseButton(boolean openMain) {
		super("Close");
	}

	@Override
	public void onButtonClick(ButtonClickEvent event) {
		event.getPlayer().getMainScreen().closePopup();
	}
}