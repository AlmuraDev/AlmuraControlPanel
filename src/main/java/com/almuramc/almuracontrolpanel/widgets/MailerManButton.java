/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import com.almuramc.mailerman.MailerMan;
import com.almuramc.mailerman.MainGUI;

import net.dockter.infoguide.GuideListener;

import org.bukkit.ChatColor;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author ZNickq
 */
public class MailerManButton extends GuiButton{
	
	public MailerManButton() {
		super("Almura Email", "mailerman.use");
	}

	@Override
	public void openGui(SpoutPlayer who) {
		if (who.hasPermission("MailerMan.use")) {
			MailerMan pls = get("MailerMan", MailerMan.class);
			who.getMainScreen().attachPopupScreen(new MainGUI(pls, who));
		} else {
			who.sendMessage(ChatColor.GREEN + "[Almura CP]:" + ChatColor.DARK_RED + "  Access Denied!");
		}		
	}	
}
