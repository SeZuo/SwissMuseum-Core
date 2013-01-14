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

package ch.sebastienzurfluh.swissmuseum.core.client.control.eventbus.events;


/**
 * {@code Action}s are fired when the caller wants to interact with the DataBase (write mode).
 *
 *
 * @author Sebastien Zurfluh
 *
 */
public enum Action {
	NONE,
	/**
	 * This action notifies that the caller commands to create new elements with the current data.
	 */
	CREATE,
	/**
	 * Notifies that the caller commands to modify an existing entry with the current data.
	 */
	MODIFY,
	/**
	 * Delete some data from the DB.
	 */
	REMOVE;
	
	/* Things to do or not. 

	 	/**
		 * Saves the modifications for ever (for instance to the DB).
		 * /
		SAVE,
		/**
		 * Discard the visible changes done yet. {@code DISCARD} only discards changes that are not
		 * committed yet.
	 	 * /
		DISCARD,
		/**
		 * Reverts the last committed change to the DB.
		 * / 
		REVERT
	*/
}