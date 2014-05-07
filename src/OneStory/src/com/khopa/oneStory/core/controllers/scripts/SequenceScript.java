package com.khopa.oneStory.core.controllers.scripts;

import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaValue;

/**
 * 
 * Script Lua pour Dwarves Manager
 * 
 * @author Clément Perreau
 *
 */
public class SequenceScript extends LuaScript{

	/**
	 * Init Sequence
	 */
	protected LuaFunction luaInit;
	
	/**
	 * Setup Sequence
	 */
	protected LuaFunction luaSetup;
	
	/**
	 * Main Sequence
	 */
	protected LuaFunction luaMain;
	
	/**
	 * Event Handler
	 */
	protected LuaFunction luaEvent;
	
	/**
	 * Api
	 */
	protected LuaValue api;
	
	/**
	 * Constructeur d'un script Dwarves Manager
	 * @param filename Fichier de script Dwarves Manager
	 */
	public SequenceScript(String script, String[] apis) {
		super(script, apis);
		load();
	}
	
	/**
	 * Recherche dans le script les fonctions souhaitée
	 */
	private void load() {
		luaInit  = (LuaFunction) context.get("init");
		luaSetup = (LuaFunction) context.get("setup");
		luaMain   = (LuaFunction) context.get("main");
		
		try{
			luaEvent = (LuaFunction) context.get("onEvent");
		}
		catch(ClassCastException e){
			luaEvent = null;
		}
		
	}
	
	public void init(){
		luaInit.call();
	}

	public void setup(){
		luaSetup.call();
	}
	
	public void run(){
		System.out.println("Running");
		luaMain.call();
	}

}
