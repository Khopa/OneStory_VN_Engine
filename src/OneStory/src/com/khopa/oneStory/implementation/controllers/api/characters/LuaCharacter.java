package com.khopa.oneStory.implementation.controllers.api.characters;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;

import com.khopa.oneStory.implementation.models.characters.Character;

public class LuaCharacter extends LuaTable{
	
	/**
	 * Character model
	 */
	private Character model;
	
	public LuaCharacter(Character character){
		this.model = character;
		this.set("say", new Say(this));
		this.set("appear", new Appear(this));
		this.set("anim", new Anim(this));
	}

	@Override
	public LuaValue tostring() {
		return LuaValue.valueOf(model.getName());
	}
	
	// Lua class methods
	
	public Character getModel() {
		return model;
	}

}

