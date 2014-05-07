package com.khopa.oneStory.core.controllers.scripts;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.luaj.vm2.LuaClosure;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.compiler.LuaC;
import org.luaj.vm2.lib.jse.JsePlatform;
import org.luaj.vm2.lib.jme.JmePlatform; 

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.khopa.oneStory.services.levels.LevelService;

/**
 * Lua Script with Luaj
 * @author Clément Perreau
 */
public class LuaScript {
	
	/**
	 * Compiled LUA code
	 */
	protected Prototype luaCode;
	
	/**
	 * Lua Context
	 */
	protected LuaValue context;
	
	/**
	 * Script filename
	 */
	protected String scriptName;
	
	/**
	 * Crée un nouveau script Lua à partir du fichier spécifié
	 * @param filename Nom du script LUA
	 * @param internal Fichier interne ou non 
	 */
	public LuaScript(String script, String[] required){
		
		this.scriptName = script;
		
		/**
		 * Lua context creation (platform dependant)
		 */
		ApplicationType platform = Gdx.app.getType();
		if(platform == ApplicationType.Android || platform == ApplicationType.iOS){
			// Luaj for Java Mobile Edition 
			context = JmePlatform.standardGlobals();
		}
		else{
			// Luaj for Java Standard Edition
			context = JsePlatform.standardGlobals();
		}
		
		try {
			
			FileHandle scriptFile;
			scriptFile = Gdx.files.internal(LevelService.getPath() + "/" + scriptName);
			
			/**
			 * Required libraries
			 */
			for(String lib:required){
				String line = "require \""+lib+"\"";
				Prototype requirement = LuaC.instance.compile(new ByteArrayInputStream(line.getBytes()), "script");
				LuaClosure requirementClosure = new LuaClosure(requirement, context);
				requirementClosure.call();
			}
			
			String code = scriptFile.readString("UTF-8");
			luaCode = LuaC.instance.compile(new ByteArrayInputStream(code.getBytes()), "script");
		
			LuaClosure closure = new LuaClosure(luaCode, context);
			closure.call();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
