package com.khopa.oneStory.services.resources;

import com.khopa.oneStory.services.event.models.Event;

/**
 * 
 * Event to prevent that a resource is being loaded
 * 
 * @author Clément Perreau
 *
 */
public class ResourceLoadingEvent extends Event {

	/**
	 * Resource name
	 */
	protected String name;
	
	public ResourceLoadingEvent(String resourceName){
		this.name = resourceName;
	}

	public String getName() {
		return name;
	}
	
}
