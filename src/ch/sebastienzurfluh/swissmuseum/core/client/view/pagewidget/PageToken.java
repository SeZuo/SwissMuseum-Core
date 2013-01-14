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

/**
 * Immutable token to store page elements.
 *
 *
 * @author Sebastien Zurfluh
 *
 */
public class PageToken {
	private boolean isText = false;
	private boolean isResource = false;
	private ResourceWidget resourceWidget;
	private String text;

	public PageToken(ResourceWidget resourceWidget) {
		setResourceWidget(resourceWidget);
	}
	
	public PageToken(String text) {
		setText(text);
	}

	public boolean isText() {
		return isText;
	}
	
	public boolean isResource() {
		return isResource;
	}
	
	private void setResourceWidget(ResourceWidget resourceWidget) {
		this.resourceWidget = resourceWidget;
		this.isResource = true;
	}
	
	private void setText(String text) {
		this.text = text;
		this.isText = true;
	}

	public ResourceWidget getResourceWidget() {
		return resourceWidget;
	}
	
	public String getText() {
		return text;
	}
}
