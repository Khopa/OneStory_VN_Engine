package com.khopa.oneStory.implementation.views.scenes.optionMenu.controllers;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.khopa.oneStory.core.controllers.ui.SliderListener;
import com.khopa.oneStory.services.configuration.controllers.ConfigurationService;
import com.khopa.oneStory.services.resources.sound.SoundService;

/**
 * 
 * Listener for the options menu sfx volume control slider
 * 
 * @author Clément Perreau
 *
 */
public class SoundVolumeSliderListener extends SliderListener {

	public SoundVolumeSliderListener(Slider target) {
		super(target);
	}

	@Override
	public void changed(ChangeEvent event, Actor actor) {
		float value = slider.getValue();
		SoundService.setVolume(value);
		ConfigurationService.getInstance().setValue("sfxVolume", value);
	}

}
