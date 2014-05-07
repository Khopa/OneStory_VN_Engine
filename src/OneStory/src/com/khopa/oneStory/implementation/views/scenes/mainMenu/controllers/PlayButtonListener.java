package com.khopa.oneStory.implementation.views.scenes.mainMenu.controllers;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.khopa.oneStory.core.controllers.animation.transition.scenes.FadeOutFadeInSceneTransition;
import com.khopa.oneStory.implementation.views.scenes.NovelScene;

public class PlayButtonListener extends ClickListener {

	@Override
	public void clicked(InputEvent event, float x, float y) {
		super.clicked(event, x, y);
		new FadeOutFadeInSceneTransition(new NovelScene(), 1.5f);
	}
	
}
