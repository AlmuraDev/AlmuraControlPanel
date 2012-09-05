/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.znickq.almuracontrolpanel.widgets;

import net.windwaker.textureme.TextureMe;
import net.windwaker.textureme.gui.Selector;
import org.getspout.spoutapi.player.SpoutPlayer;

/**
 *
 * @author ZNickq
 */
public class TextureMeButton extends GuiButton{
	
	public TextureMeButton() {
		super("Texture Me");
	}

	@Override
	public void openGui(SpoutPlayer who) {
		TextureMe pls = get("TextureMe", TextureMe.class);
		who.getMainScreen().attachPopupScreen(new Selector(pls, who));
	}
	
}
