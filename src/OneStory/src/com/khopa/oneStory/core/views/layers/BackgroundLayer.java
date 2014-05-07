package com.khopa.oneStory.core.views.layers;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.khopa.oneStory.core.views.actors.SpriteActor;
import com.khopa.oneStory.services.resources.graphic.impl.SpriteSheetLoader;

public class BackgroundLayer extends SizedLayer {

	/**
	 * Background image actor
	 */
	private Actor background;
	
	public BackgroundLayer(float x, float y, float width, float height, String bgName) {
		super(x,y,width, height);
		background = new SpriteActor(SpriteSheetLoader.getInstance().getSpriteSheet("backgrounds").findRegion(bgName));
		this.addActor(background);
	}
	
	public Actor getBackground() {
		return background;
	}
	
}
