/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import java.net.MalformedURLException;

import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.player.SpoutPlayer;

public class AlmuraMapButton extends GenericButton {

	public AlmuraMapButton(boolean openMain) {
		super("Live Server Map");
	}

	@Override
	public void onButtonClick(ButtonClickEvent event) {
		SpoutPlayer sPlayer = (SpoutPlayer)event.getPlayer();
		try {
			sPlayer.sendLink("http://srv1.almuramc.com:8123");
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		}		
	}
}