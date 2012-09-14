/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import com.almuramc.backpack.bukkit.gui.UpgradePanel;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author ZNickq
 */
public class BackpackButton extends GuiButton {
	
	public BackpackButton() {
		super("Backpack Upgrade");
	}

	@Override
	public void openGui(SpoutPlayer who) {
		who.getMainScreen().attachPopupScreen(new UpgradePanel(who));
	}
	
}
