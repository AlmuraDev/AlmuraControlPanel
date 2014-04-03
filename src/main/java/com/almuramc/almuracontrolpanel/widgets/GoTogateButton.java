/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.GenericButton;
import com.almuramc.almuracontrolpanel.AlmuraControlPanel;

public class GoTogateButton extends GenericButton {

	public GoTogateButton(AlmuraControlPanel i) {
		super("City Gates");	
	}

	public GoTogateButton(boolean openMain) {
		super("City Gates");
	}

	@Override
	public void onButtonClick(ButtonClickEvent event) {
		event.getPlayer().getMainScreen().closePopup();
		int x = -345; // X
		int y = 84; // Y
		int z = 1085; // Z
		World tpWorld = Bukkit.getServer().getWorld("world");
		Location location = tpWorld.getBlockAt(x, y, z).getLocation();
		event.getPlayer().teleport(location);		
	}
}