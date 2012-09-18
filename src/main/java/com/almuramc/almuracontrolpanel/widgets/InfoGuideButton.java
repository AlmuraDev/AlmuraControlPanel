/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import net.dockter.infoguide.GuideListener;

import org.bukkit.ChatColor;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.almuramc.backpack.bukkit.gui.UpgradePanel;

/**
 *
 * @author ZNickq
 */
public class InfoGuideButton extends GuiButton{
	
	public InfoGuideButton() {
		super("Info Guide", "infoguide.use");
	}

	@Override
	public void openGui(SpoutPlayer who) {
		if (who.hasPermission("InfoGuide.view")) {
			GuideListener.openInfoGuide(who);
		} else {
			who.sendMessage(ChatColor.GREEN + "[Almura CP]:" + ChatColor.DARK_RED + "  Access Denied!");
		}		
	}
	
}
