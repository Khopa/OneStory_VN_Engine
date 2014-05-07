package com.khopa.oneStory.implementation.views.scenes.mainMenu.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class QuitButtonListener extends ClickListener{

	@Override
	public void clicked(InputEvent event, float x, float y) {
		super.clicked(event, x, y);
		Gdx.app.exit();
	}
	
}
