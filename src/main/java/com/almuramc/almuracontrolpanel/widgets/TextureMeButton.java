/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import net.windwaker.textureme.TextureMe;
import net.windwaker.textureme.gui.Selector;

import org.bukkit.ChatColor;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.almuramc.playerplus.PlayerPlus;
import com.almuramc.playerplus.TextureChooser;

/**
 *
 * @author ZNickq
 */
public class TextureMeButton extends GuiButton{
	
	public TextureMeButton() {
		super("Almura Textures","textureme.select");
	}

	@Override
	public void openGui(SpoutPlayer who) {
		if (who.hasPermission("textureme.select")) {
			TextureMe pls = get("TextureMe", TextureMe.class);
			who.getMainScreen().attachPopupScreen(new Selector(pls, who));
		} else {
			who.sendMessage(ChatColor.GREEN + "[Almura CP]:" + ChatColor.DARK_RED + "  Access Denied!");
		}		
	}	
}
