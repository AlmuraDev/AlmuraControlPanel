package com.almuramc.almuracontrolpanel;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.zford.jobs.Jobs;

public class AlmuraListener extends JavaPlugin implements Listener{

	private static AlmuraControlPanel instance;

	public static AlmuraControlPanel getInstance() {
		return instance;
	}
	
	 @EventHandler(priority=EventPriority.LOW, ignoreCancelled=true)
	    public void onBlockPlace(BlockPlaceEvent event) {
	        Block block = event.getBlock();
	        if (block == null)
	            return;
	        
	        // Stone Brick
	        if (block.getType() == Material.BRICK) {	        	
	        	if (!Jobs.hasRequiredJobAndLevel(event.getPlayer(), "Builder", 10)) {
	        		messagePlayer(event.getPlayer(), "Builder", 10, block);
	        		event.setCancelled(true);
	        		return;
	        	}
	        }
	        
	        // Stone Brick Stairs
	        if (block.getType() == Material.BRICK_STAIRS) {	        	
	        	if (!Jobs.hasRequiredJobAndLevel(event.getPlayer(), "Builder", 10)) {
	        		messagePlayer(event.getPlayer(), "Builder", 10, block);
	        		event.setCancelled(true);
	        		return;
	        	}
	        }
	        
	        // Glowstone
	        if (block.getType() == Material.GLOWSTONE) {	        	
	        	if (!Jobs.hasRequiredJobAndLevel(event.getPlayer(), "Builder", 15)) {
	        		messagePlayer(event.getPlayer(), "Builder", 15, block);
	        		event.setCancelled(true);
	        		return;
	        	}
	        }
	        
	        
	 }
	 
	 public void messagePlayer(Player player, String job, int jobLevel, Block block) {
		 player.sendMessage("[Jobs] - you need to be a " + job + ", lvl " + jobLevel + " in order to place block: " + block.getType().name());
	 }
}