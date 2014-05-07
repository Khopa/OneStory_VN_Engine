package com.khopa.oneStory.implementation.views.scenes;

import com.khopa.oneStory.core.controllers.animation.transition.scenes.FadeOutFadeInSceneTransition;
import com.khopa.oneStory.core.views.scene.Scene;
import com.khopa.oneStory.implementation.models.Sequence;
import com.khopa.oneStory.implementation.views.layers.InteractionLayer;
import com.khopa.oneStory.implementation.views.layers.VisualLayer;
import com.khopa.oneStory.implementation.views.scenes.mainMenu.MenuScene;
import com.khopa.oneStory.services.resources.sound.MusicService;


/**
 * 
 * Visual Novel scene
 * 
 * @author Clément Perreau
 *
 */
public class NovelScene extends Scene{

	/**
	 * Sequence to render
	 */
	private Sequence model;
	
	/**
	 * Interaction layer (text and buttons)
	 */
	private InteractionLayer interactionLayer;
	
	/**
	 * Visual layer (characters and sprites)
	 */
	private VisualLayer visualLayer;
	
	/**
	 * Singleton
	 */
	private static NovelScene instance;
	
	/**
	 * Create a visual novel scene view
	 * @param x Viewport position
	 * @param y Viewport position
	 * @param w Viewport size
	 * @param h Viewport size
	 */
	public NovelScene() {
		super(-.5f,-.5f,1,1);
		this.interactionLayer = new InteractionLayer(0f, 0f, 1f, .5f, "interact");
		this.visualLayer      = new VisualLayer(0, .5f, 1, .5f, "street");
		this.model = new Sequence("main.lua");
		this.addActor(this.visualLayer);
		this.addActor(this.interactionLayer);
		this.model.start();
		instance = this;
	}
	
	// --- \\
	
	@Override
	public void act(float delta) {
		super.act(delta);
		if(!model.isAlive()){
			new FadeOutFadeInSceneTransition(new MenuScene(), 0.5f);
		}
	}
	
	// ----- API Methods ----- \\
	
	public void changeText(String newText){
		this.getInteractionLayer().changeText(newText);
	}
	
	public void setChoice(String question, String[] choices){
		this.getVisualLayer().setTextOverlay(question);
		this.getInteractionLayer().choose(choices);
	}
	
	
	// ----- Getters ------ \\
	
	public Sequence getModel() {
		return model;
	}

	public InteractionLayer getInteractionLayer() {
		return interactionLayer;
	}

	public VisualLayer getVisualLayer() {
		return visualLayer;
	}

	public static NovelScene getInstance() {
		return instance;
	}

	public String getChoosed() {
		return getInteractionLayer().getChoiceLayer().getChoosed();
	}
	
}
