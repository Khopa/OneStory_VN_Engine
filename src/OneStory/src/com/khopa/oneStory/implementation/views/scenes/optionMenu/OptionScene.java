package com.khopa.oneStory.implementation.views.scenes.optionMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.khopa.oneStory.core.controllers.animation.transition.scenes.SlideOutSlideInTransition;
import com.khopa.oneStory.core.views.scene.Scene;
import com.khopa.oneStory.implementation.views.scenes.mainMenu.MenuScene;

public class OptionScene extends Scene{

	/**
	 * Option menu Layer
	 */
	private OptionLayer layer;
	
	/**
	 * Create option scene
	 */
	public OptionScene(){
		super();
		layer = new OptionLayer(0, 0, 1, 1, "option");
		this.addActor(layer);
	}
	
	
	@Override
	public void act() {
		super.act();
		if (Gdx.input.isKeyPressed(Keys.BACK)){ 
			new SlideOutSlideInTransition(new MenuScene(), 0.5f, SlideOutSlideInTransition.LEFT);
		}
	}
	
}
