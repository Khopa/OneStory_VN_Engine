package com.khopa.oneStory.implementation.views.scenes.mainMenu.controllers;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.khopa.oneStory.core.controllers.animation.transition.scenes.SlideOutSlideInTransition;
import com.khopa.oneStory.implementation.views.scenes.optionMenu.OptionScene;

/**
 * 
 * Option button
 * 
 * @author Clément Perreau
 *
 */
public class OptionButtonListener extends ClickListener{

	@Override
	public void clicked(InputEvent event, float x, float y) {
		super.clicked(event, x, y);
		new SlideOutSlideInTransition(new OptionScene(), 0.5f, SlideOutSlideInTransition.RIGHT);
	}
	
}
