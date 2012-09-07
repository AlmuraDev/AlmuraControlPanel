/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.znickq.almuracontrolpanel.widgets;

import net.dockter.infoguide.GuideListener;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author ZNickq
 */
public class InfoGuideButton extends GuiButton{
	
	public InfoGuideButton() {
		super("Info Guide");
	}

	@Override
	public void openGui(SpoutPlayer who) {
		GuideListener.openInfoGuide(who);
	}
	
}
