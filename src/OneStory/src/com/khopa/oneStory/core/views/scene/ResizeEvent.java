package com.khopa.oneStory.core.views.scene;

import com.khopa.oneStory.services.event.models.Event;

/**
 * 
 * Event fired when the screen is resized
 * 
 * @author Clément Perreau
 *
 */
public class ResizeEvent extends Event {

	/**
	 * New width of the screen
	 */
	private int width;
	
	/**
	 * New height of the screen
	 */
	private int height;
	

	/**
	 * NEw resize event
	 * @param width New width of the screen 
	 * @param height New height of the screen
	 */
	public ResizeEvent(int width, int height){
		setHeight(height);
		setWidth(width);
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
}
