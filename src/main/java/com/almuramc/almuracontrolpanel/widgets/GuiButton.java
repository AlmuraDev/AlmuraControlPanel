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
