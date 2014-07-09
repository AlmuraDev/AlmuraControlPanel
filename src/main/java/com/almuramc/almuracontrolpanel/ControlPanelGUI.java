/*
 * This file is part of Almura Control Panel.
 *
 * © 2013 AlmuraDev <http://www.almuradev.com/>
 * Almura Control Panel is licensed under the GNU General Public License.
 *
 * Almura Control Panel is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Almura Control Panel is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License. If not,
 * see <http://www.gnu.org/licenses/> for the GNU General Public License.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almuramc.almuracontrolpanel;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;

import com.almuramc.almuracontrolpanel.widgets.*;

public class ControlPanelGUI extends GenericPopup{
	private List<GuiButton> available = new ArrayList<GuiButton>();
	
	public ControlPanelGUI(AlmuraControlPanel instance) {
		
		
		GenericTexture border = new GenericTexture("http://www.almuramc.com/images/controlpanel.png");
		border.setAnchor(WidgetAnchor.CENTER_CENTER);
		border.setPriority(RenderPriority.High);
		border.setWidth(360).setHeight(240);
		border.shiftXPos(-185).shiftYPos(-120);
		
		GenericLabel apps = new GenericLabel("Apps");
		apps.setScale(1.0F);
		apps.setAnchor(WidgetAnchor.CENTER_CENTER);
		apps.setHeight(15).setWidth(GenericLabel.getStringWidth(apps.getText()));
		apps.shiftXPos(-125).shiftYPos(-70);
		
		GenericLabel locs = new GenericLabel("Locations");
		locs.setScale(1.0F);
		locs.setAnchor(WidgetAnchor.CENTER_CENTER);
		locs.setHeight(15).setWidth(GenericLabel.getStringWidth(apps.getText()));
		locs.shiftXPos(-25).shiftYPos(-70);
		
		GenericLabel links = new GenericLabel("Web Links");
		links.setScale(1.0F);
		links.setAnchor(WidgetAnchor.CENTER_CENTER);
		links.setHeight(15).setWidth(GenericLabel.getStringWidth(apps.getText()));
		links.shiftXPos(80).shiftYPos(-70);
		
		CloseButton close = new CloseButton(instance);
		close.setAnchor(WidgetAnchor.CENTER_CENTER);
		close.setHeight(20).setWidth(50);
		close.shiftXPos(-30).shiftYPos(90);		
		
		GoToSpawnButton spawnButton = new GoToSpawnButton(instance);
		spawnButton.setAnchor(WidgetAnchor.CENTER_CENTER);
		spawnButton.setHeight(20).setWidth(80);
		spawnButton.shiftXPos(-45).shiftYPos(-60);
		
		GoToNewbieButton cafeButton = new GoToNewbieButton(instance);
		cafeButton.setAnchor(WidgetAnchor.CENTER_CENTER);
		cafeButton.setHeight(20).setWidth(80);
		cafeButton.shiftXPos(-45).shiftYPos(-35);
		
		GoToCustomButton customButton = new GoToCustomButton(instance);
		customButton.setAnchor(WidgetAnchor.CENTER_CENTER);
		customButton.setHeight(20).setWidth(80);
		customButton.shiftXPos(-45).shiftYPos(-10);
		
		GoToSupergateButton supergateButton = new GoToSupergateButton(instance);
		supergateButton.setAnchor(WidgetAnchor.CENTER_CENTER);
		supergateButton.setHeight(20).setWidth(80);
		supergateButton.shiftXPos(-45).shiftYPos(15);
		
		GoTogateButton gateButton = new GoTogateButton(instance);
		gateButton.setAnchor(WidgetAnchor.CENTER_CENTER);
		gateButton.setHeight(20).setWidth(80);
		gateButton.shiftXPos(-45).shiftYPos(40);
		
		AlmuraMapButton mapButton = new AlmuraMapButton(true);
		mapButton.setAnchor(WidgetAnchor.CENTER_CENTER);
		mapButton.setHeight(20).setWidth(110);
		mapButton.shiftXPos(45).shiftYPos(-60);
		
		AlmuraWebsiteButton websiteButton = new AlmuraWebsiteButton(true);
		websiteButton.setAnchor(WidgetAnchor.CENTER_CENTER);
		websiteButton.setHeight(20).setWidth(110);
		websiteButton.shiftXPos(45).shiftYPos(-35);
		
		AlmuraFAQButton almuraFAQButton = new AlmuraFAQButton(true);
		almuraFAQButton.setAnchor(WidgetAnchor.CENTER_CENTER);
		almuraFAQButton.setHeight(20).setWidth(110);
		almuraFAQButton.shiftXPos(45).shiftYPos(-10);
		
		SpoutWebsiteButton spoutWebsiteButton = new SpoutWebsiteButton(true);
		spoutWebsiteButton.setAnchor(WidgetAnchor.CENTER_CENTER);
		spoutWebsiteButton.setHeight(20).setWidth(110);
		spoutWebsiteButton.shiftXPos(45).shiftYPos(15);
		
		attachWidgets(instance, border, apps, locs, links, close, spawnButton, cafeButton, customButton, supergateButton, gateButton, mapButton, websiteButton, almuraFAQButton, spoutWebsiteButton);
		
		addInfoGuide();
		
		addHelpRequest();
		
		addPlayerPlus();
		
		//addRecipes();
				
		addBackpack();
		
		int top = -60;
		
		for(GuiButton button : available) {
			button.setAnchor(WidgetAnchor.CENTER_CENTER);
			button.shiftXPos(-button.getWidth()/2-140).shiftYPos(top);
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
	
	private void addBackpack() {
		if(Bukkit.getPluginManager().isPluginEnabled("Backpack")) {
			available.add(new BackpackButton());
		}
	}
	
}
