/*
 * Copyright 2012-2013 Sebastien Zurfluh
 * 
 * This file is part of "Parcours".
 * 
 * "Parcours" is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * "Parcours" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with "Parcours".  If not, see <http://www.gnu.org/licenses/>.
 */

package ch.sebastienzurfluh.swissmuseum.core.client.view.pagewidget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

public class ResourceGallery extends PopupPanel implements ClickHandler {
	public ResourceGallery(String string, String titleString, String descriptionString) {
		FlowPanel popup = new FlowPanel();
		
		Image imageClone = new Image();
		imageClone.setStyleName("resourceGallery-image");
		
		setStyleName("resourceGallery");
		
		imageClone.setUrl(string);
		
		setGlassEnabled(true);
		
		popup.add(imageClone);
		
		Label title = new Label(titleString);
		Label details = new Label(descriptionString);
		
		title.setStyleName("resourceGallery-image-title");
		details.setStyleName("resourceGallery-image-details");
		
		popup.add(title);
		popup.add(details);
		
		add(popup);
		
		imageClone.addClickHandler(this);
	}

	@Override
	public void onClick(ClickEvent event) {
		hide();
	}
}
