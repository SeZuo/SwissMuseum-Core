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

package ch.sebastienzurfluh.swissmuseum.core.client.model;

import java.util.Collection;

import ch.sebastienzurfluh.swissmuseum.core.client.model.io.IConnector;
import ch.sebastienzurfluh.swissmuseum.core.client.model.structure.Data;
import ch.sebastienzurfluh.swissmuseum.core.client.model.structure.DataReference;
import ch.sebastienzurfluh.swissmuseum.core.client.model.structure.MenuData;
import ch.sebastienzurfluh.swissmuseum.core.client.model.structure.ResourceData;
import ch.sebastienzurfluh.swissmuseum.core.client.patterns.Observable;

/**
 * This class is a wrapper of {@code Model}. It does nothing else than giving a new object with
 * the same model referenced.
 *
 *
 * @author Sebastien Zurfluh
 *
 */
public class ModelWrapper {
	Model model;
	IConnector connector;
	
	/**
	 * @return the wrapped model
	 */
	public Model getModel() {
		return model;
	}
	
	public ModelWrapper(Model model) {
		this.model = model;
		this.connector = model.connector;
		
		allGroupsMenusChangesObservable = model.allGroupsMenusChangesObservable;
		
		currentGroupMenuObservable = model.currentGroupMenuObservable;
		currentPageDataObservable = model.currentPageDataObservable;
		
		previousPageMenuObservable = model.previousPageMenuObservable;
		nextPageMenuObservable = model.nextPageMenuObservable;
		
		allPagesMenusInCurrentGroupObservable =
				model.allPagesMenusInCurrentGroupObservable;
		
		allNeededResourcesObservable = model.allNeededResourcesObservable;
		
	}
	
	public Observable allGroupsMenusChangesObservable;
	
	public Observable currentGroupMenuObservable;
	public Observable currentPageDataObservable;
	
	public Observable previousPageMenuObservable;
	public Observable nextPageMenuObservable;
	
	public Observable allPagesMenusInCurrentGroupObservable;
	
	public Observable allNeededResourcesObservable;
	
	public Observable viewModeObservable;
	
	/**
	 * This function will modify the Model (synching automatically with the base)
	 * depending on the given reference.
	 * 
	 * @param currentReference is the reference of the data to load
	 */
	public void load(final DataReference currentReference) {
		model.load(currentReference);
	}
	

	/**
	 * This function will modify the Model (synching automatically with the base)
	 * depending on the given reference.
	 * 
	 * This will load the new page instead of the current one, and set the next and previous
	 * pages to the last visible one.
	 * This way, the user will go back to the previous page by going next or previous.
	 * Note we are not changing group this way.
	 * 
	 * @param currentReference is the reference of the data to load
	 */
	public void loadForeignPage(DataReference currentReference) {
		model.loadForeignPage(currentReference);
	}
	
	/**
	 * @return all the menus of groups.
	 */
	public Collection<MenuData> getAllGroupMenus() {
		return model.getAllGroupMenus();
	}
	
	/**
	 * @return the current group menu data
	 */
	public MenuData getCurrentGroupMenu() {
		return model.getCurrentGroupMenu();
	}
	
	/**
	 * @return the current page and menu
	 */
	public Data getCurrentPageData() {
		return model.getCurrentPageData();
	}
	
	/**
	 * @return the menu of the previous page.
	 */
	public MenuData getPreviousPageMenu() {
		return model.getPreviousPageMenu();
	}
	
	/**
	 * @return the menu of the next page.
	 */
	public MenuData getNextPageMenu() {
		return model.getNextPageMenu();
	}
	
	/**
	 * @return all the pages of the current group menus.
	 */
	public Collection<MenuData> getAllPageMenusInCurrentGroup() {
		return model.getAllPageMenusInCurrentGroup();
	}

	/**
	 * @return all the resources needed in the current view.
	 */
	public Collection<ResourceData> getAllNeededResources() {
		return model.getAllNeededResources();
	}
}
