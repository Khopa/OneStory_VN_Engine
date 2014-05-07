package com.khopa.oneStory.core.views.scene;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MultiScene extends Scene {

	private List<Scene> scenes;
	
	InputMultiplexer multiplexer;
	
	public MultiScene(float x, float y, float w, float h){
		super(x,y,w,h);
		this.scenes = new ArrayList<Scene>();
		multiplexer = new InputMultiplexer(this);
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		for(Stage scene : scenes){
			scene.act(delta);
		}
	}
	
	@Override
	public void draw() {
		super.draw();
		for(Scene scene : scenes){
			scene.draw();
		}
	}
	
	public void addScene(Scene scene){
		this.scenes.add(scene);
		multiplexer.addProcessor(scene);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		for(Scene scene : scenes){
			scene.dispose();
		}
	}
	
	@Override
	public InputProcessor getInputProcessor() {
		return multiplexer;
	}
	
}
