package com.khopa.oneStory.core.views.scene;

public interface SceneInterface {

	/**
	 * Should be called when the window/view is resized
	 * @param width
	 * @param height
	 */
	public void onResize(int width, int height);
	
	/**
	 * Loading ressources should be done here
	 */
	public void load();
	
	/**
	 * Called to dispose ressource
	 */
	public void dispose();
	
	
}
