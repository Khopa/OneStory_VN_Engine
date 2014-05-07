package com.khopa.oneStory.services.resources.graphic.controllers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * 
 * A component to load spritesheet and store them into RAM
 * 
 * @author Clément Perreau
 *
 */
public abstract class SpriteSheetService {
	
	/**
	 * Single instance
	 */
	public static SpriteSheetService instance = null;
	
	/**
	 * Create a Sprite sheet service
	 */
	public SpriteSheetService(){
		instance = this;
	}
	
	/**
	 * Load the given texture sheet
	 */
	public abstract TextureAtlas loadSpriteSheet(String sheetName);
	
	/**
	 * Get a sprite sheet from it's packed image
	 */
	public abstract TextureAtlas getSpriteSheet(String name);
	
	/**
	 * Dispose a SpriteSheet
	 */
	public abstract void disposeSpriteSheet(String name);

	/**
	 * @return The single instance of this service
	 */
	public static SpriteSheetService getInstance() {
		return instance;
	}
	
	
}
