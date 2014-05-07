package com.khopa.oneStory.implementation.views.scenes.optionMenu.controllers;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.khopa.oneStory.core.controllers.animation.transition.scenes.SlideOutSlideInTransition;
import com.khopa.oneStory.implementation.views.scenes.mainMenu.MenuScene;
import com.khopa.oneStory.services.configuration.controllers.ConfigurationService;

/**
 * 
 * Listener for the options menu ok button
 * 
 * @author Clément Perreau
 *
 */
public class OkButtonListener extends ClickListener{

	@Override
	public void clicked(InputEvent event, float x, float y) {
		super.clicked(event, x, y);
		ConfigurationService.getInstance().save();
		new SlideOutSlideInTransition(new MenuScene(), 0.5f, SlideOutSlideInTransition.LEFT);
	}
	
}
