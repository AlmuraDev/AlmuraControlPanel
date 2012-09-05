/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.znickq.almuracontrolpanel.widgets;

import me.znickq.playerplus.PlayerPlus;
import me.znickq.playerplus.TextureChooser;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author ZNickq
 */
public class PlayerPlusButton extends GuiButton{
	
	public PlayerPlusButton() {
		super("Player Plus");
	}

	@Override
	public void openGui(SpoutPlayer who) {
		PlayerPlus pls = get("PlayerPlus", PlayerPlus.class);
		who.getMainScreen().attachPopupScreen(new TextureChooser(pls, who));
	}
	
}
