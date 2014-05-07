package com.khopa.oneStory.implementation.controllers.api.characters;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

import com.khopa.oneStory.implementation.controllers.api.NovelApi;

/**
 * Make the character say something
 */
public class Say extends OneArgFunction{
	
	/**
	 * Name of the person talking
	 */
	private LuaCharacter character;
	
	public Say(LuaCharacter character){
		this.character = character;
	}
	
	@Override
	public LuaValue call(LuaValue name){
		NovelApi.setTalk.call(character.getModel().getName());
		NovelApi.put.call(name.tojstring());
		return null;
	}
}