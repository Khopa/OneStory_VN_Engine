package com.khopa.oneStory;

import java.util.concurrent.Semaphore;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.khopa.oneStory.core.AGC;
import com.khopa.oneStory.core.interfaces.Loader;
import com.khopa.oneStory.core.views.Primitives;
import com.khopa.oneStory.core.views.scene.ResizeEvent;
import com.khopa.oneStory.core.views.scene.Scene;
import com.khopa.oneStory.implementation.views.scenes.mainMenu.MenuScene;
import com.khopa.oneStory.services.configuration.controllers.ConfigurationService;
import com.khopa.oneStory.services.event.impl.EventManager;

public class OneStoryEngine extends AGC implements ApplicationListener {
	
	/**
	 * Current stage
	 */
	private Scene currentScene;
	
	/**
	 * Elapsed time
	 */
	private static float elapsedTime;
	
	/**
	 * Instance
	 */
	private static OneStoryEngine instance;
	
	/**
	 * Draw synchro
	 */
	public final static Semaphore drawSync = new Semaphore(1);
	
	public OneStoryEngine(){
		super();
	}
	
	@Override
	public void create() {	
		
		OneStoryEngine.instance = this;
		Gdx.input.setCatchBackKey(true);
		
		new OneStoryLoader();
		Loader.getInstance().initializeServices();
		initAGC();
		Loader.getInstance().loadResources();
		Primitives.init();
		
		Scene scene = new MenuScene();
		setScene(scene);
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {	
		
		boolean debug = ConfigurationService.getInstance().getBooleanValue("debug");
		
		try {
			drawSync.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
        if(currentScene != null){
        	try{
        		currentScene.act();
        	}
        	catch(Exception e){
        		e.printStackTrace();
        	}
        	try{
        		currentScene.draw();
        		if(debug) Table.drawDebug(currentScene);
        	} catch(Exception e){
        		System.out.println("DRAWING ERROR");
        		e.printStackTrace();
        		try{
        			currentScene.getSpriteBatch().end();
        		}
        		catch(Exception e2){
        			e2.printStackTrace();
        			System.out.println("SERIOUS DRAWING ERROR");
        		}
        		//System.exit(0);
        	}
        	
        }
        
		elapsedTime+=(Gdx.graphics.getDeltaTime());
		drawSync.release();
	}

	@Override
	public void resize(int w, int h) {
		setW(w);
		setH(h);
		EventManager.getInstance().fire(new ResizeEvent(w, h));
	}

	public void setScene(Scene scene){
		this.currentScene = scene;
		Gdx.input.setInputProcessor(scene.getInputProcessor());
	}
	
	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	public static float getElapsedTime() {
		return elapsedTime;
	}

	public static OneStoryEngine getInstance() {
		return instance;
	}

	public Scene getCurrentScene() {
		return currentScene;
	}
}
