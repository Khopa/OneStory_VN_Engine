package com.khopa.oneStory.implementation.controllers.api;


import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;


/**
 * Log api for lua
 * @author Clément Perreau
 */
public class OutApi extends TwoArgFunction {
	
	public static print   _print       = new print();
	public static println _println   = new println();
	
	@Override
	public LuaValue call(LuaValue modname, LuaValue env) {
		LuaValue library = tableOf();
		library.set("print", _print);
		library.set("println", _println);
		env.set("out", library);
		return library;
	}

	/**
	 * Print java binding
	 */
	public static class print extends OneArgFunction{
		@Override
		public LuaValue call(LuaValue name){
			System.out.print(name.tojstring());
			return null;
		}
	}
	
	/**
	 * Println java binding
	 */
	public static class println extends OneArgFunction{
		@Override
		public LuaValue call(LuaValue name){
			System.out.println(name.tojstring());
			return null;
		}
	}
	
	
	
}
