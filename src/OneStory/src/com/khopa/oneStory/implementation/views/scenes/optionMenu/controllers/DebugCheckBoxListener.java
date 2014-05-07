package com.khopa.oneStory.implementation.views.scenes.optionMenu.controllers;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.khopa.oneStory.services.configuration.controllers.ConfigurationService;

public class DebugCheckBoxListener extends ChangeListener {

	@Override
	public void changed(ChangeEvent event, Actor actor) {
		CheckBox checkbox = (CheckBox) actor;
		ConfigurationService.getInstance().setValue("debug", checkbox.isChecked());
	}

}
