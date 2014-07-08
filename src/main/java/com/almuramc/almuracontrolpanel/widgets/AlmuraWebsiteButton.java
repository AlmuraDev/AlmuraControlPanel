/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import java.net.MalformedURLException;

import org.bukkit.Bukkit;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.almuramc.almuracontrolpanel.AlmuraControlPanel;

public class AlmuraWebsiteButton extends GenericButton {

	public AlmuraWebsiteButton(boolean openMain) {
		super("Almura Website");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onButtonClick(ButtonClickEvent event) {
		final SpoutPlayer sPlayer = (SpoutPlayer)event.getPlayer();
		sPlayer.closeActiveWindow();
		Bukkit.getScheduler().scheduleSyncDelayedTask(AlmuraControlPanel.getInstance(), new Runnable() {		
			public void run() {
				try {					
					sPlayer.sendLink("http://www.almuramc.com");			
				} catch (MalformedURLException e) {			
					e.printStackTrace();
				}		
			}
		},10L);		
	}
}