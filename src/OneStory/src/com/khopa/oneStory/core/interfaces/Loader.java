package com.khopa.oneStory.core.interfaces;

public abstract class Loader {

	protected static Loader singleInstance;
	
	public Loader(){
		singleInstance = this;
	}
	
	public abstract void initializeServices();
	
	public abstract void loadResources();

	public static Loader getInstance() {
		return singleInstance;
	}
	
}
