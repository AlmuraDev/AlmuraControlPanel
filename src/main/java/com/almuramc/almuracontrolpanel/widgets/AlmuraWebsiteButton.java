/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import java.net.MalformedURLException;

import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.player.SpoutPlayer;

public class AlmuraWebsiteButton extends GenericButton {

	public AlmuraWebsiteButton(boolean openMain) {
		super("Almura Website");
	}

	@Override
	public void onButtonClick(ButtonClickEvent event) {
		SpoutPlayer sPlayer = (SpoutPlayer)event.getPlayer();
		try {
			sPlayer.sendLink("http://www.almuramc.com");
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		}		
	}
}