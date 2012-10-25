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