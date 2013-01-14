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

package ch.sebastienzurfluh.swissmuseum.core.client.patterns;

import java.util.LinkedList;

public class Observable {
	public LinkedList<Observer> observerList = new LinkedList<Observer>();
	
	public void subscribeObserver(Observer observer) {
		observerList.add(observer);
	}
	
	/**
	 * Delayed observer removal (because we don't want any concurrent modification.
	 */
	LinkedList<Observer> removeList = new LinkedList<Observer>();
	
	/**
	 * Note that the removal is not synchronous and will only occur on the next event. This means
	 * that if you remove an observer it may still be notified for the current event.
	 * @param observer that shouldn't be notified anymore
	 */
	public void unsubscribeObserver(Observer observer) {
		removeList.add(observer);
	}
    
    public void notifyObservers() {
    	// Clean the list of observer
    	for (Observer observer : removeList)
    		observerList.remove(observer);
    	
    	for (Observer observer : observerList)
			observer.notifyObserver(this);
    }
}