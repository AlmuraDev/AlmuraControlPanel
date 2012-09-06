/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.znickq.almuracontrolpanel;

import java.util.ArrayList;
import java.util.List;
import me.znickq.almuracontrolpanel.widgets.*;
import org.bukkit.Bukkit;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.WidgetAnchor;

/**
 *
 * @author ZNickq
 */
public class ControlPanelGUI extends GenericPopup{
	private List<GuiButton> available = new ArrayList<GuiButton>();
	
	public ControlPanelGUI(AlmuraControlPanel instance) {
		
		
		addHelpRequest();
		
		addInfoGuide();
		
		addMailerMan();
		
		addPlayerPlus();
		
		addTextureMe();
		
		addBackpack();
		
		int top = -90;
		int xC = -150;
		
		for(GuiButton button : available) {
			button.setAnchor(WidgetAnchor.CENTER_CENTER);
			button.shiftXPos(xC).shiftYPos(top);
			button.setHeight(20).setWidth(70);
			attachWidget(instance, button);
			top+=35;
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
		if(Bukkit.getPluginManager().isPluginEnabled("Textureme")) {
			available.add(new TextureMeButton());
		}
	}
	
	private void addBackpack() {
		if(Bukkit.getPluginManager().isPluginEnabled("Backpack")) {
			available.add(new BackpackButton());
		}
	}
	
}
