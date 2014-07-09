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

import com.almuramc.helprequest.HelpRequest;
import com.almuramc.helprequest.MainGUI;

import org.bukkit.ChatColor;
import org.getspout.spoutapi.player.SpoutPlayer;

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
