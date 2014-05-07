package com.khopa.oneStory.implementation.views.scenes.mainMenu;

import com.khopa.oneStory.core.views.layers.BackgroundLayer;
import com.khopa.oneStory.core.views.scene.Scene;
import com.khopa.oneStory.services.resources.sound.MusicService;

public class MenuScene extends Scene {

	/**
	 * Main menu layer
	 */
	private MainMenuLayer layer;
	
	/**
	 * Title
	 */
	private BackgroundLayer title;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public MenuScene() {
		super(-.5f,-.5f,1,1);
		layer = new MainMenuLayer(0, 0, 1f, .5f, "menuBot");
		title = new BackgroundLayer(0, .5f, 1f, .5f, "mainMenu");
		this.addActor(layer);
		this.addActor(title);
	}

}
