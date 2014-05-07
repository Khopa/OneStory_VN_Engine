package com.khopa.oneStory.services.resources.sound;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.khopa.oneStory.services.configuration.controllers.ConfigurationService;
import com.khopa.oneStory.services.event.controllers.EventService;
import com.khopa.oneStory.services.resources.ResourceLoadingEvent;

public class SoundService {

	/**
	 * Player de son activé ou non
	 */
	protected static boolean ENABLED = true;
	
	/**
	 * Niveau sonore (0f-1f)
	 */
	protected static float volume = 1f;
	
	/**
	 * Dossier où sont stockés les sons
	 */
	protected static String directory = "data/sfx/";
	
	/**
	 * Extension des fichiers
	 */
	protected static String extension = ".ogg";
	
	/**
	 * Liste des sons
	 */
	protected static HashMap<String, Sound> soundDictionnary;
	
	/**
	 * Initialisation
	 */
	public static void init(){
		soundDictionnary = new HashMap<String, Sound>();
		volume = ConfigurationService.getInstance().getFloatValue("sfxVolume");
	}
	
	/**
	 * Joue un son / Charge le son s'il n'existe pas
	 */
	public static void play(String name){
		if(!ENABLED) return;
		load(name);
		soundDictionnary.get(name).play(volume);
	}
	
	/**
	 * Chargement
	 */
	public static void load(String name){
		EventService.getInstance().fire(new ResourceLoadingEvent(name));
		if(!soundDictionnary.containsKey(name)){
			soundDictionnary.put(name, Gdx.audio.newSound(Gdx.files.internal(directory+name+extension)));
		}
	}
	
	/**
	 * Efface les données sur un son
	 */
	public static void dispose(String name){
		soundDictionnary.get(name).dispose();
		soundDictionnary.remove(name);
	}
	
	
	/**
	 * Niveau sonore
	 */
	public static void setVolume(float value){
		volume = value;
	}
	
	public static float getVolume(){
		return volume;
	}
	
	
	
}
