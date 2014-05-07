package com.khopa.oneStory.services.resources.graphic.models;

import com.badlogic.gdx.math.Vector2;

public enum TextureSize {
	LOW,
	MEDIUM,
	HIGH;
	
	public String toString(){
		switch(this){
			case LOW:
				return "ld";
			case MEDIUM:
				return "md";
			case HIGH:
				return "hd";
			default:
				break;
		}
		return "ld";
	}
	
	public Vector2 bestProjection(){
		switch(this){
			case LOW:       // 512
				return new Vector2(275, 500);
			case MEDIUM:    // 1024
				return new Vector2(550, 1000);
			case HIGH:      // 2048
				return new Vector2(1100, 2000);
			default:
				return new Vector2(480, 320);
		}
	}
	
}
