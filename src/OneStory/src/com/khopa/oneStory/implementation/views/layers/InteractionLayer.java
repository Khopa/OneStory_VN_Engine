package com.khopa.oneStory.implementation.views.layers;

import com.khopa.oneStory.core.views.layers.BackgroundLayer;
import com.khopa.oneStory.core.views.layers.UILayer;
import com.khopa.oneStory.implementation.views.layers.interaction.NovelLayer;
import com.khopa.oneStory.implementation.views.layers.interaction.choice.ChoiceLayer;

public class InteractionLayer extends BackgroundLayer {
	
	/**
	 * Layout Manager
	 */
	private NovelLayer novelLayer;
	
	/**
	 * Layout Manager
	 */
	private ChoiceLayer choiceLayer;
	
	/**
	 * Current layer
	 */
	private UILayer currentLayer;
	
	
	public InteractionLayer(float x, float y, float w, float h, String background) {
		super(x, y, w, h, background);
		
		// The default Layer is the novel layer
		this.useNovelLayer();
		
	}	
	
	
	/**
	 *  Set the current ui layer 
	 */
	public void setUILayer(UILayer layer){
		if(this.currentLayer != null){
			this.currentLayer.remove();
		}
		this.currentLayer = layer;
		this.addActor(this.currentLayer);
	}
	
	/**
	 * Use the novel layer
	 */
	public void useNovelLayer(){
		this.novelLayer = new NovelLayer(this.getxPercent(), this.getyPercent(), this.getwPercent(), this.gethPercent());
		this.novelLayer.build();
		this.setUILayer(novelLayer);
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
	}
	
	/**
	 * Set a new text
	 */
	public void changeText(String newText){
		if(!(this.currentLayer.getClass() == NovelLayer.class)){
			this.useNovelLayer();
		}
		this.novelLayer.changeText(newText);
	}
	
	/**
	 * Ask a question
	 */
	public void choose(String[] choices) {
		this.choiceLayer = new ChoiceLayer(this.getxPercent(), this.getyPercent(), this.getwPercent(), this.gethPercent(), choices);
		this.choiceLayer.build();
		this.setUILayer(choiceLayer);
	}
	
	
	public void setTalking(String talker){
		novelLayer.setTalking(talker);
	}


	public ChoiceLayer getChoiceLayer() {
		return choiceLayer;
	}	
	
}
