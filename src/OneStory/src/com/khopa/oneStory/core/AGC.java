package com.khopa.oneStory.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.khopa.oneStory.services.resources.graphic.controllers.DefinitionService;

/**
 * 
 * Application Graphics Context
 * 
 * @author Clément Perreau
 *
 */
public abstract class AGC {
	
	private static int BW = 1920;
	private static int BH = 1080;

	private int W = 0;
	private int H = 0;
	
	private static AGC singleInstance;
	
	public AGC(){
		singleInstance = this;
	}
	
	protected void initAGC(){
		Vector2 chosenProjection = DefinitionService.getInstance().getScreenType().bestProjection();
		BW = (int) chosenProjection.x;
		BH = (int) chosenProjection.y;
		setW(Gdx.graphics.getWidth());
		setH(Gdx.graphics.getHeight());
	}
	
	public static int getW() {
		return singleInstance.W;
	}
	public static void setW(int w) {
		singleInstance.W = w;
	}
	public static int getH() {
		return singleInstance.H;
	}
	public static void setH(int h) {
		singleInstance.H = h;
	}

	public static int getBW() {
		return BW;
	}

	public static void setBW(int bW) {
		BW = bW;
	}

	public static int getBH() {
		return BH;
	}

	public static void setBH(int bH) {
		BH = bH;
	}

	public static AGC get() {
		return singleInstance;
	}
	
}
