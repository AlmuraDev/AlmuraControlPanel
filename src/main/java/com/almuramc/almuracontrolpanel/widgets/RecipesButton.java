/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import com.almuradev.recipes.RecipesPlugin;
import com.almuradev.recipes.display.RecipesPopup;

import org.bukkit.ChatColor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RecipesButton extends GuiButton{
	
	public RecipesButton() {
		super("Recipe Browser","recipes.use");
	}

	@Override
	public void openGui(SpoutPlayer who) {
		if (who.hasPermission("recipes.use")) {
			RecipesPlugin pls = get("Recipes", RecipesPlugin.class);
			who.getMainScreen().attachPopupScreen(new RecipesPopup(pls, who));
		} else {
			who.sendMessage(ChatColor.GREEN + "[Almura CP]:" + ChatColor.DARK_RED + "  Access Denied!");
		}		
	}	
}
