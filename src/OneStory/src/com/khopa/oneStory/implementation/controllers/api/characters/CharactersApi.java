package com.khopa.oneStory.implementation.controllers.api.characters;



import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

import com.khopa.oneStory.implementation.models.characters.Character;


/**
 * Visual Novel Characters Manipulation Script API
 * for OneStoryEngine
 * @author Clément Perreau
 */
public class CharactersApi extends TwoArgFunction {


	@Override
	public LuaValue call(LuaValue modname, LuaValue env) {
		LuaValue library = tableOf();
		library.set("create", new create());
		env.set("characters", library);
		return library;
	}
	

	/**
	 * Create a character
	 */
	public static class create extends OneArgFunction{
		@Override
		public LuaValue call(LuaValue name){
			return new LuaCharacter(Character.create(name.tojstring()));
		}
	}
	
}
