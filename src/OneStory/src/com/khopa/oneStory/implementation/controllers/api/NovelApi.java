package com.khopa.oneStory.implementation.controllers.api;


import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

import com.khopa.oneStory.OneStoryEngine;
import com.khopa.oneStory.implementation.models.Sequence;
import com.khopa.oneStory.implementation.views.scenes.NovelScene;
import com.khopa.oneStory.services.resources.sound.SoundService;


/**
 * Visual Novel Script API
 * for OneStoryEngine
 * @author Clément Perreau
 */
public class NovelApi extends TwoArgFunction {
	
	public static p put     = new p();
	public static t setTalk = new t();
	public static choice choice= new choice();
	
	@Override
	public LuaValue call(LuaValue modname, LuaValue env) {
		LuaValue library = tableOf();
		library.set("sound", new sound());
		library.set("p", put);
		library.set("t", setTalk);
		library.set("choice", choice);
		env.set("novel", library);
		return library;
	}
	
	/**
	 * SON
	 */
	public static class sound extends OneArgFunction{
		@Override
		public LuaValue call(LuaValue name){
			SoundService.play(name.tojstring());
			return null;			
		}
	}
	
	/**
	 * Set textzone
	 */
	public static class p extends OneArgFunction{
		@Override
		public LuaValue call(LuaValue name){
			acquireDraw();
			NovelScene.getInstance().getInteractionLayer().changeText(name.tojstring());
			releaseDraw();
			waitSynchronization();
			return null;
		}
	}
	
	/**
	 * Set talking label value
	 */
	public static class t extends OneArgFunction{
		@Override
		public LuaValue call(LuaValue name){
			acquireDraw();
			NovelScene.getInstance().getInteractionLayer().setTalking(name.tojstring());
			releaseDraw();
			return null;
		}
	}
	
	/**
	 * Choice
	 */
	public static class choice extends TwoArgFunction{
		@Override
		public LuaValue call(LuaValue question, LuaValue choiceString){
			String choiceJString = choiceString.tojstring();
			String[] choices = choiceJString.split("\\|");
			acquireDraw();
			NovelScene.getInstance().setChoice(question.tojstring(), choices);
			releaseDraw();
			waitSynchronization();
			NovelScene.getInstance().getVisualLayer().removeTextOverlay();
			String choosed = NovelScene.getInstance().getChoosed();
			return LuaValue.valueOf(choosed);
		}
	}
	
	/**
	 * Wait for the user to type on the "next" button
	 */
	private static void waitSynchronization(){
		
		try {
			Sequence.getScriptSync().acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*while(!(NovelScene.getInstance().getInteractionLayer().getState() == NovelLayer.READY)){
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}*/
	}
	
	private static void acquireDraw(){
		try {
			OneStoryEngine.drawSync.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void releaseDraw(){
		OneStoryEngine.drawSync.release();
	}
	
}
