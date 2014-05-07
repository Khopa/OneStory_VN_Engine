package com.khopa.oneStory.core.controllers.camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class CameraController extends Actor{
	
	private Camera camera;
	
	public CameraController(Camera camera) {
		this.camera = camera;
	}
	
	@Override
	public void act(float delta) {
		
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			camera.position.x += 500*delta;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			camera.position.x -= 500*delta;
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			camera.position.y -= 500*delta;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			camera.position.y += 500*delta;
		}
		
		super.act(delta);
	}
	
	
}
