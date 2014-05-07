package com.khopa.oneStory.core.controllers.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

/**
 * 
 * Listener for libgdx sliders
 * 
 * @author Clément Perreau
 *
 */
public abstract class SliderListener extends ChangeListener {

	/**
	 * Target slider
	 */
	public Slider slider;
	
	public SliderListener(Slider target){
		this.slider = target;
	}

	// ------ Getters ------- \\
	
	public Slider getSlider() {
		return slider;
	}

	public void setSlider(Slider slider) {
		this.slider = slider;
	}

}
