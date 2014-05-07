package com.khopa.oneStory.implementation.models.characters;

import java.io.IOException;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import com.khopa.oneStory.implementation.views.actors.CharacterActor;
import com.khopa.oneStory.services.resources.graphic.controllers.SpriteSheetService;

public class Character {
	
	/**
	 * List of known characters
	 */
	private static HashMap<String, Character> characters = new HashMap<String, Character>();
	
	/**
	 * List of available animation
	 */
	private HashMap<String, Animation> animations;
	
	/**
	 * View Model
	 */
	private CharacterActor view;
	
	/**
	 * Name
	 */
	private String name;
	
	private Character(String name){
		this.name = name;
	}
	
	
	public static Character create(String name){
		
		if(characters.containsKey(name)){
	      return characters.get(name);
	    }
	    
	    Character character = new Character(name);
	    character.animations = new HashMap<String, Animation>();
	    
	    Animation anim1 = new Animation(character, "normal",0);
	    Animation anim2 = new Animation(character, "normal_speak",3);
	    Animation anim3 = new Animation(character, "think_speak",3);
	    Animation anim4 = new Animation(character, "curious_speak",3);
	    Animation anim5 = new Animation(character, "angry",3);
	    Animation anim6 = new Animation(character, "happy",3);
	    Animation anim7 = new Animation(character, "shocked",3);
		
		character.animations.put("normal", anim1);
		character.animations.put("normal_speak", anim2);
		character.animations.put("think_speak", anim3);
		character.animations.put("curious_speak", anim4);
		character.animations.put("angry", anim5);
		character.animations.put("happy", anim6);
		character.animations.put("shocked", anim7);
		
	    // Create the view
	    character.view = new CharacterActor(0,0,anim2);
	    
	    characters.put(name, character);
	    
	    return character;
	}
	
	/**
	 * Load characters and their animations
	 */
	public static void loadCharacters(){
		
		XmlReader reader = new XmlReader();
		FileHandle charactersFile = Gdx.files.internal("data/resources/characters.xml");
		SpriteSheetService loader = SpriteSheetService.getInstance();
		
		try {
			Element charactersElement = reader.parse(charactersFile);
			for(Element characterElement : charactersElement.getChildrenByName("character")){
				Character character = new Character(characterElement.get("name"));
			    character.animations = new HashMap<String, Animation>();
			    for(Element animationElement : characterElement.getChildrenByName("animation")){
			    	loader.loadSpriteSheet(character.name + "_" + animationElement.getText());
			    	
			    	int framerate = Integer.valueOf(animationElement.getAttribute("framerate", "60"));
			    	
			    	Animation animation = new Animation(character, animationElement.getText(),0,framerate);
			    	System.out.println(animationElement.getText());
			    	character.animations.put(animationElement.getText(), animation);
			    	if(character.view == null) character.view = new CharacterActor(0,0,animation);
			    }
			    characters.put(character.getName(), character);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public Animation getAnimation(String key){
		System.out.println(key);
		for(String a:animations.keySet()){
			System.out.println(a);
		}
		return animations.get(key);
	}


	public String getName() {
		return name;
	}


	public static HashMap<String, Character> getCharacters() {
		return characters;
	}


	public HashMap<String, Animation> getAnimations() {
		return animations;
	}


	public CharacterActor getView() {
		return view;
	}
	

  
}

