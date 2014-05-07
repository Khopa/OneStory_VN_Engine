package com.khopa.oneStory.services.levels;

import java.util.ArrayList;
import java.util.List;

public class LevelService {

	/**
	 * Script base path
	 */
	private static String scriptPath = "data/scripts/";
	
	private static List<String> levels;
	
	public static void init(){
		levels = new ArrayList<String>();
		levels.add("main.lua");
	}
	
	public static List<String> getScripts(){
		return levels;
	}
	
	public static String getPath(){
		return scriptPath;
	}
	
}
