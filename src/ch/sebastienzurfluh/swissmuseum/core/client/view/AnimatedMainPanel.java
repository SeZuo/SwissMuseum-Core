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

package ch.sebastienzurfluh.swissmuseum.core.client.view;

import com.google.gwt.user.client.ui.Panel;

import ch.sebastienzurfluh.swissmuseum.core.client.control.eventbus.events.DataType;
import ch.sebastienzurfluh.swissmuseum.core.client.model.Model;
import ch.sebastienzurfluh.swissmuseum.core.client.model.structure.Data;
import ch.sebastienzurfluh.swissmuseum.core.client.patterns.Observable;
import ch.sebastienzurfluh.swissmuseum.core.client.patterns.Observer;
import ch.sebastienzurfluh.swissmuseum.core.client.view.supportwidgets.SlidingPanel;

public class AnimatedMainPanel extends SlidingPanel implements Observer {
	private Model model;

	public AnimatedMainPanel(
			Model model,
			Panel groupPanel,
			Panel pagePanel) {
		super(model);
		
		this.model = model;
		
		addPanel(groupPanel);
		addPanel(pagePanel);
		
		model.currentPageDataObservable.subscribeObserver(this);
	}
	
	@Override
	public void addPanel(Panel panel) {
		super.addPanel(panel);
		
		panel.setStyleName("animatedPanelView");
	};
	
	private DataType currentView = DataType.NONE;
	@Override
	public void notifyObserver(Observable source) {
		System.out.println("AnimatedMainPanel: notified of page change");
		if (model.getCurrentPageData().equals(Data.NONE)) {
			System.out.println("The new page is not null.");
			// There is no page, we want the group menu.
			if (model.getCurrentPageData().getReference().getType().equals(currentView))
				return;
			currentView = model.getCurrentPageData().getReference().getType();
			moveToPreviousPanel();
		} else {
			// A page exists! We want the page view.
			if (model.getCurrentPageData().getReference().getType().equals(currentView))
				return;
			currentView = model.getCurrentPageData().getReference().getType();
			moveToNextPanel();
		}
	}

}
