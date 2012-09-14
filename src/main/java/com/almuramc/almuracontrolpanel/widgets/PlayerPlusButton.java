/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import com.almuramc.playerplus.PlayerPlus;
import com.almuramc.playerplus.TextureChooser;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author ZNickq
 */
public class PlayerPlusButton extends GuiButton{
	
	public PlayerPlusButton() {
		super("Player Plus","playerplus.use");
	}

	@Override
	public void openGui(SpoutPlayer who) {
		PlayerPlus pls = get("PlayerPlus", PlayerPlus.class);
		who.getMainScreen().attachPopupScreen(new TextureChooser(pls, who));
	}
	
}
