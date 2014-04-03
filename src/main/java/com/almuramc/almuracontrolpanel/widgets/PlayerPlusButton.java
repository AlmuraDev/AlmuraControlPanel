/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import com.almuramc.playerplus.PlayerPlus;
import com.almuramc.playerplus.TextureChooser;

import org.bukkit.ChatColor;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author ZNickq
 */
public class PlayerPlusButton extends GuiButton{
	
	public PlayerPlusButton() {
		super("Player Plus","playerplus.use");
	}

	@Override
	public void openGui(SpoutPlayer who) {
		if (who.hasPermission("playerplus.use")) {
			PlayerPlus pls = get("PlayerPlus", PlayerPlus.class);
			who.getMainScreen().attachPopupScreen(new TextureChooser(pls, who));
		} else {
			who.sendMessage(ChatColor.GREEN + "[Almura CP]:" + ChatColor.DARK_RED + "  Access Denied!");
		}		
	}	
}
