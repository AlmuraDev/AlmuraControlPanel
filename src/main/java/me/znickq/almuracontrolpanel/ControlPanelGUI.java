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
		
		
		GenericTexture border = new GenericTexture("http://www.pixentral.com/pics/1duZT49LzMnodP53SIPGIqZ8xdKS.png");
		border.setAnchor(WidgetAnchor.CENTER_CENTER);
		border.setPriority(RenderPriority.High);
		border.setWidth(420).setHeight(345);
		border.shiftXPos(-205).shiftYPos(-120);
		
		CloseButton close = new CloseButton(instance);
		close.setAnchor(WidgetAnchor.CENTER_CENTER);
		close.setHeight(15).setWidth(50);
		close.shiftXPos(150).shiftYPos(95);
		
		attachWidgets(instance, border, close);
		
		
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
