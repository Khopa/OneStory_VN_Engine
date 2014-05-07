package com.khopa.oneStory.services.event.controllers;

import com.khopa.oneStory.services.event.models.Event;

/**
 * 
 * Event management singleton service
 * 
 * @author Clément Perreau
 *
 */
public abstract class EventService {
	
	/**
	 * Single instance
	 */
	private static EventService singleInstance;

	public EventService(){
		singleInstance = this;
	}
	
	/**
	 * Register the given listeners to be notified the event of the given kind
	 * @param listener Listener to register
	 * @param eventType Type of event we want to be notified about
	 */
	public abstract void register(EventListener listener, Class<? extends Event> eventType);
	
	/**
	 * Unregister the given listeners to be notified the event of the given kind
	 * @param listener Listener to unregister
	 * @param eventType Type of event we no longer want to be notified about
	 */
	public abstract void unregister(EventListener listener, Class<? extends Event> eventType);
	
	/**
	 * Send the event to this manager, so that he can notify all the listeners listening to this type of event
	 * @param event Event to handle
	 * @return If the event has been handled
	 */
	public abstract boolean fire(Event event);

	/**
	 * @return The single instance
	 */
	public static EventService getInstance() {
		return singleInstance;
	}

}
