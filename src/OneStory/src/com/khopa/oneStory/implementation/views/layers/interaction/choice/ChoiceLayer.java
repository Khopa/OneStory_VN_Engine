package com.khopa.oneStory.implementation.views.layers.interaction.choice;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.khopa.oneStory.core.views.layers.UILayer;
import com.khopa.oneStory.services.resources.skin.SkinService;

public class ChoiceLayer extends UILayer {

	/**
	 * Choice Buttons
	 */
	private Table buttons; 
	
	/**
	 * Choosed String
	 */
	private String choosed = "";
	
	/**
	 * Choices
	 */
	private String[] choices;
	
	public ChoiceLayer(float x, float y, float w, float h, String[] choices) {
		super(x, y, w, h);
		this.choices = choices;
		init();
	}

	@Override
	public void init() {
		buttons = new Table(SkinService.getSkin());
		buttons.defaults().space(SkinService.getFontHeight());
		for(String choice : choices){
			TextButton choiceButton = new TextButton(choice, SkinService.getSkin(), "choice");
			choiceButton.addListener(new ChoiceButtonListener(this, choice));
			buttons.add(choiceButton);
			buttons.row();
		}
		buttons.setPosition(this.getWidth()/2-buttons.getWidth()/2, this.getHeight()/2-buttons.getHeight()/2);
	}
	
	@Override
	public void build() {
		this.clearChildren();
		this.addActor(buttons);
	}

	// ------------- Getters --------------- \\
	
	public String getChoosed() {
		return choosed;
	}

	public void setChoosed(String choosed) {
		this.choosed = choosed;
	}

}
