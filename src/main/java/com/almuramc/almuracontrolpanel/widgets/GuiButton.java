/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import org.bukkit.Bukkit;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author ZNickq
 */
public abstract class GuiButton extends GenericButton {

	public GuiButton(String text) {
		super(text);
	}

	public abstract void openGui(SpoutPlayer who);

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
		}, 20L);
	}
}
