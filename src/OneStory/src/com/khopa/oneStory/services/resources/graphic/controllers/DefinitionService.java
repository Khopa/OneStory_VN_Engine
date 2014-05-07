package com.khopa.oneStory.services.resources.graphic.controllers;

import com.khopa.oneStory.services.resources.graphic.models.TextureSize;

public abstract class DefinitionService {

	private static DefinitionService instance;
	
	public DefinitionService(){
		instance = this;
	}
	
	public abstract TextureSize getScreenType();
	
	public static DefinitionService getInstance() {
		return instance;
	}
	
}
