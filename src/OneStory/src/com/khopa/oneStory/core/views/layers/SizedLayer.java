package com.khopa.oneStory.core.views.layers;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.khopa.oneStory.core.AGC;

/**
 * Layer with a size and a position
 * @author Clément Perreau
 */
public class SizedLayer extends Group {

	private float xPercent;
	private float yPercent;
	private float wPercent;
	private float hPercent;
	
	/**
	 * Create a sized layer
	 * @param x X position in % of the screen
	 * @param y Y position in % of the screen
	 * @param w Width in percent of the screen
	 * @param h Height in percent of the screen
	 */
	public SizedLayer(float x, float y, float w, float h){
		this.setPosition(x*AGC.getBW(), y*AGC.getBH());
		this.setWidth(w*AGC.getBW());
		this.setHeight(h*AGC.getBH());
		this.xPercent = x;
		this.yPercent = y;
		this.wPercent = w;
		this.hPercent = h;
	}

	// ----------- Getters ------------ \\
	
	public float getxPercent() {
		return xPercent;
	}

	public float getyPercent() {
		return yPercent;
	}

	public float getwPercent() {
		return wPercent;
	}

	public float gethPercent() {
		return hPercent;
	}
	
	public void center(Actor actor){
		actor.setPosition(getWidth()/2-actor.getWidth()/2, getHeight()/2-actor.getHeight()/2);
	}
	
	public void centerAt(Actor actor, float f, float g){
		actor.setPosition(f*getWidth()-actor.getWidth()/2, g*getHeight()/2-actor.getHeight()/2);
	}
	
	
	
	
	
}
