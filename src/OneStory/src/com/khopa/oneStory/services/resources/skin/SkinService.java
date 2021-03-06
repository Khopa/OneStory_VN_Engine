package com.khopa.oneStory.services.resources.skin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.khopa.oneStory.services.resources.graphic.controllers.DefinitionService;

public class SkinService {

	protected static Skin skin;
	
	public static void init(){
		skin = new Skin(Gdx.files.internal("data/gfx/"
				                         + DefinitionService.getInstance().getScreenType().toString()
				                         + "/skins/uiskin.json"));
	}
	
	public static Skin getSkin(){
		return skin;
	}; 
	
	public static BitmapFont getFont(){
		return skin.getFont("default-font");
	}
	
	public static float getFontHeight(){
		return getFont().getLineHeight();
	}
	
}
