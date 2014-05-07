package com.khopa.oneStory.implementation.views.layers.interaction.choice;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.khopa.oneStory.implementation.models.Sequence;

public class ChoiceButtonListener extends ClickListener {

	/**
	 * Choice layer
	 */
	private ChoiceLayer layer;
	
	/**
	 * Name of the choice
	 */
	private String choice;
	
	public ChoiceButtonListener(ChoiceLayer layer, String choice){
		this.layer = layer;
		this.choice = choice;
	}
	
	@Override
	public void clicked(InputEvent event, float x, float y) {
		super.clicked(event, x, y);
		this.layer.setChoosed(choice);
		Sequence.getScriptSync().release();
	}
	
	
}
