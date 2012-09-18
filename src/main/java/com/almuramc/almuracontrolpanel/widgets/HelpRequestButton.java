/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import com.almuramc.backpack.bukkit.gui.UpgradePanel;
import com.almuramc.helprequest.HelpRequest;
import com.almuramc.helprequest.MainGUI;

import org.bukkit.ChatColor;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author ZNickq
 */
public class HelpRequestButton extends GuiButton{
	
	public HelpRequestButton() {
		super("Help Request", "helprequest.use");
	}

	@Override
	public void openGui(SpoutPlayer who) {				
		if (who.hasPermission("HelpRequest.use")) {
			HelpRequest pls = get("HelpRequest", HelpRequest.class);
			who.getMainScreen().attachPopupScreen(new MainGUI(pls, who));
		} else {
			who.sendMessage(ChatColor.GREEN + "[Almura CP]:" + ChatColor.DARK_RED + "  Access Denied!");
		}
	}
	
}
