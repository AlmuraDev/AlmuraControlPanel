/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.znickq.almuracontrolpanel;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.keyboard.Keyboard;

/**
 *
 * @author ZNickq
 */
public class AlmuraControlPanel extends JavaPlugin implements Listener{

	@Override
	public void onDisable() {
	}

	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
	}
	
	@EventHandler
	public void onInput(KeyPressedEvent event) {
		if(event.getKey() != Keyboard.KEY_Y) {
			return;
		}
		if(event.getScreenType() != ScreenType.GAME_SCREEN) {
			return;
		}
		event.getPlayer().getMainScreen().attachPopupScreen(new ControlPanelGUI(this));
	}
	
}
