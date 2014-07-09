/*
 * This file is part of Almura Control Panel.
 *
 * © 2013 AlmuraDev <http://www.almuradev.com/>
 * Almura Control Panel is licensed under the GNU General Public License.
 *
 * Almura Control Panel is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Almura Control Panel is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License. If not,
 * see <http://www.gnu.org/licenses/> for the GNU General Public License.
 */
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

public class AlmuraFAQButton extends GenericButton {

	public AlmuraFAQButton(boolean openMain) {
		super("Getting Started FAQ");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onButtonClick(ButtonClickEvent event) {
		final SpoutPlayer sPlayer = (SpoutPlayer)event.getPlayer();
		sPlayer.closeActiveWindow();
		Bukkit.getScheduler().scheduleSyncDelayedTask(AlmuraControlPanel.getInstance(), new Runnable() {		
			public void run() {
				try {					
					sPlayer.sendLink("http://almura.enjin.com/forum/m/10923981/viewforum/2144690");			
				} catch (MalformedURLException e) {			
					e.printStackTrace();
				}		
			}
		},10L);
	}
}