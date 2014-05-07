package com.khopa.oneStory.implementation.views.actors;

import java.util.concurrent.Semaphore;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.khopa.oneStory.implementation.models.characters.Animation;

public class CharacterActor extends Actor {
	
	/**
	 * Current animation
	 */
	private Animation animation;
	
	/**
	* Current delta time
	*/
	private float delta;
	
	/**
	 * Current animation Frame
	 */
	private int currentFrame;
	
	/**
	 * Animation repeat
	 */
	private int repeat;
	
	/**
	 * Synchronization with script thread for change to the current animation
	 */
	private Semaphore animationAcess = new Semaphore(1);
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param animation
	 */
	public CharacterActor(int x, int y, Animation animation){
	    this.setPosition(x, y);
	    this.setAnimation(animation);
    }
	
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		delta+=Gdx.graphics.getDeltaTime();
		try {
			animationAcess.acquire();
			if(delta > animation.deltaFrame() && repeat > 0){
			  delta = 0;
		      if(currentFrame < animation.length()-1){
		        currentFrame += 1;
		      }
		      else{
		        if(repeat > 0){
		          repeat -= 1;
		          currentFrame = 0;
		        }
		        else if(repeat == 0){
		          currentFrame = 0;
		        }
		      }
		    }
			Color color = batch.getColor();
			Color current = this.getColor();
			batch.setColor(current.r, current.g, current.b, current.a*parentAlpha);
			batch.draw(animation.getTextures().get(currentFrame), getX(), getY(), 0, 0, getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
			batch.setColor(color);
			animationAcess.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	};

	
	public void setAnimation(Animation animation){
		try {
			animationAcess.acquire();
			this.animation = animation;
			this.setWidth(animation.getWidth());
		    this.setHeight(animation.getHeight());
			this.repeat = animation.getRepeat();
			this.currentFrame = 0;
			animationAcess.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}
  
}