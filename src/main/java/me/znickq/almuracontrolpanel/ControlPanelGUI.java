/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.znickq.almuracontrolpanel;

import java.util.ArrayList;
import java.util.List;
import me.znickq.almuracontrolpanel.widgets.*;
import org.bukkit.Bukkit;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;

/**
 *
 * @author ZNickq
 */
public class ControlPanelGUI extends GenericPopup{
	private List<GuiButton> available = new ArrayList<GuiButton>();
	
	public ControlPanelGUI(AlmuraControlPanel instance) {
		
		
		GenericTexture border = new GenericTexture("http://www.almuramc.com/images/controlpanel.png");
		border.setAnchor(WidgetAnchor.CENTER_CENTER);
		border.setPriority(RenderPriority.High);
		border.setWidth(190).setHeight(240);
		border.shiftXPos(-90).shiftYPos(-120);
		
		GenericLabel gl = new GenericLabel("Almura Control Panel");
		gl.setScale(1.2F);
		gl.setAnchor(WidgetAnchor.CENTER_CENTER);
		gl.setHeight(15).setWidth(GenericLabel.getStringWidth(gl.getText()));
		gl.shiftXPos(-85).shiftYPos(-70);
		
		CloseButton close = new CloseButton(instance);
		close.setAnchor(WidgetAnchor.CENTER_CENTER);
		close.setHeight(20).setWidth(50);
		close.shiftXPos(-15).shiftYPos(90);
		attachWidgets(instance, border, close);
		
		
		addInfoGuide();
		
		addHelpRequest();
		
		addMailerMan();
		
		addPlayerPlus();
		
		addTextureMe();
		
		addBackpack();
		
		int top = -70;
		
		for(GuiButton button : available) {
			button.setAnchor(WidgetAnchor.CENTER_CENTER);
			button.shiftXPos(-button.getWidth()/2-20).shiftYPos(top);
			button.setHeight(20).setWidth(110);
			attachWidget(instance, button);
			top+=25;		
		}
		
	}
	
	private void addPlayerPlus() {
		if(Bukkit.getPluginManager().isPluginEnabled("PlayerPlus")) {
			available.add(new PlayerPlusButton());
		}
	}
	
	private void addHelpRequest() {
		if(Bukkit.getPluginManager().isPluginEnabled("HelpRequest")) {
			available.add(new HelpRequestButton());
		}
	}
	
	private void addInfoGuide() {
		if(Bukkit.getPluginManager().isPluginEnabled("InfoGuide")) {
			available.add(new InfoGuideButton());
		}
	}
	
	private void addMailerMan() {
		if(Bukkit.getPluginManager().isPluginEnabled("MailerMan")) {
			available.add(new MailerManButton());
		}
	}
	
	private void addTextureMe() {
		if(Bukkit.getPluginManager().isPluginEnabled("TextureMe")) {
			available.add(new TextureMeButton());
		}
	}
	
	private void addBackpack() {
		if(Bukkit.getPluginManager().isPluginEnabled("Backpack")) {
			available.add(new BackpackButton());
		}
	}
	
}
