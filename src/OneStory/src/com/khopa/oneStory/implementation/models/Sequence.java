package com.khopa.oneStory.implementation.models;

import java.util.concurrent.Semaphore;

import com.khopa.oneStory.core.controllers.scripts.SequenceScript;

/**
 * A sequence is basically an action script
 * @author Clément Perreau
 */
public class Sequence extends Thread{
	
	/**
	 * Semaphore synchronization for script
	 */
	private static Semaphore scriptSync = new Semaphore(1);
	
	public static Semaphore getScriptSync() {
		return scriptSync;
	}

	/**
	 * Script Lua
	 */
	private SequenceScript script;
	
	public Sequence(String filename){
		this.script = new SequenceScript(filename, new String[]{"com.khopa.oneStory.implementation.controllers.api.NovelApi",
																"com.khopa.oneStory.implementation.controllers.api.OutApi",
																"com.khopa.oneStory.implementation.controllers.api.characters.CharactersApi"});
	}
	
	@Override
	public void run() {
		super.run();
		// A lots of method are blocking in the lua script,
		// so we have to execute the game script logic in a separate thread
		try {
			getScriptSync().acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.script.run(); 
		System.out.println("Execution finished");
	}
	
}
