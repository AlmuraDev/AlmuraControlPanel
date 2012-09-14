/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel.widgets;

import com.almuramc.helprequest.HelpRequest;
import com.almuramc.helprequest.MainGUI;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author ZNickq
 */
public class HelpRequestButton extends GuiButton{
	
	public HelpRequestButton() {
		super("Help Request", "helprequest.use");
	}

	@Override
	public void openGui(SpoutPlayer who) {
		HelpRequest pls = get("HelpRequest", HelpRequest.class);
		who.getMainScreen().attachPopupScreen(new MainGUI(pls, who));
	}
	
}
