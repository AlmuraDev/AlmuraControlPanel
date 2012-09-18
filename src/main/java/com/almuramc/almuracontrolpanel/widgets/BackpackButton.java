/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import com.almuramc.backpack.bukkit.gui.UpgradePanel;

import org.bukkit.ChatColor;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author ZNickq
 */
public class BackpackButton extends GuiButton {
	
	public BackpackButton() {
		super("Backpack Upgrade", "backpack.use");
	}

	@Override
	public void openGui(SpoutPlayer who) {
		if (who.hasPermission("Backpack.upgrade")) {
		who.getMainScreen().attachPopupScreen(new UpgradePanel(who));
		} else {
			who.sendMessage(ChatColor.GREEN + "[Almura CP]:" + ChatColor.DARK_RED + "  Access Denied!");
		}
	}
	
}
