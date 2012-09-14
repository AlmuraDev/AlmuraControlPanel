/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.znickq.almuracontrolpanel.widgets;

import com.almuramc.mailerman.MailerMan;
import com.almuramc.mailerman.MainGUI;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author ZNickq
 */
public class MailerManButton extends GuiButton{
	
	public MailerManButton() {
		super("Almura Email");
	}

	@Override
	public void openGui(SpoutPlayer who) {
		MailerMan pls = get("MailerMan", MailerMan.class);
		who.getMainScreen().attachPopupScreen(new MainGUI(pls, who));
	}
	
}
