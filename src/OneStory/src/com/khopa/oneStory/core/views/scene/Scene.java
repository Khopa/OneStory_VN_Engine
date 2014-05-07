package com.khopa.oneStory.core.views.scene;

import java.lang.reflect.Field;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.khopa.oneStory.core.AGC;
import com.khopa.oneStory.services.event.controllers.EventListener;
import com.khopa.oneStory.services.event.models.Event;

public class Scene extends Stage implements EventListener {
	
	/**
	 * Desired width in percent
	 */
	private float w;
	
	/**
	 * Desired height in percent
	 */
	private float h;
	
	/**
	 * Desired x position in percent
	 */
	private float x;
	
	/**
	 * Desired y position in percent
	 */
	private float y;
	
	/**
	 * 
	 * @param x X Position in percent of the screen
	 * @param y Y position in percent of the screen
	 * @param width Width in percent of the screen
	 * @param height Height in percent of the screen
	 */
	public Scene(float x, float y, float w, float h){
		super();
		
		setX(x);
		setY(y);
		setW(w);
		setH(h);
	
		onResize(AGC.getW(), AGC.getH());
		
	}
	
	public Scene(){
		this(-.5f,-.5f,1,1);
	}
	
	public void onResize(int newW, int newH) {

		setViewport(AGC.getBW()/w,
				    AGC.getBH()/h,
				    false,
				    0,
				    0,
				    AGC.getW(),
				    AGC.getH());

		getCamera().position.set(-x*AGC.getBW()/w, -y*AGC.getBH()/h, 0);
		workAround();
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		onResize(0, 0);
	}

	@Override
	public boolean notify(Event event) {
		if(event.getClass() == ResizeEvent.class){
			ResizeEvent rEvent = (ResizeEvent) event;
			this.onResize(rEvent.getWidth(), rEvent.getHeight());
			return false;
		}
		return false;
	}

	public float getH() {
		return h;
	}

	public void setH(float height) {
		this.h = height;
	}

	public float getW() {
		return w;
	}

	public void setW(float width) {
		this.w = width;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public InputProcessor getInputProcessor(){
		return this;
	}

	
	/** F U C K    T H E    P O L I C E    ! ! ! ! !  
	 *  As the setViewport method does shit, and force
	 *  people to have their Stage fit the entire screen, and because
	 *  i wan't the exact opposite, this little hack was totally necessary
	 */
	protected void workAround(){
		try {
			final Field width  = Stage.class.getDeclaredField("width");   // What are you ...
			final Field height = Stage.class.getDeclaredField("height");  // No you can't ..!
			width.setAccessible(true); 								      // O M G !
			height.setAccessible(true); 							      // NOOOOOOO !
			width.set(this, AGC.getBW()); 							      // :o
			height.set(this, AGC.getBH()); 						          // Come back here you cheater !!!
			// He, He, Sorry :D
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
}
