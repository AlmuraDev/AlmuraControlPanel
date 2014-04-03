/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel;

import org.anjocaido.groupmanager.events.GMUserEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.event.spout.SpoutcraftFailedEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

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

	@EventHandler(priority=EventPriority.HIGHEST)
	public void onSpoutcraftAuth(SpoutCraftEnableEvent event) {
		SpoutPlayer sPlayer = event.getPlayer();		
		AlmuraBroadcastLogin(sPlayer);
		AlmuraTitle(sPlayer);	
	}

	@EventHandler
	public void onGMUserEvent(GMUserEvent userEvent) {
		for (Player p : getServer().getOnlinePlayers()) {				    	 
			if ((p) instanceof SpoutPlayer && userEvent.getUserName().equalsIgnoreCase(p.getName())) {
				final SpoutPlayer sPlayer = (SpoutPlayer)p;
				final GMUserEvent event = userEvent;
				Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						AlmuraTitle(sPlayer);			

						if ((GMUserEvent.Action.USER_GROUP_CHANGED == event.getAction()) && (event.getUser().getGroupName().equalsIgnoreCase("member"))) {
							Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + sPlayer.getDisplayName() + ChatColor.WHITE + " has been promoted to: [" + ChatColor.GOLD + event.getUser().getGroupName() + ChatColor.WHITE + "]");
						}

						if ((GMUserEvent.Action.USER_GROUP_CHANGED == event.getAction()) && (event.getUser().getGroupName().equalsIgnoreCase("supermember"))) {
							Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + sPlayer.getDisplayName() + ChatColor.WHITE + " has been promoted to: [" + ChatColor.GOLD + event.getUser().getGroupName() + ChatColor.WHITE + "]");
							Bukkit.broadcastMessage(ChatColor.WHITE + "Almura Thanks " + ChatColor.GOLD + sPlayer.getDisplayName() + ChatColor.WHITE + " for their donation.  It is very much appreciated.");
						}

						if ((GMUserEvent.Action.USER_GROUP_CHANGED == event.getAction()) && (event.getUser().getGroupName().equalsIgnoreCase("ultramember"))) {
							Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + sPlayer.getDisplayName() + ChatColor.WHITE + " has been promoted to: [" + ChatColor.GOLD + event.getUser().getGroupName() + ChatColor.WHITE + "]");
							Bukkit.broadcastMessage(ChatColor.WHITE + "Almura Thanks " + ChatColor.GOLD + sPlayer.getDisplayName() + ChatColor.WHITE + " for their donation.  It is very much appreciated.");
						}
					}
				}, 40L);
			}
		}
	}

	public void promoteMessage(SpoutPlayer sPlayer, String newGroup) {				
		AlmuraTitle(sPlayer);	

		if (newGroup.equalsIgnoreCase("member")) {						
			Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + sPlayer.getDisplayName() + ChatColor.WHITE + " has been promoted to: [" + ChatColor.GOLD + "Member" + ChatColor.WHITE + "]");					
		}

		if (newGroup.equalsIgnoreCase("supermember")) {							
			Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + sPlayer.getDisplayName() + ChatColor.WHITE + " has been promoted to: [" + ChatColor.GOLD + "SuperMember" + ChatColor.WHITE + "]");
			Bukkit.broadcastMessage(ChatColor.WHITE + "Almura Thanks " + ChatColor.GOLD + sPlayer.getDisplayName() + ChatColor.WHITE + " for their donation.  It is very much appreciated.");
		}

		if (newGroup.equalsIgnoreCase("ultramember")) {							
			Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + sPlayer.getDisplayName() + ChatColor.WHITE + " has been promoted to: [" + ChatColor.GOLD + "UltraMember" + ChatColor.WHITE + "]");
			Bukkit.broadcastMessage(ChatColor.WHITE + "Almura Thanks " + ChatColor.GOLD + sPlayer.getDisplayName() + ChatColor.WHITE + " for their donation.  It is very much appreciated.");
		}
	}

	@EventHandler(priority=EventPriority.LOWEST)
	public void onPlayerJoin(PlayerJoinEvent event)  {
		Player player = event.getPlayer();
		player.getName();
		event.setJoinMessage("");	   	    
	}
	
	@EventHandler(priority=EventPriority.LOWEST)
	 public void onSpoutcraftFailed(SpoutcraftFailedEvent event) {
		SpoutPlayer sPlayer = event.getPlayer();		
		//AlmuraBroadcastLogin(sPlayer);
		AlmuraNonSpoutcraft(sPlayer);
		AlmuraTitle(sPlayer);	
	}

	@EventHandler(priority=EventPriority.LOWEST)
	public void onPlayerQuit(PlayerQuitEvent event) {
		event.setQuitMessage("");
		SpoutPlayer sPlayer = (SpoutPlayer) event.getPlayer();		
		if (sPlayer.isSpoutCraftEnabled()) {
			if (sPlayer.hasPermission("admin.title") && sPlayer.isOp()) {			
				Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Almura SuperAdmin" + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has left the server.");
				return;
			}	

			if (sPlayer.hasPermission("admin.title") && !sPlayer.isOp()) {			
				if (sPlayer.getName().equalsIgnoreCase("wifee")) {
					Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + "The Destroyer of Worlds..."  + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has left the server.");
				} else {
					Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Almura Admin"  + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has left the server.");
				}
				return;
			}

			if (sPlayer.hasPermission("spoutteam.title") && !sPlayer.hasPermission("Admin.title")) {			
				Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_BLUE + "SpoutTeam"  + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has left the server.");
				return;
			}

			if (sPlayer.hasPermission("mod.title") && !sPlayer.hasPermission("Admin.title")) {
				Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_BLUE + "Moderator"  + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has left the server.");				
				return;
			}

			if (sPlayer.hasPermission("Dev.title") && !sPlayer.hasPermission("admin.title")) {			
				Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.YELLOW + "Developer"  + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has left the server.");
				return;
			}

			if (sPlayer.hasPermission("CreativeMember.title") && !sPlayer.hasPermission("Mod.title")) {							
				Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_BLUE + "CreativeMember" + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has left the server.");
				return;
			}

			if (sPlayer.hasPermission("Ultra.title") && !sPlayer.hasPermission("CreativeMember.title")) {			
				Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + "UltraMember" + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has left the server.");
				return;
			}

			if (sPlayer.hasPermission("SuperMember.title") && !sPlayer.hasPermission("UltraMember.title")) {							
				Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "SuperMember" + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has left the server.");
				return;
			}

			if (sPlayer.hasPermission("Member.title") && !sPlayer.hasPermission("SuperMember.title")) {			
				Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.YELLOW + "Member" + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has left the server.");
				return;
			}

			if (sPlayer.hasPermission("Guest.title") && !sPlayer.hasPermission("Member.title")) {			
				Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.GRAY + "Guest" + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has left the server.");
				return;
			}
		}
	}

	public void AlmuraBroadcastLogin(SpoutPlayer sPlayer) {

		if (!sPlayer.hasPlayedBefore()) {
			Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.LIGHT_PURPLE + "Newbie" + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has joined the server for the First Time!");
			return;
		}

		if (sPlayer.hasPermission("admin.title") && sPlayer.isOp()) {
			Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Almura SuperAdmin" + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has joined the server.");
			return;
		}	

		if (sPlayer.hasPermission("admin.title") && !sPlayer.isOp()) {
			if (sPlayer.getName().equalsIgnoreCase("wifee")) {
				Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + "The Destroyer of Worlds..."  + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has joined the server.");
			} else {
				Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Almura Admin"  + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has joined the server.");
			}
			return;
		}

		if (sPlayer.hasPermission("spoutteam.title") && !sPlayer.hasPermission("Admin.title")) {
			Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_BLUE + "SpoutTeam"  + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has joined the server.");
			return;
		}

		if (sPlayer.hasPermission("mod.title") && !sPlayer.hasPermission("Admin.title")) {
			Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_BLUE + "Moderator"  + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has joined the server.");
			return;
		}

		if (sPlayer.hasPermission("Dev.title") && !sPlayer.hasPermission("admin.title")) {
			Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Developer"  + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has joined the server.");
			return;
		}

		if (sPlayer.hasPermission("CreativeMember.title") && !sPlayer.hasPermission("Mod.title")) {
			Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.LIGHT_PURPLE + "CreativeMember" + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has joined the server.");
			return;
		}

		if (sPlayer.hasPermission("Ultra.title") && !sPlayer.hasPermission("CreativeMember.title")) {
			Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + "UltraMember" + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has joined the server.");
			return;
		}

		if (sPlayer.hasPermission("SuperMember.title") && !sPlayer.hasPermission("UltraMember.title")) {
			Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "SuperMember" + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has joined the server.");
			return;
		}

		if (sPlayer.hasPermission("Member.title") && !sPlayer.hasPermission("SuperMember.title")) {
			Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.YELLOW + "Member" + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has joined the server.");
			return;
		}

		if (sPlayer.hasPermission("Guest.title") && !sPlayer.hasPermission("Member.title")) {
			Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.GRAY + "Guest" + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has joined the server.");
			return;
		}					

	}
	
	public void AlmuraNonSpoutcraft(SpoutPlayer sPlayer) {
		sPlayer.sendMessage(ChatColor.DARK_AQUA + "Spoutcraft" + ChatColor.RESET + " is strongly recommended for players on this server.  Please visit " + ChatColor.AQUA + "http://get.spout.org" + ChatColor.RESET + " to download Spoutcraft, its Free and you will not be able to see the majority of our custom content without it.");
		Bukkit.broadcastMessage(ChatColor.WHITE + "[" + ChatColor.GRAY + "Non-Spoutcraft User" + ChatColor.WHITE + "] -  " + sPlayer.getDisplayName() + ", has joined the server.");
	}

	public void AlmuraTitle(SpoutPlayer sPlayer) {
		
		if (sPlayer.hasPermission("admin.title") && sPlayer.isOp()) {
			sPlayer.setTitle(sPlayer.getDisplayName()+"\n"+ChatColor.DARK_RED+"Almura SuperAdmin" + ChatColor.RESET);			
			return;
		}	

		if (sPlayer.hasPermission("admin.title") && !sPlayer.isOp()) {
			if (sPlayer.getName().equalsIgnoreCase("wifee")) {
				sPlayer.setTitle(sPlayer.getDisplayName()+"\n"+ChatColor.GOLD+"Destroyer of Worlds" + ChatColor.RESET);
			} else { 
				sPlayer.setTitle(sPlayer.getDisplayName()+"\n"+ChatColor.DARK_RED+"Almura Admin" + ChatColor.RESET);
			}
			return;
		}

		if (sPlayer.hasPermission("spoutteam.title") && !sPlayer.hasPermission("Admin.title")) {
			sPlayer.setTitle(sPlayer.getDisplayName()+"\n"+ChatColor.DARK_BLUE+"SpoutTeam" + ChatColor.RESET);			
			return;
		}

		if (sPlayer.hasPermission("mod.title") && !sPlayer.hasPermission("Admin.title")) {
			sPlayer.setTitle(sPlayer.getDisplayName()+"\n"+ChatColor.DARK_BLUE+"Moderator" + ChatColor.RESET);			
			return;
		}

		if (sPlayer.hasPermission("Dev.title") && !sPlayer.hasPermission("admin.title")) {
			sPlayer.setTitle(sPlayer.getDisplayName()+"\n"+ChatColor.DARK_RED+"Developer" + ChatColor.RESET);			
			return;
		}

		if (sPlayer.hasPermission("CreativeMember.title") && !sPlayer.hasPermission("Mod.title")) {
			sPlayer.setTitle(sPlayer.getDisplayName()+"\n"+ChatColor.LIGHT_PURPLE+"CreativeMember" + ChatColor.RESET);			
			return;
		}

		if (sPlayer.hasPermission("Ultra.title") && !sPlayer.hasPermission("CreativeMember.title")) {
			sPlayer.setTitle(sPlayer.getDisplayName()+"\n"+ChatColor.GOLD+"UltraMember" + ChatColor.RESET);
			return;
		}

		if (sPlayer.hasPermission("SuperMember.title") && !sPlayer.hasPermission("UltraMember.title")) {
			sPlayer.setTitle(sPlayer.getDisplayName()+"\n"+ChatColor.DARK_GREEN+"SuperMember" + ChatColor.RESET);				
			return;
		}

		if (sPlayer.hasPermission("Member.title") && !sPlayer.hasPermission("SuperMember.title")) {
			sPlayer.setTitle(sPlayer.getDisplayName()+"\n"+ChatColor.YELLOW+"Member" + ChatColor.RESET);
			return;
		}

		if (!sPlayer.hasPlayedBefore()) {
			sPlayer.setTitle(sPlayer.getDisplayName()+"\n"+ChatColor.LIGHT_PURPLE + "Newbie" + ChatColor.RESET);			
			return;
		}
		
		if (sPlayer.hasPermission("Guest.title") && !sPlayer.hasPermission("Member.title")) {
			sPlayer.setTitle(sPlayer.getDisplayName()+"\n"+ChatColor.GRAY+"Guest" + ChatColor.RESET);
			return;
		}					
	}	
}
