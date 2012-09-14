/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.znickq.almuracontrolpanel;

import net.dockter.infoguide.gui.GUIGuide;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;

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
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = null;
		
		if (sender instanceof Player) {
			player = (Player) sender;
		}

		if (cmd.getName().equalsIgnoreCase("acp")) {
			if (player == null) {
				sender.sendMessage("Almura Control Panel cannot be run from the server console.");
			} else {
				((SpoutPlayer) sender).getMainScreen().attachPopupScreen(new ControlPanelGUI(this));
			}
			return true;
		}
		return false;
	}
}
