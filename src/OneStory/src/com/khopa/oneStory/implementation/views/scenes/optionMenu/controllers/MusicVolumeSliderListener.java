package com.khopa.oneStory.implementation.views.scenes.optionMenu.controllers;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.khopa.oneStory.core.controllers.ui.SliderListener;
import com.khopa.oneStory.services.configuration.controllers.ConfigurationService;
import com.khopa.oneStory.services.resources.sound.MusicService;

/**
 * 
 * Controller for the slider in the option menu
 * 
 * @author Clément Perreau
 *
 */
public class MusicVolumeSliderListener extends SliderListener{

	public MusicVolumeSliderListener(Slider target) {
		super(target);
	}

	@Override
	public void changed(ChangeEvent event, Actor actor) {
		float value = slider.getValue();
		MusicService.setVolume(value);
		ConfigurationService.getInstance().setValue("musicVolume", value);
	}

}
