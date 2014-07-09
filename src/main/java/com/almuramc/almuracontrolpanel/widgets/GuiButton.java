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

import org.bukkit.Bukkit;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.player.SpoutPlayer;


public abstract class GuiButton extends GenericButton {
	private String permission;

	public GuiButton(String text, String permission) {
		super(text);
                this.permission = permission;
	}

	public void openGui(SpoutPlayer who) {
            if(permission != null && !who.hasPermission(permission)) {
                setEnabled(false);
            }
        }

	@SuppressWarnings("unchecked")
	public <T> T get(String name, Class<T> type) {
		return (T) Bukkit.getPluginManager().getPlugin(name);
	}

	@Override
	public void onButtonClick(final ButtonClickEvent event) {
		event.getPlayer().getMainScreen().closePopup();
		Bukkit.getScheduler().scheduleSyncDelayedTask(event.getButton().getPlugin(), new Runnable() {
			public void run() {
				openGui(event.getPlayer());
			}
		}, 10L);
	}
}
