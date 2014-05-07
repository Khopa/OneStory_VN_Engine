package com.khopa.oneStory.services.logger;

import com.khopa.oneStory.services.event.controllers.EventListener;
import com.khopa.oneStory.services.event.controllers.EventService;
import com.khopa.oneStory.services.event.models.Event;
import com.khopa.oneStory.services.resources.ResourceLoadingEvent;

public class Logger implements EventListener{

	public Logger(){
		EventService.getInstance().register(this, ResourceLoadingEvent.class);
	}

	@Override
	public boolean notify(Event event) {
		if(event.getClass().equals(ResourceLoadingEvent.class)){
			System.out.println("Resource loaded : " + ((ResourceLoadingEvent) event).getName());
		}
		return false;
	}
	
	
}
