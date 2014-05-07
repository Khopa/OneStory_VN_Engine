package com.khopa.oneStory.implementation.models.characters;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.khopa.oneStory.services.resources.graphic.controllers.SpriteSheetService;

public class Animation {
  
  /**
   * List of textures
   */
  private List<TextureRegion> textures = new ArrayList<TextureRegion>();

/**
   * Width of the texture (NB : all the frame texture should have the same width)
   */
  private int width;
  
  /**
   * Height of the texture (NB : all the frame texture should have the same width)
   */
  private int height;
  
  /**
   * Number of images per second
   */
  private int framerate = 12;
  
  /**
   * Number of time the animation should be repeated
   * A negative value mean infinite repetition
   */
  private int repeat = 0;
  
  
  public Animation(Character character, String name, int repeat, int framerate){
    TextureAtlas atlas = SpriteSheetService.getInstance().getSpriteSheet(character.getName().toLowerCase() + "_" + name);
    for(TextureRegion texture:atlas.getRegions()){
      this.getTextures().add(texture); 
      this.width  = texture.getRegionWidth();
      this.height = texture.getRegionHeight();
    }
    this.framerate = framerate;
    this.repeat = repeat;
  }
  
  public Animation(Character character, String name, int repeat){
	  this(character, name, repeat, 12);
  }
  
  /**
   * Get the time between two frames
   */
  public float deltaFrame(){
	  return 1f/framerate;
  }
  
  /**
   * Number of frames
   */
  public int length(){
	  return getTextures().size();
  }
  
  /**
   * Estimated duration of the whole animation in seconds
   */
  public float duration(){
	  return deltaFrame() * length();
  }

  public int getRepeat() {
	return repeat;
  }
  
  
  public int getHeight() {
	return height;
  }
  
  
  public int getFramerate() {
	return framerate;
  }

  public List<TextureRegion> getTextures() {
	return textures;
  }

  public void setTextures(List<TextureRegion> textures) {
	this.textures = textures;
  }

  public int getWidth() {
	return width;
  }

}