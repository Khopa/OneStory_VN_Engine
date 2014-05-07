package com.khopa.oneStory.services.resources.graphic.impl;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.khopa.oneStory.services.event.controllers.EventService;
import com.khopa.oneStory.services.resources.ResourceLoadingEvent;
import com.khopa.oneStory.services.resources.graphic.controllers.DefinitionService;
import com.khopa.oneStory.services.resources.graphic.controllers.SpriteSheetService;

public class SpriteSheetLoader extends SpriteSheetService {

	/**
	 * Folders where the sheets are stored
	 */
	protected static String folder;
	
	/**
	 * Extension of the sheets 
	 */
	protected final static String extension = ".pack";
	
	/**
	 * List of available atlas
	 */
	protected HashMap<String, TextureAtlas> atlases;
	
	/**
	 * Initialize the sprite sheet loading and serving service
	 */
	public SpriteSheetLoader(){
		super();
		folder = "data/gfx/" + DefinitionService.getInstance().getScreenType().toString() + "/sheets/";
		atlases = new HashMap<String, TextureAtlas>();
	}
	
	@Override
	public TextureAtlas getSpriteSheet(String name) {
		if(atlases.containsKey(name)){
			return atlases.get(name);
		}
		else{
			return null;
		}
	}

	@Override
	public void disposeSpriteSheet(String name) {
		if(atlases.containsKey(name)){
			TextureAtlas atlas = atlases.get(name);
			atlas.dispose();
			atlases.remove(name);
		}
	}

	@Override
	public TextureAtlas loadSpriteSheet(String sheetName) {
		EventService.getInstance().fire(new ResourceLoadingEvent(sheetName+extension));
		FileHandle file = Gdx.files.internal(folder+sheetName+extension);
		if(file.exists()){
			TextureAtlas newAtlas = new TextureAtlas(file);
			atlases.put(sheetName, newAtlas);
			return newAtlas;
		}
		else{
			System.out.println("Couldn't load " + sheetName+extension);
			return null;
		}
		
	}
	
	
	
	
	

}
