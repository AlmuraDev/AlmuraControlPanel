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
