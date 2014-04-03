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

public class GoToSpawnButton extends GenericButton {

	public GoToSpawnButton(AlmuraControlPanel i) {
		super("Almura Castle");
	}

	public GoToSpawnButton(boolean openMain) {
		super("Almura Castle");
	}

	@Override
	public void onButtonClick(ButtonClickEvent event) {
		event.getPlayer().getMainScreen().closePopup();
		int x = -337; // X
		int y = 69; // Y
		int z = 1090; // Z
		World tpWorld = Bukkit.getServer().getWorld("world");
		Location location = tpWorld.getBlockAt(x, y, z).getLocation();
		event.getPlayer().teleport(location);		
	}
}