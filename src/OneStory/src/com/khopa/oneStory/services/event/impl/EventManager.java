package com.khopa.oneStory.services.event.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.khopa.oneStory.services.event.controllers.EventListener;
import com.khopa.oneStory.services.event.controllers.EventService;
import com.khopa.oneStory.services.event.models.Event;

public class EventManager extends EventService {

	protected HashMap<Class<? extends Event>, List<EventListener>> eventMapping;
	
	public EventManager(){
		super();
		eventMapping = new HashMap<Class<? extends Event>, List<EventListener>>();
	}
	
	@Override
	public boolean fire(Event event) {
		
		Class<? extends Event> type = event.getClass();
		//System.out.println(type);
		
		for(Class<? extends Event> key : eventMapping.keySet()){
			if(key.isAssignableFrom(type)){
				List<EventListener> listeners = eventMapping.get(key);
				for(EventListener listener:listeners){
					if(listener.notify(event)){
						return true;
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public void register(EventListener listener, Class<? extends Event> eventType) {
		if(eventMapping.containsKey(eventType)){
			List<EventListener> listeners = eventMapping.get(eventType);
			listeners.add(listener);
		}
		else{
			List<EventListener> listeners = new ArrayList<EventListener>();
			eventMapping.put(eventType, listeners);
			listeners.add(listener);
		}
	}

	@Override
	public void unregister(EventListener listener, Class<? extends Event> eventType) {
		if(eventMapping.containsKey(eventType)){
			List<EventListener> listeners = eventMapping.get(eventType);
			if(listeners.contains(listener)){
				listeners.remove(listener);
			}
		}
	}

}
