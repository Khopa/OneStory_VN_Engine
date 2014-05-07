package com.khopa.oneStory.services.event.controllers;

import com.khopa.oneStory.services.event.models.Event;

public interface EventListener {
	
	/**
	 * Get a notification that an event occured
	 * @param event Event to listen to
	 * @return If the event can be considered has handled
	 */
	public abstract boolean notify(Event event);
	
}
