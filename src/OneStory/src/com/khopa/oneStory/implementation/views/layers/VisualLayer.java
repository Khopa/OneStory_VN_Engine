package com.khopa.oneStory.implementation.views.layers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.khopa.oneStory.core.controllers.animation.transition.TextZoneWriting;
import com.khopa.oneStory.core.controllers.animation.transition.Transitions;
import com.khopa.oneStory.core.views.layers.BackgroundLayer;
import com.khopa.oneStory.core.views.widgets.TextZone;
import com.khopa.oneStory.services.resources.skin.SkinService;

public class VisualLayer extends BackgroundLayer{

	private TextZone overlayer;
	
	public VisualLayer(float x, float y, float width, float height,
			String bgName) {
		super(x, y, width, height, bgName);
	}
	
	
	/**
	 * Display a textzone on the visual layer
	 */
	public void setTextOverlay(String text){
		
		for(Actor actor:this.getChildren()){
			actor.addAction(Transitions.fadeToBlack(0.5f));
		}
		overlayer = new TextZone(text, SkinService.getSkin(), new Vector2(.8f * this.getWidth(), .8f*this.getHeight()));
		overlayer.addAction(new TextZoneWriting(overlayer, 0.01f, new Vector2(0.1f*getWidth(), getHeight()*0.9f)));
		this.addActor(overlayer);
	}
	
	
	public void removeTextOverlay(){
		
		for(Actor actor:this.getChildren()){
			actor.addAction(Actions.color(Color.WHITE, .5f));
		}
		overlayer.clearActions();
		overlayer.addAction(Actions.sequence(Transitions.fadeOut(0.1f), Actions.removeActor()));
	}

}
